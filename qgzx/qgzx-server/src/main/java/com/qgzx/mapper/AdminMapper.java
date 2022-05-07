package com.qgzx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qgzx.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Yangzhengqian
 * @Description:
 * @Date:Created time 2020/4/16 13:11
 * @Modified By:
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    @Select("select * from admin where isSuper= ${isSuper}")
    List<Admin> getAllAdmins(String isSuper);
    @Select("select * from admin where name=#{name}")
    Admin getAdminByName(String name);

}
