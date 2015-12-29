package com.grcms.im.ronghub.api.controller;

import com.grcms.content.core.exception.ECCMSNodeException;
import com.grcms.core.exception.ECAuthException;
import com.grcms.core.form.BasicForm;
import com.grcms.core.response.JsonResponse;
import com.grcms.core.util.ForwardUtility;
import com.grcms.frontend.exception.ECMemberException;
import com.grcms.im.ronghub.api.domain.Attendency;
import com.grcms.im.ronghub.api.service.AttendenceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2015/11/15.
 */

@Controller
@RequestMapping("/management/attendency")
public class LocationBackendController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(LocationBackendController.class);
    @Autowired
    private AttendenceService attendenceService;

    /**
     * @param request
     * @param response
     * @return
     * @throws ECAuthException
     * @throws ECMemberException
     * @throws ECCMSNodeException
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String daily(HttpServletRequest request, HttpServletResponse response
            , @ModelAttribute("form") BasicForm form) throws ECAuthException, ECMemberException, ECCMSNodeException {
        return ForwardUtility.forwardAdminView("attendency/list_attendency");
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String dailyData(HttpServletRequest request, HttpServletResponse response
            , @ModelAttribute("form") BasicForm form
            , @ModelAttribute("attendency")Attendency attendency) throws ECAuthException, ECMemberException, ECCMSNodeException {
        return ForwardUtility.forwardAdminView("attendency/data/data_json_attendency");
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(HttpServletRequest request, HttpServletResponse response
            , @RequestParam String id
            , @ModelAttribute("form") BasicForm form) throws ECAuthException, ECMemberException, ECCMSNodeException {
        request.setAttribute("id",id);
        return ForwardUtility.forwardAdminView("attendency/modal_attendency_view");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse deleteDaily(HttpServletRequest request, HttpServletResponse response
            , @ModelAttribute("form") BasicForm form) throws Exception {
        JsonResponse jres = new JsonResponse();
        String[] ids = request.getParameterValues("id");
        if (ids == null || ids.length == 0) {
            jres.setMessage("Id can not be null");
            return jres;
        }

        attendenceService.deleteByIds(ids);
        return jres;
    }

}

