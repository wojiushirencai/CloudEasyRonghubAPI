package com.grcms.im.ronghub.api.controller;

import com.grcms.core.exception.ECAuthException;
import com.grcms.core.response.JsonResponse;
import com.grcms.frontend.service.MemberService;
import com.grcms.im.ronghub.api.domain.Contacts;
import com.grcms.im.ronghub.api.domain.ContactsGroup;
import com.grcms.im.ronghub.api.service.AuthService;
import com.grcms.im.ronghub.api.service.ContactsService;
import com.grcms.im.ronghub.api.util.ApiUtil;
import com.grcms.management.user.domain.Department;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */

@RestController
@RequestMapping("/api")
public class ContactsController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(ContactsController.class);
    private static final String AJAX_REQUEST = "XMLHttpRequest";

    @Autowired
    private AuthService authService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private ContactsService contactsService;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public JsonResponse contacts(HttpServletRequest request, HttpServletResponse response) throws ECAuthException {
        JsonResponse res = new JsonResponse();
        try {
            List<Contacts> contacts = contactsService.getContacts();
            if(null == contacts || contacts.size() == 0) {
                res.setResponse("No data");
                return res;
            }
            for(Contacts c : contacts) {
                c.setPortraitUri(ApiUtil.generatePortraitUrl(request,c.getPortraitUri()));
            }
            res.setResponse(contacts);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @RequestMapping(value = "/contacts/department", method = RequestMethod.GET)
    public JsonResponse departments(HttpServletRequest request, HttpServletResponse response) throws ECAuthException {
        JsonResponse res = new JsonResponse();
        try {
            List<ContactsGroup> top = contactsService.getContactsByAllDepartment();
            for(ContactsGroup cg:top) {
                for(Contacts c: cg.getContacts()) {
                    c.setPortraitUri(ApiUtil.generatePortraitUrl(request,c.getPortraitUri()));
                }
            }
            res.setResponse(top);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}

