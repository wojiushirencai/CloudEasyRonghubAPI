package com.grcms.im.ronghub.api.dao.impl;

import com.grcms.basic.impl.MybatisBaseDaoImpl;
import com.grcms.im.ronghub.api.dao.AttendenceDao;
import com.grcms.im.ronghub.api.domain.Attendency;
import com.grcms.im.ronghub.api.exception.ECAttendenceException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2015/11/22.
 */
@Repository("attendenceDao")
public class AttendenceDaoImpl extends MybatisBaseDaoImpl<Attendency> implements AttendenceDao {
    @Override
    public List<Attendency> getByMemberId(String userId) throws ECAttendenceException {
        String intactName = className + "getByMemberId";
        return sqlSession.selectList(intactName, userId);
    }
}
