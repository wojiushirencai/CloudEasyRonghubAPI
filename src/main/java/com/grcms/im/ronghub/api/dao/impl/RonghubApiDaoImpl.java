/* 
 * Globalroam 2015 @copyright 
 */
package com.grcms.im.ronghub.api.dao.impl;

import com.grcms.basic.impl.MybatisBaseDaoImpl;
import com.grcms.im.ronghub.api.dao.RonghubApiDao;
import com.grcms.im.ronghub.api.domain.RonghubDetail;
import com.grcms.im.ronghub.api.exception.ECRonghubDetailException;
import org.springframework.stereotype.Repository;

/**
 * @Author: jiepeng
 * @Date:2015/11/13 0013
 * @Description:
 */
@Repository("ronghubApiDao")
public class RonghubApiDaoImpl extends MybatisBaseDaoImpl<RonghubDetail> implements RonghubApiDao {
    @Override
    public RonghubDetail getByUserId(String userId) throws ECRonghubDetailException {
        String intactName = className + "getByUserId";
        return sqlSession.selectOne(intactName, userId);
    }

    @Override
    public RonghubDetail getByToken(String token) throws ECRonghubDetailException {
        String intactName = className + "getByToken";
        return sqlSession.selectOne(intactName, token);
    }
}
