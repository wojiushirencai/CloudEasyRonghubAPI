package com.grcms.im.ronghub.api.dao;

import com.grcms.core.exception.ECDepartmentException;
import com.grcms.frontend.exception.ECMemberException;
import com.grcms.im.ronghub.api.domain.Contacts;
import com.grcms.im.ronghub.api.domain.ContactsGroup;
import com.grcms.im.ronghub.api.exception.ECAttendenceException;

import java.util.List;

/**
 * @Author: jiepeng
 * @Date:2015/11/13 0013
 * @Description:
 */
public interface ContactsDao{

    /**
     * Get by member id
     * @return
     * @throws ECAttendenceException
     */
    List<ContactsGroup> getMembersByAllDepartments() throws ECDepartmentException;

    /**
     * Get all contacts
     * @return
     * @throws ECMemberException
     */
    List<Contacts> getAllContacts() throws ECMemberException;

    /**
     * get by id
     * @param id
     * @return
     * @throws ECMemberException
     */
    Contacts getById(String id) throws ECMemberException;

    /**
     * Update contacts profile
     * @param contacts
     * @return
     * @throws ECMemberException
     */
    Contacts updateContacts(Contacts contacts) throws ECMemberException;

    /**
     * Update portrait
     * @param userId
     * @param portraitUrl
     * @throws ECMemberException
     */
    void updatePortrait(String userId,String portraitUrl) throws ECMemberException;
}
