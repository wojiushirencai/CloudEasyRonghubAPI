package com.grcms.im.ronghub.api.service;

import com.grcms.core.exception.ECDepartmentException;
import com.grcms.core.util.Page;
import com.grcms.frontend.exception.ECMemberException;
import com.grcms.im.ronghub.api.domain.Attendence;
import com.grcms.im.ronghub.api.domain.Contacts;
import com.grcms.im.ronghub.api.domain.ContactsGroup;
import com.grcms.im.ronghub.api.exception.ECAttendenceException;
import com.grcms.management.user.domain.Department;

import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
public interface ContactsService {

    /**
     * Add attendence
     * @return
     * @throws ECAttendenceException
     */
    List<ContactsGroup> getContactsByAllDepartment() throws ECAttendenceException, ECDepartmentException;

    List<Contacts> getContacts() throws ECMemberException;

    Contacts findById(String id) throws ECMemberException;

    Contacts update(Contacts contacts) throws ECMemberException;

    void updatePortrait(String userId,String portraitUrl) throws ECMemberException;

}
