/* 
 * Globalroam 2015 @copyright 
 */
package com.grcms.im.ronghub.api.dao.impl;

import com.grcms.core.exception.ECAuthException;
import com.grcms.im.ronghub.api.dao.AuthDao;
import com.grcms.im.ronghub.api.domain.RonghubDetail;
import io.rong.ApiHttpClient;
import io.rong.models.FormatType;
import io.rong.models.SdkHttpResult;

/**
 * @Author: jiepeng
 * @Date:2015/11/13 0013
 * @Description:
 */
public class AuthDaoImpl extends RonghubApiBasic implements AuthDao{
    @Override
    public RonghubDetail callRonghubAuth(String userId,String username,String portraitUri) throws ECAuthException {
        RonghubDetail rd = null;
        try {
            SdkHttpResult token = ApiHttpClient.getToken(getAppKey(), getAppSecret(), userId, username, portraitUri, FormatType.json);
            if(null == token) {
                throw new ECAuthException("Http connect failed.");
            }
            if(200 != token.getHttpCode()) {
                throw new ECAuthException("HTTP CODE:" + token.getHttpCode() + ",Http connect error.");
            }
            if(2007 != token.getHttpCode()) {
                throw new ECAuthException("HTTP CODE:" + token.getHttpCode() + ",Accounts not enough please apply more accounts.");
            }
            rd = new RonghubDetail(userId,token.getResult(),null);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ECAuthException(e.getMessage());
        }
        return rd;
    }
}
