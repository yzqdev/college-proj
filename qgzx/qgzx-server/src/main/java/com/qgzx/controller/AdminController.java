package com.qgzx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qgzx.constant.Constants;
import com.qgzx.dto.Result;
import com.qgzx.entity.Admin;
import com.qgzx.service.AdminService;
import com.qgzx.util.JwtUtil;
import com.qgzx.util.ResultEnum;
import com.qgzx.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 前端控制器
 *
 * @author yzq
 * @since 2020-04-16
 */
@RestController
@RequestMapping("/admin")

@Api(value = "管理登录", tags = "管理员")
public class AdminController {
    @Resource
    private AdminService adminService;


    @PostMapping("/login")
    public Result adminLogin(@RequestBody Admin admin, HttpSession session) {


        try {

            if (admin == null) {
                return ResultUtil.fail(ResultEnum.USER_NOT_EXIST);
            }
            //登录的id
            String name = admin.getName();

            // 登录的密码
            String pass = admin.getPass();
            if (pass == null) {
                return ResultUtil.fail(ResultEnum.DATA_IS_NULL);
            }
            //手机号不为空

            if (!"".equals(name)) {
                try {
                    Admin selectUser = adminService.getOne(new QueryWrapper<Admin>().eq("name", name));
                    System.out.println(selectUser);
                    if (selectUser == null) {
                        System.out.println("这里是");
                        return ResultUtil.fail(ResultEnum.USER_NOT_EXIST);
                    } else {
                        if (pass.equals(selectUser.getPass())) {
                            //登录成功后生成JWT
                            //JWT的header部分,该map可以是空的,因为有默认值{"alg":HS256,"typ":"JWT"}

                            String token = JwtUtil.sign(name, selectUser.getUserCode());
                            System.out.println(token);
                            return ResultUtil.success("成功", token); // 登录成功
                        } else {
                            // 密码错误
                            return ResultUtil.fail(ResultEnum.REQUIRE_PASS);
                        }
                    }
                    // 用户不存在
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            return ResultUtil.fail(ResultEnum.UNKNOWN_ERROR);
        }
        return null;
    }

    @ApiOperation("验证登录")
    @ResponseBody
    @GetMapping("/verify")
    public Result verifyLogin(HttpServletRequest request) throws Exception {

        try {
            //创建验证对象,这里使用的加密算法和密钥必须与生成TOKEN时的相同否则无法验证
            Admin u = (Admin) request.getAttribute(Constants.USER_ATTR);
            System.out.println(u);
            System.out.println("user=...");
            return ResultUtil.success("获取成功 ", u);
        } catch (Exception err) {
            throw new Exception("验证错误:" + err.getMessage());
        }
    }

    @PostMapping("/reg")
    public Result addAdmin(@RequestBody Admin admin) {
        try {

            boolean newadmin = adminService.save(admin);
            System.out.println(newadmin);
            return ResultUtil.success("添加成功", admin);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.fail("添加失败");
    }

    @GetMapping("/getAllAdmins")
    public Result getAllAdmins(@RequestParam("isSuper") String isSuper) {
        List<Admin> adminList;
        try {
            if ("".equals(isSuper)) {
                adminList = adminService.list();
                System.out.println(adminList);
            } else {
                adminList = adminService.getAllAdmins(isSuper);
            }


            return ResultUtil.success("获取成功", adminList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.fail("失败了");
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public Result deleteAdmin(@PathVariable("id") String id) {
        try {
            adminService.removeById(id);
            return ResultUtil.success("成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.fail("失败了");
    }

    @PutMapping("/updateAdmin")
    public Result updateAdmin(@RequestBody Admin admin) {
        try {
            adminService.updateById(admin);
            return ResultUtil.success("成功", admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.fail("失败了");
    }
    @PostMapping("/post")
    public Result postAdmin(Admin admin){

        return ResultUtil.success("成功",admin);
    }
}
