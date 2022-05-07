package com.examweb.group.controller;

import com.examweb.group.dto.Result;
import com.examweb.group.entity.Account;
import com.examweb.group.entity.School;
import com.examweb.group.entity.TimeInfo;
import com.examweb.group.mapper.SchoolMapper;
import com.examweb.group.service.AccountService;
import com.examweb.group.service.SchoolService;
import com.examweb.group.service.TimeInfoService;
import com.examweb.group.utils.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/3
 */
@RequestMapping("/superManager")
@RestController
public class SuperManagerController {
@Resource
    private AccountService accountService;
    @Resource
    private SchoolService schoolService;
    @Resource
    private TimeInfoService timeInfoService;



    /**
     * @Description: 用于超级管理员登录的接口
     * @Json: {
    "name": "string",
    "password": "string"
    }
     * @Date: 2018/7/3
     * @Return:
     */
    @PostMapping("/superLogin")
   
    public Result superLogin(@RequestBody Account account, HttpSession session) {
        String name=account.getName();
        String password=account.getPassword();
        if (name==null||name.trim().isEmpty()){
            return ResultUtil.fail("输入用户名不能为空");
        }
        if (password==null||password.trim().isEmpty()){
            return ResultUtil.fail("输入密码不能为空");
        }
        try {
            if (accountService.checkSuperIsExist(name,password)==0){
                Account accountGet=accountService.getSuperByNameAndPassword(name,password);
                //System.out.print(accountGet.toString());
                session.setAttribute("account",accountGet);
                //session.setAttribute("accountId",accountGet.getId());
                //session.setAttribute("name",accountGet.getName());
                //session.setAttribute("certificateStyle",accountGet.getCertificateStyle());
                //session.setAttribute("crtificateNumber",accountGet.getCertificateNumber());
                //System.out.print(accountGet.getAccountStyle());
                return ResultUtil.OK(accountGet);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.fail("登入失败");
    }

    /**
     * @Description: 超级管理员给普通管理员分配账号+绑定学校
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
   @PostMapping("/designAccount/{name}/{password}/{zhaoshengUnit}")
  
    public Result designAccount(@PathVariable("name")String name,@PathVariable("password")String password,@PathVariable("zhaoshengUnit")String zhaoshengUnit){
       //,@PathVariable("phone")String phone
       try {
           //判断该用户名是否可以增加
           Account accountName;
           System.out.print(name);
           accountName=accountService.getAccountByName(name);
           //System.out.print(accountName.toString());
           //System.out.print("a");
           if (accountName!=null){
               return ResultUtil.fail("账号名已经存在");
           }
           //System.out.print("aaa");
           School school;
           School school1;
           school=schoolService.getSchoolByName(zhaoshengUnit);
           school1=schoolService.getSchoolByName("南开大学");

           System.out.print(school.toString());
           System.out.print(school1.toString());
           //判断该学校是否已经分配管理员
           if (!school.getAccountId().equals("无绑定")){
               return ResultUtil.fail("该学校已经有管理员了");
           }
           //获取
           Account account=new Account();
           account.setId(UUID.randomUUID().toString().replaceAll("-",""));
           account.setName(name);
           account.setPassword(password);
           account.setPhone("管理员电话");
           account.setEmail("管理员邮件");
           account.setCertificateStyle("0");
           account.setCertificateNumber("管理员证件号码");
           account.setAccountStyle("1");
           account.setCreateTime(new Date(System.currentTimeMillis()));
           account.setUpdateTime(new Date(System.currentTimeMillis()));
           account.setIsDelete("0");
           System.out.println(account.toString());
           accountService.save(account);
           school.setAccountId(account.getId());
           school.setUpdateTime(new Date(System.currentTimeMillis()));
           schoolService.updateById(school);
           return ResultUtil.OK();
       }catch (Exception e){
           e.printStackTrace();
       }
       return ResultUtil.fail("新增管理员失败");
   }

   /**
    * @Description: 超级管理员查看已分配的管理员
    * @Json:
    * @Date: 2018/7/4
    * @Return:
    */
   @GetMapping("/selectManager/{pageNum}")
  
    public Result selectManager(@PathVariable("pageNum") Integer pageNum){
       if (pageNum<=0){
           pageNum=1;
       }
       try {
           PageInfo<Account> accountPageInfo=accountService.selectAllManager(pageNum);
           return ResultUtil.OK(accountPageInfo);
       }catch (Exception e){
           e.printStackTrace();
       }
       return ResultUtil.selectError();
   }

   /**
    * @Description: 超级管理员更新管理员
    * @Json:
    * @Date: 2018/7/5
    * @Return:
    */
    @PostMapping("/updateManager")
   
    public Result updateManager(@RequestBody @Valid Account account,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultUtil.fail(bindingResult.getAllErrors().toString());
        }
        System.out.print(account.toString());
        String  id=account.getId();
        String name=account.getName();
        String password=account.getPassword();
        try {
            Account accountGet;
            accountGet=accountService.getById(id);
            accountGet.setName(name);
            accountGet.setPassword(password);
            System.out.print(accountGet.toString());
            if (accountService.updateById(accountGet)){
                return ResultUtil.OK(accountGet);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  ResultUtil.updateError();
    }

    /**
     * @Description: 超级管理员删除已分配的管理员
     * @Json:
     * @Date: 2018/7/5
     * @Return:
     */
    @DeleteMapping("/deleteManager/{id}")
   
    public Result deleteManager(@PathVariable("id")String id){
        try {
            Account account=new Account();
            account=accountService.getById(id);
            account.setIsDelete("1");
            if (accountService.updateById(account)){
             return ResultUtil.OK(account);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  ResultUtil.fail("删除失败");

    }

    /**
     * @Description: 超级管理员根据id获取管理员account
     * @Json:
     * @Date: 2018/7/5
     * @Return:
     */
    @GetMapping("/getManagerById/{id}")
   
    public Result getManagerById(@PathVariable("id")String id){
        if (id==null||id.trim().isEmpty()){
            return ResultUtil.fail("id不能为空");
        }
        try {
            Account account=new Account();
            account=accountService.getById(id);
            System.out.print(account.toString());
            return ResultUtil.OK(account);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.selectError();
    }

    /**
     * @Description: 超级管理员查看所有的已注册账户
     * @Json:
     * @Date: 2018/7/5
     * @Return:
     */
    @GetMapping("/getAllAcounts/{PageNum}")
   
    public Result getAllAcounts(@PathVariable("PageNum")Integer PageNum){
        if (PageNum<=0){
            PageNum=1;
        }
        try {
            PageInfo<Account> accountPageInfo=accountService.selectAllAcounts(PageNum);
            return ResultUtil.OK(accountPageInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.selectError();
    }

    ///**
    // * @Description: 超级管理员更新时间
    // * @Json:
    // * @Date: 2018/7/6
    // * @Return:
    // */
    //@RequestMapping("/updateTime")
    //@CrossOrigin
    //public Result updateTime(@RequestBody Map<String,Timestamp> map){
    //    try {
    //        for(Map.Entry<String,Timestamp> entry : map.entrySet()){
    //            //System.out.println(entry.getKey()+":"+entry.getValue());
    //            String id = entry.getKey();
    //            //System.out.println(id);
    //            Timestamp timestamp=timeInfoService.getContentById(id);
    //            //System.out.println(timestamp);
    //            if (timestamp!=entry.getValue()){
    //                TimeInfo timeInfo=new TimeInfo();
    //                timeInfo=timeInfoService.selectById(id);
    //                Timestamp timestamp1=entry.getValue();
    //                timeInfo.setContent(timestamp1);
    //                timeInfoService.updateById(timeInfo);
    //            }
    //
    //        }
    //        return ResultUtil.OK();
    //    }catch (Exception e){
    //        e.printStackTrace();
    //    }
    //    return ResultUtil.fail("失败");
    //}

    /**
     * @Description: 超级管理员更新时间
     * @Json:
     * @Date: 2018/7/6
     * @Return:
     */
    @PutMapping("/updateTime")
   
    public Result updateTime(@RequestBody Map<String,String> map){
        try {
            for(Map.Entry<String,String> entry : map.entrySet()){
                //System.out.println(entry.getKey()+":"+entry.getValue());
                String id = entry.getKey();
                //System.out.println(id);
                String content=timeInfoService.getContentById(id);
                //System.out.println(timestamp);
                if (content!=entry.getValue()){
                    TimeInfo timeInfo=new TimeInfo();
                    timeInfo=timeInfoService.getById(id);
                    String newValue=entry.getValue();
                    timeInfo.setContent(newValue);
                    timeInfoService.updateById(timeInfo);
                }

            }
            return ResultUtil.OK();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.fail("失败");
    }
}
