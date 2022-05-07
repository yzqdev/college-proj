package com.qgzx.interceptor;

import com.qgzx.constant.Constants;
import com.qgzx.entity.Admin;
import com.qgzx.util.JwtUtil;
import com.qgzx.util.UserUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserIntercepter implements HandlerInterceptor {


    /**
     * 进入controller之前进行拦截
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (token == null) {
            token = request.getParameter("token");
        }

        if (token != null) {
            String userCode = JwtUtil.getUserCode(token);
            //创建验证对象,这里使用的加密算法和密钥必须与生成TOKEN时的相同否则无法验证
            //request.setAttribute(Constants.JWT_USERID, userId);
            System.out.println("userid="+userCode);
            Admin user = UserUtil.getUserByUserCode(userCode);
            System.out.println("usr="+user.toString());
            request.setAttribute(Constants.USER_ATTR, user);

        }

        //sendJsonMessage(response,"身份验证失败，请重新登陆");
        return true;
    }
    /**
     * 响应数据给前端
     * @param response
     * @param obj
     */


}
