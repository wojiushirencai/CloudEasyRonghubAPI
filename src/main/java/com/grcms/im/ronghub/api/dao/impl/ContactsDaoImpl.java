package com.grcms.im.ronghub.api.dao.impl;

import com.grcms.core.exception.ECDepartmentException;
import com.grcms.frontend.exception.ECMemberException;
import com.grcms.im.ronghub.api.dao.ContactsDao;
import com.grcms.im.ronghub.api.domain.Contacts;
import com.grcms.management.user.domain.Department;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2015/11/22.
 */
@Repository("contactDao")
public class ContactsDaoImpl implements ContactsDao {
    private final Logger logger = LoggerFactory.getLogger(ContactsDaoImpl.class);
    @Autowired
    protected SqlSession sqlSession;
    protected String className = this.getClass().getName() + ".";

    @Override
    public List<Department> getMembersByAllDepartments() throws ECDepartmentException {
        String intactName = className + "getMembersByAllDepartments";
        return sqlSession.selectList(intactName);
    }

    @Override
    public List<Contacts> getAllContacts() throws ECMemberException {
        String intactName = className + "getAllContacts";
        return sqlSession.selectList(intactName);
    }

    @Override
    public Contacts getById(String id) throws ECMemberException {
        String intactName = className + "getById";
        return sqlSession.selectOne(intactName, id);
    }

    @Override
    public Contacts updateContacts(Contacts contacts) throws ECMemberException {
        String intactName = className + "updateContacts";
        sqlSession.update(intactName,contacts);
        return  contacts;
    }
}
