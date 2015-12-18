package com.grcms.im.ronghub.api.service;

import com.grcms.core.exception.ECDepartmentException;
import com.grcms.core.util.Page;
import com.grcms.im.ronghub.api.domain.Attendence;
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
    List<Department> getContactsByAllDepartment() throws ECAttendenceException, ECDepartmentException;

}
