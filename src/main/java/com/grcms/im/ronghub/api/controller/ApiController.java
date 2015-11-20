package com.grcms.im.ronghub.api.controller;

import com.grcms.core.exception.ECAuthException;
import com.grcms.core.response.JsonResponse;
import com.grcms.frontend.domain.Member;
import com.grcms.frontend.service.MemberService;
import com.grcms.im.ronghub.api.domain.Contacts;
import com.grcms.im.ronghub.api.domain.RonghubDetail;
import com.grcms.im.ronghub.api.service.AuthService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */

@RestController
@RequestMapping("/api")
public class ApiController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(ApiController.class);
    private static final String AJAX_REQUEST = "XMLHttpRequest";

    @Autowired
    private AuthService authService;
    @Autowired
    private MemberService memberService;

    /**
     * authentication method
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public JsonResponse auth(HttpServletRequest request, HttpServletResponse response
            ,@RequestParam("username") String username
            ,@RequestParam("password") String password) throws ECAuthException {
        JsonResponse res = new JsonResponse();
        RonghubDetail detail = authService.executeAuth(username, password);
        res.setResponse(detail);
        return res;
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public JsonResponse contacts(HttpServletRequest request, HttpServletResponse response) throws ECAuthException {
        JsonResponse res = new JsonResponse();
        try {
            List<Member> members = memberService.findAll();
            if(null == members || members.size() == 0) {
                res.setResponse("No data");
                return res;
            }
            List<Contacts> contactses = new ArrayList<Contacts>();
            List<RonghubDetail> details = authService.findAll();
            for(Member m: members) {
                Contacts contacts = new Contacts();
                contacts.setUserId(m.getId());
                contacts.setUsername(m.getLoginId());
                contacts.setPhoneNumber(m.getPhoneNumber());
                contacts.setPortraitUri(m.getPortraitUri());
                for(RonghubDetail detail : details) {
                    if(contacts.getUserId().equals(detail.getUserId())) {
                        contacts.setToken(detail.getToken());
                        contactses.add(contacts);
                        break;
                    }
                }

            }
            res.setResponse(contactses);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}

