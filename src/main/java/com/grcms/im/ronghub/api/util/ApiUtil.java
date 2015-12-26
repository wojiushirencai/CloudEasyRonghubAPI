package com.grcms.im.ronghub.api.util;

import com.grcms.common.util.CommonUtility;
import com.grcms.core.util.ForwardUtility;
import com.grcms.core.util.HttpUtility;

import javax.servlet.http.HttpServletRequest;
import java.net.HttpURLConnection;

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
    public static String generatePortraitUrl(HttpServletRequest req,String portraitUrl) {
        if(!CommonUtility.isNonEmpty(portraitUrl)) {
            return null;
        }
        String host = HttpUtility.getHostURL(req);
        String ctx = req.getContextPath();
        return host + ForwardUtility.processSlash(ctx) + ForwardUtility.processSlash(portraitUrl);
    }
}
