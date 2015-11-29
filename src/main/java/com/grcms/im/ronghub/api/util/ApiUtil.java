package com.grcms.im.ronghub.api.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2015/11/29.
 */
public class ApiUtil {

    public static String getRequestToken(HttpServletRequest req) {
        return req.getHeader("token");
    }

    public static String getRequestUserId(HttpServletRequest req) {
        return req.getHeader("userId");
    }
}
