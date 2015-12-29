package com.grcms.im.ronghub.api.service;

import com.grcms.core.util.Page;
import com.grcms.im.ronghub.api.domain.Daily;
import com.grcms.im.ronghub.api.exception.ECAttendenceException;
import com.grcms.im.ronghub.api.exception.ECDailyException;

import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
public interface DailyService {

    /**
     * Add attendence
     * @param daily
     * @return
     * @throws ECAttendenceException
     */
    Daily add(Daily daily) throws ECDailyException;

    /**
     * Update
     * @param daily
     * @return
     * @throws ECDailyException
     */
    Daily update(Daily daily) throws ECDailyException;

    /**
     * Delete by id
     * @param id
     * @throws ECDailyException
     */
    void deleteById(String id) throws ECDailyException;

    /**
     * Delete by ids
     * @param ids
     * @throws ECDailyException
     */
    void deleteByIds(String[] ids) throws ECDailyException;

    /**
     * Find by id
     * @param id
     * @return
     * @throws ECDailyException
     */
    Daily findById(String id) throws ECDailyException;

    /**
     * Find by member id
     * @param memberId
     * @return
     * @throws ECDailyException
     */
    List<Daily> findByMemberId(String memberId) throws ECDailyException;

    /**
     * Find all
     * @return
     * @throws ECDailyException
     */
    List<Daily> findAll() throws ECDailyException;

    /**
     * Find by page
     * @param page
     * @return
     * @throws ECDailyException
     */
    Page<Daily> findPage(Page<Daily> page) throws ECDailyException;

    /**
     * Find by page
     * @param page
     * @param condition
     * @return
     * @throws ECDailyException
     */
    Page<Daily> findPage(Page<Daily> page, Daily condition) throws ECDailyException;
}
