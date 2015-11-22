package com.grcms.im.ronghub.api.dao;

import com.grcms.basic.MybatisBaseDao;
import com.grcms.im.ronghub.api.domain.Attendence;
import com.grcms.im.ronghub.api.domain.RonghubDetail;
import com.grcms.im.ronghub.api.exception.ECAttendenceException;
import com.grcms.im.ronghub.api.exception.ECRonghubDetailException;

/**
 * @Author: jiepeng
 * @Date:2015/11/13 0013
 * @Description:
 */
public interface AttendenceDao extends MybatisBaseDao<Attendence>{

    /**
     * Get by user id
     * @param userId
     * @return
     * @throws ECAttendenceException
     */
    Attendence getByUserId(String userId) throws ECAttendenceException;


}
