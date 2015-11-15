package com.grcms.im.ronghub.api.dao;

import com.grcms.basic.MybatisBaseDao;
import com.grcms.im.ronghub.api.domain.RonghubDetail;
import com.grcms.im.ronghub.api.exception.ECRonghubDetailException;

/**
 * @Author: jiepeng
 * @Date:2015/11/13 0013
 * @Description:
 */
public interface RonghubApiDao extends MybatisBaseDao<RonghubDetail>{

    /**
     * Get by user id
     * @param userId
     * @return
     * @throws ECRonghubDetailException
     */
    RonghubDetail getByUserId(String userId) throws ECRonghubDetailException;

    /**
     * Get by token
     * @param token
     * @return
     * @throws ECRonghubDetailException
     */
    RonghubDetail getByToken(String token) throws ECRonghubDetailException;

}
