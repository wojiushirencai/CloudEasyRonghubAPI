package com.grcms.im.ronghub.api.service.impl;

import com.grcms.common.util.CommonUtility;
import com.grcms.core.util.Page;
import com.grcms.im.ronghub.api.dao.AttendenceDao;
import com.grcms.im.ronghub.api.domain.Attendence;
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
    public Attendence add(Attendence attendence) throws ECAttendenceException {
        attendence.setId(CommonUtility.generateUUID(true));
        attendenceDao.insert(attendence);
        return attendence;
    }

    @Override
    public Attendence update(Attendence attendence) throws ECAttendenceException {
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
    public Attendence findById(String id) throws ECAttendenceException {
        return attendenceDao.getById(id);
    }

    @Override
    public List<Attendence> findByMemberId(String memberId) throws ECAttendenceException {
        return attendenceDao.getByMemberId(memberId);
    }

    @Override
    public List<Attendence> findAll() throws ECAttendenceException {
        return attendenceDao.getAll();
    }

    @Override
    public Page<Attendence> findPage(Integer pageNum, Integer pagesize) throws ECAttendenceException {
        Page<Attendence> page = new Page<Attendence>(pageNum,pagesize);
        List<Attendence> data = attendenceDao.getByPage(page.getOffset(pageNum), pagesize);
        page.execute(attendenceDao.getTotalRecord(),pageNum,data);
        return page;
    }

    @Override
    public Page<Attendence> findPage(Integer pageNum, Integer pagesize, Attendence condition) throws ECAttendenceException {
        Page<Attendence> page = new Page<Attendence>(pageNum,pagesize);
        List<Attendence> data = attendenceDao.getByPageAndCondition(page.getOffset(pageNum), pagesize, condition);
        page.execute(attendenceDao.getTotalRecord(),pageNum,data);
        return page;
    }
}
