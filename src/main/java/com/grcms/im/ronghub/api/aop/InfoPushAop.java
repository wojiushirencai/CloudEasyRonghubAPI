package com.grcms.im.ronghub.api.aop;

import com.grcms.common.util.CommonUtility;
import com.grcms.content.core.domain.CMSInfo;
import com.grcms.core.response.JsonResponse;
import org.aopalliance.intercept.Joinpoint;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Administrator on 2015/12/6.
 * if
 */
@Aspect
public class InfoPushAop {
    private static final Logger logger = Logger.getLogger(InfoPushAop.class);
    @AfterReturning(pointcut="execution(* com.grcms.content.core.controller.ManagementInfoController.add(..))",returning="rvt")
    public void log(JoinPoint jp, Object rvt) {
        if(rvt instanceof JsonResponse) {
            JsonResponse jres = (JsonResponse) rvt;
            Object obj = jres.getResponse();
            if(obj instanceof CMSInfo) {
                CMSInfo info = (CMSInfo) obj;
                logger.debug("==> Prepare to push info :title=" + info.getName());
            }
        }
    }
}
