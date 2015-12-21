package com.grcms.im.ronghub.api.aop;

import com.grcms.core.response.JsonResponse;
import com.grcms.frontend.domain.Member;
import com.grcms.frontend.service.MemberService;
import com.grcms.im.ronghub.api.service.impl.RonghubApiBasic;
import com.grcms.management.user.domain.Department;
import io.rong.ApiHttpClient;
import io.rong.models.FormatType;
import io.rong.models.SdkHttpResult;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2015/12/6.
 * if
 */
@Aspect
public class DismissGroupAop {
    private static final Logger logger = Logger.getLogger(DismissGroupAop.class);
    @Autowired
    private MemberService memberService;

    @AfterReturning(pointcut = "execution(* com.grcms.management.user.action.ManagementDepartmentController.delete(..))", returning = "rvt")
    public void log(JoinPoint jp, Object rvt) {
        if (rvt instanceof JsonResponse) {
            JsonResponse jres = (JsonResponse) rvt;
            Object obj = jres.getResponse();
            if (obj instanceof Integer[]) {
                Integer[] departmentIds = (Integer[]) obj;
                try {
                    for (Integer id : departmentIds) {
//                        Member condition = new Member();
//                        Department department = new Department();
//                        department.setId(id);
//                        condition.setDepartment(department);
//                        List<Member> members = memberService.findAll(condition);
                        SdkHttpResult sdkHttpResult = ApiHttpClient.dismissGroup(
                                RonghubApiBasic.getAppKey(),
                                RonghubApiBasic.getAppSecret(),
                                "0",
                                id.toString(),
                                FormatType.json
                        );
                    if (sdkHttpResult.getHttpCode() == 200) {
                        logger.info("==>Dismiss rong hub group [" + id + "]");
                    } else {
                        logger.warn("==>Dismiss ronghub group error:" + sdkHttpResult.getHttpCode() + "," +
                                sdkHttpResult.getResult());
                    }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
