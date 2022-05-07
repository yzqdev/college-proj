package com.qgzx.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.qgzx.entity.Admin;
import com.qgzx.mapper.AdminMapper;
import com.qgzx.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qgzx.util.JwtUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yzq
 * @since 2020-04-16
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Resource
    private AdminMapper adminMapper;


    @Override
    public String login(Admin admin) {
        System.out.println(admin);

        return null;

    }


    @Override
    public List<Admin> getAllAdmins(String isSuper) {

        return adminMapper.getAllAdmins(isSuper);
    }
}
