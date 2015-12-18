package com.grcms.im.ronghub.api.dao;

import com.grcms.basic.MybatisBaseDao;
import com.grcms.core.exception.ECDepartmentException;
import com.grcms.frontend.domain.Member;
import com.grcms.im.ronghub.api.domain.Attendence;
import com.grcms.im.ronghub.api.exception.ECAttendenceException;
import com.grcms.management.user.domain.Department;

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
    List<Department> getMembersByAllDepartments() throws ECDepartmentException;

}
