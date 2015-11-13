package com.grcms.im.ronghub.api.service;

import com.grcms.core.exception.ECAuthException;
import com.grcms.im.ronghub.api.domain.RonghubDetail;

/**
 * @Author: jiepeng
 * @Date:2015/11/13 0013
 * @Description:
 */
public interface AuthService {
    /**
     * Execute authentication
     * @param userId
     * @param username
     * @param portraitUri
     * @return
     * @throws ECAuthException
     */
    RonghubDetail executeAuth(String userId,String username,String portraitUri) throws ECAuthException;
}
