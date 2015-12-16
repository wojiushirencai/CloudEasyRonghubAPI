package com.grcms.im.ronghub.api.controller;

import com.grcms.common.util.CommonUtility;
import com.grcms.content.core.domain.CMSInfo;
import com.grcms.content.core.exception.ECCMSInfoException;
import com.grcms.content.core.exception.ECCMSNodeException;
import com.grcms.core.exception.ECAuthException;
import com.grcms.core.form.BasicForm;
import com.grcms.core.response.JsonResponse;
import com.grcms.core.util.CMSThemeUtil;
import com.grcms.core.util.ForwardUtility;
import com.grcms.frontend.domain.Member;
import com.grcms.frontend.exception.ECMemberException;
import com.grcms.frontend.service.MemberService;
import com.grcms.im.ronghub.api.domain.Daily;
import com.grcms.im.ronghub.api.service.DailyService;
import com.grcms.im.ronghub.api.util.ApiUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;

/**
 * Created by Administrator on 2015/11/15.
 */

@Controller
@RequestMapping("/management/daily")
public class DailyBackendController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(DailyBackendController.class);
    @Autowired
    private DailyService dailyService;
    @Autowired
    private MemberService memberService;

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
        return ForwardUtility.forwardAdminView("daily/list_daily");
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String dailyData(HttpServletRequest request, HttpServletResponse response
            , @ModelAttribute("form") BasicForm form) throws ECAuthException, ECMemberException, ECCMSNodeException {
        return ForwardUtility.forwardAdminView("daily/data/data_json_daily");
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(HttpServletRequest request, HttpServletResponse response
            , @ModelAttribute("form") BasicForm form) throws ECAuthException, ECMemberException, ECCMSNodeException {
        return ForwardUtility.forwardAdminView("daily/data/data_json_daily");
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

//        for(String id :ids) {
//            CMSInfo info = cmsInfoService.findById(id);
//            if (info.getNode().getInfoOpenStatic()) {
//                String filepath = CMSThemeUtil.getPathAsLocal(new String[]{
//                        request.getServletContext().getRealPath(""),
//                        info.getUri()
//                });
//                File file = new File(filepath);
//                file.delete();
//            }
//        }
//        cmsInfoService.delete(ids);
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

}

