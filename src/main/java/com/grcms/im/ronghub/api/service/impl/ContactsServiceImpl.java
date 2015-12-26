/* 
 * Globalroam 2015 @copyright 
 */
package com.grcms.im.ronghub.api.service.impl;

import com.grcms.core.exception.ECDepartmentException;
import com.grcms.frontend.exception.ECMemberException;
import com.grcms.im.ronghub.api.dao.ContactsDao;
import com.grcms.im.ronghub.api.domain.Contacts;
import com.grcms.im.ronghub.api.domain.ContactsGroup;
import com.grcms.im.ronghub.api.exception.ECAttendenceException;
import com.grcms.im.ronghub.api.service.ContactsService;
import com.grcms.management.user.domain.Department;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jiepeng
 * @Date:2015/11/13 0013
 * @Description:
 */
@Service("contactsService")
public class ContactsServiceImpl implements ContactsService {
    private static final Logger logger = Logger.getLogger(ContactsServiceImpl.class);
    @Autowired
    private ContactsDao contactsDao;

    @Override
    public List<ContactsGroup> getContactsByAllDepartment() throws ECAttendenceException, ECDepartmentException {
        return contactsDao.getMembersByAllDepartments();
    }

    @Override
    public List<Contacts> getContacts() throws ECMemberException {
        return contactsDao.getAllContacts();
    }

    @Override
    public Contacts findById(String id) throws ECMemberException {
        return contactsDao.getById(id);
    }

    @Override
    public Contacts update(Contacts contacts) throws ECMemberException {
        return contactsDao.updateContacts(contacts);
    }

    @Override
    public void updatePortrait(String userId, String portraitUrl) throws ECMemberException {
        contactsDao.updatePortrait(userId,portraitUrl);
    }
}
