package com.grcms.im.ronghub.api.aop;

import com.grcms.common.util.CommonUtility;
import com.grcms.content.core.domain.CMSInfo;
import com.grcms.core.exception.ECAuthException;
import com.grcms.core.response.JsonResponse;
import com.grcms.frontend.domain.Member;
import com.grcms.im.ronghub.api.dao.AuthDao;
import com.grcms.im.ronghub.api.dao.RonghubApiDao;
import com.grcms.im.ronghub.api.domain.RonghubDetail;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2015/12/6.
 * if
 */
@Aspect
public class CreateMemberTokenAop {
    private static final Logger logger = Logger.getLogger(CreateMemberTokenAop.class);

    @Autowired
    private AuthDao authDao;
    @Autowired
    private RonghubApiDao ronghubApiDao;
    @AfterReturning(pointcut="execution(* com.grcms.backend.controller.ManagementMemberController.add(..))",returning="rvt")
    public void log(JoinPoint jp, Object rvt) {
        if(rvt instanceof JsonResponse) {
            JsonResponse jres = (JsonResponse) rvt;
            Object obj = jres.getResponse();
            if(obj instanceof Member) {
                Member member = (Member) obj;
                try {
                    logger.debug("==> Generate token to member [" + member.getLoginId() + "]");
                    RonghubDetail detail = authDao.getToken(member.getId(), member.getLoginId(), null);
                    detail.setId(CommonUtility.generateUUID(true));
                    ronghubApiDao.insert(detail);
                } catch (ECAuthException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
