package com.grcms.im.ronghub.api.controller;

import com.grcms.common.util.CommonUtility;
import com.grcms.content.core.exception.ECCMSInfoException;
import com.grcms.content.core.exception.ECCMSNodeException;
import com.grcms.core.exception.ECAuthException;
import com.grcms.core.form.BasicForm;
import com.grcms.core.response.JsonResponse;
import com.grcms.core.util.ForwardUtility;
import com.grcms.frontend.exception.ECMemberException;
import com.grcms.im.ronghub.api.domain.Daily;
import com.grcms.im.ronghub.api.exception.ECDailyException;
import com.grcms.im.ronghub.api.service.DailyService;
import com.grcms.im.ronghub.api.util.ApiUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Administrator on 2015/11/15.
 */

@Controller
@RequestMapping("")
public class DailyController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(DailyController.class);
    @Autowired
    private DailyService dailyService;

    /**
     * @param request
     * @param response
     * @return
     * @throws ECAuthException
     * @throws ECMemberException
     * @throws ECCMSNodeException
     */
    @RequestMapping(value = "/daily", method = RequestMethod.GET)
    public String daily(HttpServletRequest request, HttpServletResponse response
            , @ModelAttribute("form") BasicForm form
            , @RequestParam(required = false) String userId
            , @RequestParam(required = false) String token) throws ECAuthException, ECMemberException, ECCMSNodeException {
        userId = CommonUtility.isNonEmpty(userId) ? userId : ApiUtil.getRequestUserId(request);
        token = CommonUtility.isNonEmpty(token) ? token : ApiUtil.getRequestToken(request);
        if(!CommonUtility.isNonEmpty(userId) || !CommonUtility.isNonEmpty(token)) {
            return null;
        }
        request.setAttribute("userId", userId);
        request.setAttribute("token", token);
        return ForwardUtility.forwardThemeView("daily");
    }

    @RequestMapping(value = "/daily", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse addDaily(HttpServletRequest request, HttpServletResponse response
            , @RequestParam String title
            , @RequestParam String userId
            , @RequestParam String token
            , @RequestParam String content
            , @ModelAttribute("form") BasicForm form) throws ECAuthException, ECMemberException, ECCMSNodeException, ECCMSInfoException, ECDailyException {
        JsonResponse jres = new JsonResponse();
        request.setAttribute("userId", userId);
        request.setAttribute("token", token);
        Daily daily = new Daily();
        daily.setMemberId(userId);
        daily.setContent(content);
        daily.setTitle(title);
        daily.setUpdateTime(new Date());
        dailyService.add(daily);
        daily.setUpdateTimeStr(CommonUtility.formateDate(daily.getUpdateTime(), "yyyy-MM-dd HH:mm"));
        jres.setResponse(daily);
        return jres;
    }

    @RequestMapping(value = "/daily/{dailyId}")
    public String dailyDetail(HttpServletRequest request, HttpServletResponse response
            , @PathVariable("dailyId") String dailyId
            , @ModelAttribute("form") BasicForm form
    ) throws ECAuthException, ECMemberException, ECCMSNodeException, ECCMSInfoException {
        request.setAttribute("userId", ApiUtil.getRequestUserId(request));
        request.setAttribute("token", ApiUtil.getRequestToken(request));
        return ForwardUtility.forwardThemeView("daily_detail");
    }
//
//    @RequestMapping(value = "/daily/add", method = RequestMethod.GET)
//    public String addDailyView(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("form") BasicForm form
//            , @RequestParam String userId
//            , @RequestParam String token
//    ) throws ECAuthException, ECMemberException, ECCMSNodeException, ECCMSInfoException {
//        request.setAttribute("userId", userId);
//        request.setAttribute("token", token);
//        return ForwardUtility.forwardThemeView("daily_edit");
//    }


}

