package com.grcms.im.ronghub.api.aop;

import com.grcms.common.util.CommonUtility;
import com.grcms.content.core.domain.CMSInfo;
import com.grcms.core.response.JsonResponse;
import com.grcms.frontend.domain.Member;
import com.grcms.frontend.service.MemberService;
import com.grcms.im.ronghub.api.service.impl.RonghubApiBasic;
import io.rong.ApiHttpClient;
import io.rong.models.FormatType;
import io.rong.models.Message;
import io.rong.models.SdkHttpResult;
import io.rong.models.TxtMessage;
import org.aopalliance.intercept.Joinpoint;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/12/6.
 * if
 */
@Aspect
public class InfoPushAop {
    private static final Logger logger = Logger.getLogger(InfoPushAop.class);
    @Autowired
    private MemberService memberService;

    @AfterReturning(pointcut = "execution(* com.grcms.content.core.controller.ManagementInfoController.add(..))", returning = "rvt")
    public void log(JoinPoint jp, Object rvt) {
        if (rvt instanceof JsonResponse) {
            JsonResponse jres = (JsonResponse) rvt;
            Object obj = jres.getResponse();
            if (obj instanceof CMSInfo) {
                CMSInfo info = (CMSInfo) obj;
                if(!"announcement".equals(info.getNodeUri())) {
                    return;
                }
                Member condition = new Member();
                condition.setIsDel(0);
                try {
                    List<Member> members = memberService.findAll(condition);
                    if (members == null) {
                        return;
                    }

                    List<List<String>> sendTimes = new ArrayList<List<String>>();
                    int times = members.size() > 1000 ? (int) Math.ceil(members.size() / 1000) : 1;
                    for (int i = 0; i < times; i++) {
                        List<String> memberIds = new ArrayList<String>();
                        if (i == times - 1) {
                            List<Member> subList = members.subList(i * 1000, members.size());
                            for (Member m : subList) {
                                memberIds.add(m.getId());
                            }
                            sendTimes.add(memberIds);
                        } else {
                            List<Member> subList = members.subList(i * 1000, (i + 1) * 1000);
                            for (Member m : subList) {
                                memberIds.add(m.getId());
                            }
                            sendTimes.add(memberIds);
                        }

                    }

                    for (List<String> ids : sendTimes) {
                        SdkHttpResult sdkHttpResult = ApiHttpClient.publishSystemMessage(
                                RonghubApiBasic.getAppKey(),
                                RonghubApiBasic.getAppSecret(),
                                "0",
                                ids,
                                new TxtMessage(info.getName()),
                                info.getName(),
                                CommonUtility.formateDate(new Date(), "yyyy.MM.dd HH:ss"),
                                FormatType.json
                        );
                        if (sdkHttpResult.getHttpCode() == 200) {
                            logger.info("==>Push info [" + info.getName() + "] to user");
                        } else {
                            logger.warn("==>Join ronghub group error:" + sdkHttpResult.getHttpCode() + "," +
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
