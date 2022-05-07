package com.examweb.group.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.examweb.group.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/2
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    /**
     * @Description: 普通用户根据用户名和密码取出账号
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @Select("select * from account where name=#{name} and password=#{password} and is_delete=0 and account_style=0")
    Account getAccountByNameAndPassword(@Param("name")String name,@Param("password")String password);

    /**
     * @Description: 普通管理员根据用户名和密码取出账号
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @Select("select * from account where name=#{name} and password=#{password} and is_delete=0 and account_style=1")
    Account getManagerByNameAndPassword(@Param("name")String name,@Param("password")String password);


    /**
     * @Description: 超级管理员根据用户名和密码取出账号
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @Select("select * from account where name=#{name} and password=#{password} and is_delete=0 and account_style=2")
    Account getSuperByNameAndPassword(@Param("name")String name,@Param("password")String password);

    /**
     * @Description: 根据用户名取出账号
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @Select("select * from account where name=#{name} and is_delete=0")
    Account getAccountByName(@Param("name")String name);

    /**
     * @Description: 取出所有的管理员
     * @Json:
     * @Date: 2018/7/4
     * @Return:
     */
    @Select("select * from account where account_style=1 and is_delete=0")
    List<Account>  selectAllManager();

    /**
     * @Description: 取出所有的账户
     * @Json:
     * @Date: 2018/7/5
     * @Return:
     */
    @Select("select * from account where is_delete=0")
    List<Account> selectAllAccounts();



}
