package com.grcms.im.ronghub.api.service.impl;

import com.grcms.common.util.CommonUtility;
import com.grcms.content.core.domain.CMSInfo;
import com.grcms.core.util.Page;
import com.grcms.im.ronghub.api.dao.DailyDao;
import com.grcms.im.ronghub.api.domain.Daily;
import com.grcms.im.ronghub.api.exception.ECAttendenceException;
import com.grcms.im.ronghub.api.exception.ECDailyException;
import com.grcms.im.ronghub.api.service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/11/29.
 */
@Service("dailyService")
public class DailyServiceImpl implements DailyService {
    @Autowired
    private DailyDao dailyDao;

    @Override
    public Daily add(Daily daily) throws ECDailyException {
        daily.setId(CommonUtility.generateUUID(true));
        dailyDao.insert(daily);
        return daily;
    }

    @Override
    public Daily update(Daily daily) throws ECDailyException {
        dailyDao.update(daily);
        return daily;
    }

    @Override
    public void deleteById(String id) throws ECDailyException {
        dailyDao.deleteById(id);
    }

    @Override
    public void deleteByIds(String[] ids) throws ECDailyException {
        dailyDao.deleteByIds(ids);
    }

    @Override
    public Daily findById(String id) throws ECDailyException {
        return dailyDao.getById(id);
    }

    @Override
    public List<Daily> findByMemberId(String memberId) throws ECDailyException {
        return dailyDao.getByMemberId(memberId);
    }

    @Override
    public List<Daily> findAll() throws ECDailyException {
        return dailyDao.getAll();
    }

    @Override
    public Page<Daily> findPage(Page<Daily> page) throws ECDailyException {
        Integer totalRecord = dailyDao.getTotalRecord();
        if(null != totalRecord) {
            page.execute(totalRecord, page.getPageNum(), null);
            List<Daily> list = dailyDao.getByPage(page.getStartIndex(), page.getPagesize());
            page.setDatas(list);
        }
        return page;
    }

    @Override
    public Page<Daily> findPage(Page<Daily> page, Daily condition) throws ECDailyException {
        Integer totalRecord = dailyDao.getTotalRecordByCondition(condition);
        if(null != totalRecord) {
            page.execute(totalRecord, page.getPageNum(), null);
            List<Daily> list = dailyDao.getByPageAndCondition(page.getStartIndex(), page.getPagesize(), condition);
            page.setDatas(list);
        }
        return page;
    }
}
