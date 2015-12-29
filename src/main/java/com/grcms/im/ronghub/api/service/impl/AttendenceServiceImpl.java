package com.grcms.im.ronghub.api.service.impl;

import com.grcms.common.util.CommonUtility;
import com.grcms.core.util.Page;
import com.grcms.im.ronghub.api.dao.AttendenceDao;
import com.grcms.im.ronghub.api.domain.Attendency;
import com.grcms.im.ronghub.api.exception.ECAttendenceException;
import com.grcms.im.ronghub.api.service.AttendenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/11/29.
 */
@Service("attendenceService")
public class AttendenceServiceImpl implements AttendenceService {
    @Autowired
    private AttendenceDao attendenceDao;
    @Override
    public Attendency add(Attendency attendence) throws ECAttendenceException {
        attendence.setId(CommonUtility.generateUUID(true));
        attendenceDao.insert(attendence);
        return attendence;
    }

    @Override
    public Attendency update(Attendency attendence) throws ECAttendenceException {
        attendenceDao.update(attendence);
        return attendence;
    }

    @Override
    public void deleteById(String id) throws ECAttendenceException {
        attendenceDao.deleteById(id);
    }

    @Override
    public void deleteByIds(String[] ids) throws ECAttendenceException {
        attendenceDao.deleteByIds(ids);
    }

    @Override
    public Attendency findById(String id) throws ECAttendenceException {
        return attendenceDao.getById(id);
    }

    @Override
    public List<Attendency> findByMemberId(String memberId) throws ECAttendenceException {
        return attendenceDao.getByMemberId(memberId);
    }

    @Override
    public List<Attendency> findAll() throws ECAttendenceException {
        return attendenceDao.getAll();
    }

    @Override
    public Page<Attendency> findPage(Page<Attendency> page) throws ECAttendenceException {
        Integer totalRecord = attendenceDao.getTotalRecord();
        if(null != totalRecord) {
            page.execute(totalRecord, page.getPageNum(), null);
            List<Attendency> list = attendenceDao.getByPage(page.getStartIndex(), page.getPagesize());
            page.setDatas(list);
        }
        return page;
    }

    @Override
    public Page<Attendency> findPage(Page<Attendency> page, Attendency condition) throws ECAttendenceException {
        Integer totalRecord = attendenceDao.getTotalRecordByCondition(condition);
        if(null != totalRecord) {
            page.execute(totalRecord, page.getPageNum(), null);
            List<Attendency> list = attendenceDao.getByPageAndCondition(page.getStartIndex(), page.getPagesize(), condition);
            page.setDatas(list);
        }
        return page;
    }
}
