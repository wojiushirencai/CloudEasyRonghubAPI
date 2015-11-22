package com.grcms.im.ronghub.api.dao.impl;

import com.grcms.basic.impl.MybatisBaseDaoImpl;
import com.grcms.im.ronghub.api.dao.AttendenceDao;
import com.grcms.im.ronghub.api.domain.Attendence;
import com.grcms.im.ronghub.api.domain.RonghubDetail;
import com.grcms.im.ronghub.api.exception.ECAttendenceException;

/**
 * Created by Administrator on 2015/11/22.
 */
public class AttendenceDaoImpl extends MybatisBaseDaoImpl<Attendence> implements AttendenceDao {
    @Override
    public Attendence getByUserId(String userId) throws ECAttendenceException {
        return null;
    }
}
