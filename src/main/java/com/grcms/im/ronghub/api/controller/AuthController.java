package com.grcms.im.ronghub.api.controller;

import com.grcms.core.exception.ECAuthException;
import com.grcms.core.response.JsonResponse;
import com.grcms.frontend.service.MemberService;
import com.grcms.im.ronghub.api.domain.RonghubDetail;
import com.grcms.im.ronghub.api.service.AuthService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2015/11/15.
 */

@RestController
@RequestMapping("/api")
public class AuthController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(AuthController.class);
    private static final String AJAX_REQUEST = "XMLHttpRequest";

    @Autowired
    private AuthService authService;
    @Autowired
    private MemberService memberService;

    /**
     * authentication method
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public JsonResponse auth(HttpServletRequest request, HttpServletResponse response
            ,@RequestParam("username") String username
            ,@RequestParam("password") String password) throws ECAuthException {
        JsonResponse res = new JsonResponse();
        RonghubDetail detail = authService.executeAuth(username, password);
        res.setResponse(detail);
        return res;
    }
}

