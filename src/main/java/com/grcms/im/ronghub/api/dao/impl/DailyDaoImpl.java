package com.grcms.im.ronghub.api.dao.impl;

import com.grcms.basic.impl.MybatisBaseDaoImpl;
import com.grcms.im.ronghub.api.dao.DailyDao;
import com.grcms.im.ronghub.api.domain.Attendence;
import com.grcms.im.ronghub.api.domain.Daily;
import com.grcms.im.ronghub.api.exception.ECDailyException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2015/11/22.
 */
@Repository("dailyDao")
public class DailyDaoImpl extends MybatisBaseDaoImpl<Daily> implements DailyDao {
    @Override
    public List<Daily> getByMemberId(String userId) throws ECDailyException {
        String intactName = className + "getByMemberId";
        return sqlSession.selectList(intactName, userId);
    }
}
