/* 
 * Globalroam 2015 @copyright 
 */
package com.grcms.im.ronghub.api.interceptor;

import com.grcms.common.util.CommonUtility;
import com.grcms.core.exception.ECAuthException;
import com.grcms.frontend.service.MemberService;
import com.grcms.im.ronghub.api.domain.RonghubDetail;
import com.grcms.im.ronghub.api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: jiepeng
 * @Date:2015/11/20 0020
 * @Description:
 */
@Component
public class RequestParameterInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private MemberService memberService;

    @Autowired
    private AuthService authService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //if request uri is "/api/auth" then direct return true.
        String uri = request.getRequestURI();
        if(uri.endsWith("/api/auth")) {
            return true;
        }

        //get token and userId from header and check whether these parameters correct.
        String token = request.getHeader("token");
        String userId = request.getHeader("userId");
        //if token or userId is empty then throw exceptions;
        if(!CommonUtility.isNonEmpty(token) || !CommonUtility.isNonEmpty(userId)) {
            throw new ECAuthException("Token or userId can not be empty.");
        }

        RonghubDetail detail = authService.findByToken(token);
        if(null == detail) {
            throw new ECAuthException("Token " + token + " is not correct.");
        }

        if(!detail.getUserId().equals(userId)) {
            throw new ECAuthException("User id " + userId + " is not correct.");
        }


        return super.preHandle(request, response, handler);
    }
}