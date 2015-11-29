package com.grcms.im.ronghub.api.service;

import com.grcms.core.util.Page;
import com.grcms.im.ronghub.api.domain.Attendence;
import com.grcms.im.ronghub.api.exception.ECAttendenceException;

import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
public interface AttendenceService {

    /**
     * Add attendence
     * @param attendence
     * @return
     * @throws ECAttendenceException
     */
    Attendence add(Attendence attendence) throws ECAttendenceException;

    /**
     * Update
     * @param attendence
     * @return
     * @throws ECAttendenceException
     */
    Attendence update(Attendence attendence) throws ECAttendenceException;

    /**
     * Delete by id
     * @param id
     * @throws ECAttendenceException
     */
    void deleteById(String id) throws ECAttendenceException;

    /**
     * Delete by ids
     * @param ids
     * @throws ECAttendenceException
     */
    void deleteByIds(String[] ids) throws ECAttendenceException;

    /**
     * Find by id
     * @param id
     * @return
     * @throws ECAttendenceException
     */
    Attendence findById(String id) throws ECAttendenceException;

    /**
     * Find by member id
     * @param memberId
     * @return
     * @throws ECAttendenceException
     */
    List<Attendence> findByMemberId(String memberId) throws ECAttendenceException;

    /**
     * Find all
     * @return
     * @throws ECAttendenceException
     */
    List<Attendence> findAll() throws ECAttendenceException;

    /**
     * Find by page
     * @param pageNum
     * @param pagesize
     * @return
     * @throws ECAttendenceException
     */
    Page<Attendence> findPage(Integer pageNum,Integer pagesize) throws ECAttendenceException;

    /**
     * Find by page
     * @param pageNum
     * @param pagesize
     * @param condition
     * @return
     * @throws ECAttendenceException
     */
    Page<Attendence> findPage(Integer pageNum,Integer pagesize,Attendence condition) throws ECAttendenceException;
}
