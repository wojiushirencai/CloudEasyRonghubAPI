/* 
 * Globalroam 2015 @copyright 
 */
package com.grcms.im.ronghub.api.service.impl;

import com.grcms.common.util.CommonUtility;
import com.grcms.core.exception.ECAuthException;
import com.grcms.core.strategy.authorization.Authenticator;
import com.grcms.core.strategy.authorization.Authorization;
import com.grcms.frontend.domain.Member;
import com.grcms.frontend.service.MemberService;
import com.grcms.im.ronghub.api.dao.AuthDao;
import com.grcms.im.ronghub.api.dao.RonghubApiDao;
import com.grcms.im.ronghub.api.domain.RonghubDetail;
import com.grcms.im.ronghub.api.exception.ECRonghubDetailException;
import com.grcms.im.ronghub.api.service.AuthService;
import com.grcms.im.ronghub.api.strategy.ApiAuth;
import com.grcms.management.user.domain.User;
import io.rong.ApiHttpClient;
import io.rong.models.FormatType;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jiepeng
 * @Date:2015/11/13 0013
 * @Description:
 */
@Service("authService")
public class AuthServiceImpl extends RonghubApiBasic implements AuthService {
    private static final Logger logger = Logger.getLogger(AuthServiceImpl.class);
    @Autowired
    private MemberService memberService;
    @Autowired
    private AuthDao authDao;
    @Autowired
    private RonghubApiDao ronghubApiDao;
    @Autowired
    private ApiAuth apiAuth;

    @Override
    public RonghubDetail executeAuth(String username, String password) throws ECAuthException {
        RonghubDetail detail = null;
        try {
            Authenticator<Member> authenticator = new Authenticator<Member>(apiAuth);
            Member member = authenticator.executeAuth(username, password);
            if (null == member) {
                throw new ECAuthException("User [" + username + "] not exist.");
            }
            detail = ronghubApiDao.getByUserId(member.getId());
            //if find detail with user id is null then insert a record.
            if (detail == null) {
                detail = authDao.getToken(member.getId(), member.getLoginId(), null);
                detail.setId(CommonUtility.generateUUID(true));
                ronghubApiDao.insert(detail);
            } else if(!CommonUtility.isNonEmpty(detail.getToken())){
                RonghubDetail newDetail = authDao.getToken(member.getId(), member.getLoginId(), null);
                detail.setToken(newDetail.getToken());
                ronghubApiDao.update(detail);
            }
        } catch (Exception e) {
            logger.warn("API auth failed,message:" + e.getMessage());
            e.printStackTrace();
            throw new ECAuthException(e.getMessage());
        }
        return detail;
    }

    @Override
    public RonghubDetail findByToken(String token) throws ECAuthException {
        try {
            return ronghubApiDao.getByToken(token);
        } catch (ECRonghubDetailException e) {
            e.printStackTrace();
            throw  new ECAuthException(e.getMessage());
        }
    }

    @Override
    public RonghubDetail findByUserId(String userId) throws ECAuthException {
        try {
            return ronghubApiDao.getByUserId(userId);
        } catch (ECRonghubDetailException e) {
            e.printStackTrace();
            throw  new ECAuthException(e.getMessage());
        }
    }

    @Override
    public List<RonghubDetail> findAll() throws ECAuthException {
        return ronghubApiDao.getAll();
    }
}
