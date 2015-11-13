package com.grcms.im.ronghub.api.dao;

import com.grcms.core.exception.ECAuthException;
import com.grcms.im.ronghub.api.domain.RonghubDetail;

/**
 * @Author: jiepeng
 * @Date:2015/11/13 0013
 * @Description:
 */
public interface AuthDao {

    /**
     * Execute authentication to ronghub server
     * @param userId
     * @return
     * @throws ECAuthException
     */
    RonghubDetail callRonghubAuth(String userId,String username,String portraitUri) throws ECAuthException;
}
