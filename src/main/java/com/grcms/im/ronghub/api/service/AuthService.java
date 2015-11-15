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
     * @param username
     * @param password md5 digest password
     * @return
     * @throws ECAuthException
     */
    RonghubDetail executeAuth(String username,String password) throws ECAuthException;

    /**
     * Find by token
     * @param token
     * @return
     * @throws ECAuthException
     */
    RonghubDetail findByToken(String token) throws ECAuthException;

    /**
     * Find by user id
     * @param userId
     * @return
     * @throws ECAuthException
     */
    RonghubDetail findByUserId(String userId) throws ECAuthException;
}
