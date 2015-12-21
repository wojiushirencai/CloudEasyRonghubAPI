package com.grcms.im.ronghub.api.aop;

import com.grcms.core.response.JsonResponse;
import com.grcms.frontend.domain.Member;
import com.grcms.im.ronghub.api.service.impl.RonghubApiBasic;
import com.grcms.management.user.domain.Department;
import io.rong.ApiHttpClient;
import io.rong.models.FormatType;
import io.rong.models.SdkHttpResult;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/12/6.
 * if
 */
@Aspect
public class JoinGroupAop {
    private static final Logger logger = Logger.getLogger(JoinGroupAop.class);

    @AfterReturning(pointcut = "execution(* com.grcms.backend.controller.ManagementMemberController.add(..))", returning = "rvt")
    public void log(JoinPoint jp, Object rvt) {
        if (rvt instanceof JsonResponse) {
            JsonResponse jres = (JsonResponse) rvt;
            Object obj = jres.getResponse();
            if (obj instanceof Member) {
                Member member = (Member) obj;
                try {
                    Department department = member.getDepartment();
                    SdkHttpResult sdkHttpResult = ApiHttpClient.joinGroup(
                            RonghubApiBasic.getAppKey(),
                            RonghubApiBasic.getAppSecret(),
                            member.getId(),
                            department.getId().toString(),
                            department.getName(),
                            FormatType.json
                    );
                    if (sdkHttpResult.getHttpCode() == 200) {
                        logger.info("==>Join rong hub group [" + department.getId() + "," + department.getName() + "] and user [" + member.getId() + "," + member.getLoginId() + "]");
                    } else {
                        logger.warn("==>Join ronghub group error:" + sdkHttpResult.getHttpCode() + "," +
                                sdkHttpResult.getResult());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
