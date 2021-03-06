package com.hfut.glxy.controller;

import com.hfut.glxy.dto.LoginBody;
import com.hfut.glxy.dto.Result;
import com.hfut.glxy.entity.Student;
import com.hfut.glxy.service.StudentService;
import com.hfut.glxy.utils.ResultUtil;
import com.hfut.glxy.utils.StringRandom;
import com.hfut.glxy.vcode.Captcha;
import com.hfut.glxy.vcode.GifCaptcha;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenliangliang
 * @date 2017/12/27
 */
@Controller
@RequestMapping(value = "/login")
//@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.DELETE}, allowedHeaders = "*")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);


    private JavaMailSender sender;

    private TemplateEngine templateEngine;

    private StudentService studentService;

    @Value("${spring.mail.username}")
    private String from;


    @Autowired
    protected LoginController(JavaMailSender sender, TemplateEngine templateEngine,
                              StudentService studentService) {
        this.sender = sender;
        this.templateEngine = templateEngine;
        this.studentService = studentService;
    }

    /**
     * ????????????
     *
     * @param loginBody
     * @param session
     * @param result
     * @return
     */
    @PostMapping("/stu")
    @ResponseBody
    public Result login(@Valid @RequestBody LoginBody loginBody, HttpSession session,
                        BindingResult result) {
        if (result.hasErrors()) {
            return ResultUtil.fail(result.getFieldErrors().toString());
        }
        //????????????????????????
        String code_expired = (String) session.getAttribute("v_code");
        if (code_expired == null) {
            logger.error("??????????????????");
            return ResultUtil.fail("??????????????????!");
        }

        String[] str = StringUtils.split(code_expired, "#");
        String code = str[0];
        if (!StringUtils.equalsIgnoreCase(code, loginBody.getCode())) {
            logger.error("???????????????");
            return ResultUtil.fail("???????????????!");
        }
        long expired = Long.parseLong(str[1]);
        if (expired < System.currentTimeMillis()) {
            logger.error("??????????????????");
            return ResultUtil.fail("??????????????????!");
        }

        //??????????????????
        Student stu = studentService.getLoginInfo(loginBody.getEmail());
        if (stu == null) {
            logger.error("???????????????");
            return ResultUtil.fail("???????????????");
        }

        if (stu.getStatus() != 0) {
            logger.error("??????????????????");
            return ResultUtil.fail("??????????????????");
        }

        if (!StringUtils.equals(stu.getPassword(), loginBody.getPassword())) {
            logger.error("????????????");
            return ResultUtil.fail("????????????");
        }

        //??????????????????????????????????????????session
        session.removeAttribute("v_code");
        session.setAttribute("sid", stu.getId());
        session.setAttribute("role", 0);
        //??????????????????


        //????????????????????????
        Map<String, Object> map = new HashMap<>(6);
        map.put("id", stu.getId());
        map.put("name", stu.getName());
        map.put("img", stu.getImg());
        return ResultUtil.OK(map);

    }

    /**
     * ????????????
     *
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public Result register(@Valid @RequestBody LoginBody loginBody, HttpSession session,
                           BindingResult result) {
        if (result.hasErrors()) {
            return ResultUtil.fail(result.getFieldErrors().toString());
        }
        if (StringUtils.isEmpty(loginBody.getName())) {
            return ResultUtil.fail("?????????????????????");
        }
        System.out.println("?????????sessionid: " + session.getId());
        //???????????????
        String code_expired = (String) session.getAttribute("code");
        if (code_expired == null) {
            logger.error("??????????????????");
            return ResultUtil.fail("??????????????????!");
        }
        session.removeAttribute("code");
        String[] str = StringUtils.split(code_expired, "#");
        String code = str[0];
        if (!StringUtils.equals(code, loginBody.getCode())) {
            logger.error("???????????????");
            return ResultUtil.fail("???????????????!");
        }
        long expired = Long.parseLong(str[1]);
        if (expired < System.currentTimeMillis()) {
            logger.error("??????????????????");
            return ResultUtil.fail("??????????????????!");
        }
        Student stu = new Student();
        stu.setName(loginBody.getName());
        stu.setEmail(loginBody.getEmail());
        stu.setPassword(loginBody.getPassword());
        if (studentService.save(stu)) {
            session.removeAttribute("code");
            return ResultUtil.OK();
        } else {
            return ResultUtil.fail("????????????");
        }
    }


    /**
     * ??????????????????
     *
     * @param request
     * @return
     */
    @GetMapping("/logout")
    @ResponseBody
    public Result logout(HttpServletRequest request) {

        //????????????Session
        HttpSession session = request.getSession(false);
        //logger.info("?????? "+session.getAttribute("studentId").toString()+" ????????????");
        //// ??????session??????
        if (session == null) {
            return ResultUtil.OK();
        }
        Enumeration<String> names = session.getAttributeNames();
        while (names.hasMoreElements()) {
            session.removeAttribute(names.nextElement());
        }
        session.invalidate();

        return ResultUtil.OK();
    }


    /**
     * ?????????????????????
     *
     * @param map
     * @return
     */
    @PostMapping("/valid")
    @ResponseBody
    public Result validEmail(@RequestBody Map<String, Object> map) {
        String email = (String) map.get("email");
        if (email == null) {
            return ResultUtil.fail("??????????????????");
        }

        if (studentService.isExistByEmail(email)) {
            return ResultUtil.fail("?????????????????????");
        }
        return ResultUtil.OK();
    }

    /**
     * ??????????????????Gif?????????
     *
     * @param response
     */
    @GetMapping(value = "/getGifCode")
    public void getGifCode(HttpServletResponse response, HttpSession session) {
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");
            /**
             * gif?????????????????????
             * ?????????????????????
             */
            Captcha captcha = new GifCaptcha(146, 33, 4);
            //??????
            captcha.out(response.getOutputStream());
            //??????Session
            long expired = System.currentTimeMillis() + 60000;
            //session.removeAttribute("v_code");
            session.setAttribute("v_code", captcha.text() + "#" + expired);
            System.out.println(captcha.text() + "#" + expired);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("????????????????????????" + e.getMessage());
        }

    }


    @GetMapping("/mail")
    @ResponseBody
    public Result sendMail() {

        //MimeMessage mimeMessage=sender.createMimeMessage();
        //MimeMailMessage message=new MimeMailMessage(mimeMessage);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo("3304734570@qq.com");
        message.setSubject("??????????????????");
        message.setText("??????????????????");

        try {
            sender.send(message);
            logger.info("???????????????????????????");
            return ResultUtil.OK("??????????????????");
        } catch (Exception e) {
            logger.error("????????????????????????????????????", e);
            return ResultUtil.fail("?????????????????????????????????");
        }

    }


    @GetMapping("/attach")
    @ResponseBody
    public Result sendAttachmentsMail() {
        MimeMessage mimeMessage = sender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo("3304734570@qq.com");
            helper.setSubject("????????????????????????");
            helper.setText("<html><body><img src=\"http://image.chenliangliang.xin/denghuo\" /></body></html>", true);
            FileSystemResource file = new FileSystemResource(new File("F:/test/5f68e4c19a79b56b2369c149b620b4ce.jpg"));
            helper.addAttachment("??????-1.jpg", file);

            sender.send(mimeMessage);
            logger.info("???????????????????????????");
            return ResultUtil.OK("??????????????????");
        } catch (Exception e) {
            logger.error("????????????????????????????????????", e);
            return ResultUtil.fail("?????????????????????????????????");
        }
    }


    /**
     * ????????????
     *
     * @param req
     * @param map
     * @return
     */
    @PostMapping("/email")
    @ResponseBody
    public Result sendTemplateMail(HttpServletRequest req, @RequestBody Map<String, Object> map) {

        String to = (String) map.getOrDefault("email", "0");
        if (StringUtils.equals(to, "0")) {
            return ResultUtil.fail("??????????????????");
        }
        MimeMessage mimeMessage = sender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from, "???????????????????????????");
            helper.setTo(to);
            helper.setSubject("????????????");
            //?????????
            String code = StringRandom.generateCode(4);
            //????????????
            long expired = System.currentTimeMillis() + 3600000;
            Context context = new Context();
            context.setVariable("email", to);
            context.setVariable("code", code);

            String text = templateEngine.process("email", context);

            helper.setText(text, true);
            sender.send(mimeMessage);
            //??????session
            HttpSession session = req.getSession(true);
            session.setAttribute("code", code + "#" + expired);
            System.out.println("?????????sessionid: " + session.getId());
            logger.info("?????????????????????");
            return ResultUtil.OK("??????????????????");
        } catch (Exception e) {
            logger.error("??????????????????????????????", e);
            return ResultUtil.fail("???????????????????????????");
        }
    }


    @GetMapping("/status")
    @ResponseBody
    public Result getLoginStatus(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie);
            System.out.println("value: " + cookie.getValue());
        }
        return ResultUtil.fail("test");
    }


    @PostMapping("/status")
    @ResponseBody
    public Result getLoginStatus1(@RequestBody Map<String,Object> map, HttpSession session){

        String sid=(String)session.getAttribute("sid");
        System.out.println("sid: "+sid);
        String id=(String) map.get("id");
        System.out.println("id: "+id);
        if(StringUtils.equals(sid,id)){
            return ResultUtil.OK();
        }
       return ResultUtil.fail("session????????????????????????");
    }
}
