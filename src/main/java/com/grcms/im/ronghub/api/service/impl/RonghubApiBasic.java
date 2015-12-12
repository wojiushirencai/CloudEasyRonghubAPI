/* 
 * Globalroam 2015 @copyright 
 */
package com.grcms.im.ronghub.api.service.impl;

import com.grcms.common.util.CommonUtility;
import com.grcms.core.exception.ECInitException;

import java.util.Properties;

/**
 * @Author: jiepeng
 * @Date:2015/11/13 0013
 * @Description:
 */
public class RonghubApiBasic {
    private static final String appKey;
    private static final String appSecret;

    static {
        Properties p = CommonUtility.getPropertyFile("ronghub.properties");
        appKey = (String) p.get("appKey");
        appSecret = (String) p.get("appSecret");
        if(!CommonUtility.isNonEmpty(appKey) || !CommonUtility.isNonEmpty(appKey) ) {
            try {
                throw new ECInitException("Init ronghub failed.");
            } catch (ECInitException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getAppKey() {
        return appKey;
    }
    public static String getAppSecret() {
        return appSecret;
    }
}
