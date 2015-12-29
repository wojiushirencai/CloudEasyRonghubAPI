package com.grcms.im.ronghub.api.dao;

import com.grcms.basic.MybatisBaseDao;
import com.grcms.im.ronghub.api.domain.Attendency;
import com.grcms.im.ronghub.api.exception.ECAttendenceException;

import java.util.List;

/**
 * @Author: jiepeng
 * @Date:2015/11/13 0013
 * @Description:
 */
public interface AttendenceDao extends MybatisBaseDao<Attendency>{

    /**
     * Get by member id
     * @param userId
     * @return
     * @throws ECAttendenceException
     */
    List<Attendency> getByMemberId(String userId) throws ECAttendenceException;

}
