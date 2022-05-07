package com.qgzx.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qgzx.entity.Admin;
import com.qgzx.service.AdminService;

import javax.annotation.Resource;

/**
 * @author yzq
 * @description
 * @date:Created time 2021/8/11 22:02
 * @modified By:
 */
public class UserUtil {
    public static Admin getUserByUserCode(String userCode) {

        Admin u = new Admin();
        u.setUserCode(userCode);

        return u.selectOne(new QueryWrapper<>(u));

    }
}
