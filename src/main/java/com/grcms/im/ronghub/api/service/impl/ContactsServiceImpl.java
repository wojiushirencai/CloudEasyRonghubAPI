/* 
 * Globalroam 2015 @copyright 
 */
package com.grcms.im.ronghub.api.service.impl;

import com.grcms.core.exception.ECDepartmentException;
import com.grcms.im.ronghub.api.dao.ContactsDao;
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
    public List<Department> getContactsByAllDepartment() throws ECAttendenceException, ECDepartmentException {
        return contactsDao.getMembersByAllDepartments();
    }
}
