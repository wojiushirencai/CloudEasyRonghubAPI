package com.grcms.im.ronghub.api.controller;

import com.grcms.common.util.CommonUtility;
import com.grcms.core.exception.ECAuthException;
import com.grcms.core.exception.ECParamsRequiredException;
import com.grcms.core.response.JsonResponse;
import com.grcms.core.util.Page;
import com.grcms.im.ronghub.api.domain.Attendency;
import com.grcms.im.ronghub.api.exception.ECAttendenceException;
import com.grcms.im.ronghub.api.service.AttendenceService;
import com.grcms.im.ronghub.api.util.ApiUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Administrator on 2015/11/15.
 */

@RestController
@RequestMapping("/api")
public class AttendenceController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(AttendenceController.class);
    private static final String AJAX_REQUEST = "XMLHttpRequest";

    @Autowired
    private AttendenceService attendenceService;

    @RequestMapping(value = "/attendence/location", method = RequestMethod.GET)
    public JsonResponse getLocations(HttpServletRequest request, HttpServletResponse response
            , @RequestParam(required = false) Integer pageNum
            , @RequestParam Integer pagesize
            , @RequestParam(required = false) String updateDate
            , @RequestParam(required = false) String minTime
    ) throws ECAuthException, ECParamsRequiredException, ECAttendenceException {
        JsonResponse res = new JsonResponse();
        Attendency condition = new Attendency();
        Page<Attendency> pager = new Page<Attendency>();
        if(pageNum != null) {
            pager.setPageNum(pageNum);
        }
        pager.setPagesize(pagesize);
        condition.setMemberId(ApiUtil.getRequestUserId(request));
        if(!CommonUtility.isNonEmpty(minTime)) {
            condition.setUpdateDate(updateDate);
        }
        if(!CommonUtility.isNonEmpty(updateDate)) {
            condition.setUpdateTime(minTime);
        }
        pager = attendenceService.findPage(pager, condition);
        res.setResponse(pager);
        return res;
    }

    @RequestMapping(value = "/attendence/location", method = RequestMethod.POST)
    public JsonResponse addLocation(HttpServletRequest request, HttpServletResponse response
            , Attendency attendence) throws ECAuthException, ECParamsRequiredException, ECAttendenceException {
        JsonResponse res = new JsonResponse();

        if (!CommonUtility.isNonEmpty(attendence.getLocation())) {
            throw new ECParamsRequiredException("The location parameter can not be empty.");
        }
        if (!CommonUtility.isNonEmpty(attendence.getLatitude())) {
            throw new ECParamsRequiredException("The latitude parameter can not be empty.");
        }
        if (!CommonUtility.isNonEmpty(attendence.getLongtitude())) {
            throw new ECParamsRequiredException("The longtitude parameter can not be empty.");
        }

        attendence.setMemberId(ApiUtil.getRequestUserId(request));
        attendence.setUpdateDate(CommonUtility.formateDate(new Date(), "yyyy-MM-dd"));
        attendence.setUpdateTime(CommonUtility.formateDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        attendenceService.add(attendence);
        return res;
    }
}

