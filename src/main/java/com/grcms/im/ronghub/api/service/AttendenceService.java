package com.grcms.im.ronghub.api.service;

import com.grcms.core.util.Page;
import com.grcms.im.ronghub.api.domain.Attendency;
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
    Attendency add(Attendency attendence) throws ECAttendenceException;

    /**
     * Update
     * @param attendence
     * @return
     * @throws ECAttendenceException
     */
    Attendency update(Attendency attendence) throws ECAttendenceException;

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
    Attendency findById(String id) throws ECAttendenceException;

    /**
     * Find by member id
     * @param memberId
     * @return
     * @throws ECAttendenceException
     */
    List<Attendency> findByMemberId(String memberId) throws ECAttendenceException;

    /**
     * Find all
     * @return
     * @throws ECAttendenceException
     */
    List<Attendency> findAll() throws ECAttendenceException;

    /**
     * Find by page
     * @return
     * @throws ECAttendenceException
     */
    Page<Attendency> findPage(Page<Attendency> page) throws ECAttendenceException;

    /**
     * Find by page
     * @param condition
     * @return
     * @throws ECAttendenceException
     */
    Page<Attendency> findPage(Page<Attendency> page,Attendency condition) throws ECAttendenceException;
}
