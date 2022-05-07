package com.examweb.group.controller;

import com.examweb.group.dto.Result;
import com.examweb.group.entity.Account;
import com.examweb.group.service.AccountService;
import com.examweb.group.service.SchoolService;
import com.examweb.group.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jessiecaicai
 * @Description: 所有角色通用的接口集
 * @Date:Created in 2018/7/3
 */
@RestController
@RequestMapping(value = "/commonUser")
public class CommonActionController {
@Resource
    private AccountService accountService;
@Resource
    private SchoolService schoolService;



    ///**
    // * @Description: 基本主页
    // * @Json:
    // * @Date: 2018/7/3
    // * @Return:
    // */
    //@GetMapping("/index")
    //public String index(){
    //    return "student/index";
    //}




    /**
     * @Description: 根据province取出学校名字列表
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @RequestMapping(value = "/getSchoolNameByProvince/{province}",method = RequestMethod.GET)
    public Result getSchoolNameByProvince(@PathVariable("province") String province){
        try {
            //String province=examWeb;
            if (province==null||province.trim().isEmpty()){
                return ResultUtil.fail("请求的省市不能为空");
            }
            List<String> listName=new ArrayList<>();
            listName=schoolService.getSchoolNameByProvince(province);
            return ResultUtil.OK(listName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.selectError();
    }

    /**
     * @Description: 取出所有学校
     * @Json:
     * @Date: 2018/7/5
     * @Return:
     */
    @GetMapping("/getAllSchools")
   
    public Result getAllSchools(){
        try {
            List<String> list=schoolService.getAllSchools();
            return ResultUtil.OK(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.selectError();
    }
}
