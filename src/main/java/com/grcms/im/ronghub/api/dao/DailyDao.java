package com.grcms.im.ronghub.api.dao;

import com.grcms.basic.MybatisBaseDao;
import com.grcms.im.ronghub.api.domain.Attendence;
import com.grcms.im.ronghub.api.domain.Daily;
import com.grcms.im.ronghub.api.exception.ECAttendenceException;
import com.grcms.im.ronghub.api.exception.ECDailyException;

import java.util.List;

/**
 * @Author: jiepeng
 * @Date:2015/11/13 0013
 * @Description:
 */
public interface DailyDao extends MybatisBaseDao<Daily>{

    /**
     * Get by member id
     * @param userId
     * @return
     * @throws ECAttendenceException
     */
    List<Daily> getByMemberId(String userId) throws ECDailyException;

}
