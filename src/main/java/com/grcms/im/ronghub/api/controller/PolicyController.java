package com.grcms.im.ronghub.api.controller;

import com.grcms.content.core.exception.ECCMSInfoException;
import com.grcms.content.core.exception.ECCMSNodeException;
import com.grcms.content.core.form.NodeForm;
import com.grcms.content.core.service.CMSInfoService;
import com.grcms.content.core.service.CMSNodeService;
import com.grcms.content.core.util.ContentViewUtil;
import com.grcms.core.exception.ECAuthException;
import com.grcms.frontend.exception.ECMemberException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2015/11/15.
 */

@Controller
@RequestMapping("")
public class PolicyController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(PolicyController.class);
    @Autowired
    private CMSNodeService cmsNodeSerivce;
    @Autowired
    private CMSInfoService cmsInfoService;

    /**
     * @param request
     * @param response
     * @return
     * @throws ECAuthException
     * @throws ECMemberException
     * @throws ECCMSNodeException
     */
    @RequestMapping(value = "/api/policy", method = RequestMethod.GET)
    public String polciy(HttpServletRequest request, HttpServletResponse response
            , @ModelAttribute("form") NodeForm form) throws ECAuthException, ECMemberException, ECCMSNodeException {
        return ContentViewUtil.findNodeView(cmsNodeSerivce, request, "policy", false);
    }

    @RequestMapping(value = "/policy/{infoId}.do", method = RequestMethod.GET)
    public String polciyDetail(HttpServletRequest request, HttpServletResponse response
            , @PathVariable String infoId
            ) throws ECAuthException, ECMemberException, ECCMSNodeException, ECCMSInfoException {
        return ContentViewUtil.findInfoView(cmsNodeSerivce, cmsInfoService, request, "policy", infoId, false);
    }
}

