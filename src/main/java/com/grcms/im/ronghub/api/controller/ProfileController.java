package com.grcms.im.ronghub.api.controller;

import com.grcms.core.exception.ECAuthException;
import com.grcms.core.response.JsonResponse;
import com.grcms.frontend.dao.MemberDao;
import com.grcms.frontend.exception.ECMemberException;
import com.grcms.im.ronghub.api.domain.Contacts;
import com.grcms.im.ronghub.api.domain.Profile;
import com.grcms.im.ronghub.api.service.ContactsService;
import com.grcms.im.ronghub.api.util.ApiUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2015/11/15.
 */

@RestController
@RequestMapping("/api")
public class ProfileController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(ProfileController.class);
    private static final String AJAX_REQUEST = "XMLHttpRequest";

    @Autowired
    private ContactsService contactsService;

    @Autowired
    private MemberDao memberDao;

    /**
     * Get member profile
     *
     * @param request
     * @param response
     * @return
     * @throws ECAuthException
     * @throws ECMemberException
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public JsonResponse profile(HttpServletRequest request, HttpServletResponse response) throws ECAuthException, ECMemberException {
        JsonResponse res = new JsonResponse();
        try {
            Contacts contacts = contactsService.findById(ApiUtil.getRequestUserId(request));
            Profile profile = new Profile();
            profile.setUserId(contacts.getUserId());
            profile.setLoginId(contacts.getUsername());
            profile.setPhoneNumber(contacts.getPhoneNumber());
            profile.setLastname(contacts.getLastname());
            profile.setFirstname(contacts.getFirstname());
            profile.setPortraitUri(contacts.getPortraitUri());
            res.setResponse(profile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ECMemberException(e.getMessage());
        }
        return res;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public JsonResponse updateProfile(HttpServletRequest request, HttpServletResponse response
            ,@RequestParam("firstname") String firstname
            ,@RequestParam("lastname") String lastname
            ,@RequestParam("phoneNumber") String phoneNumber
    ) throws ECAuthException, ECMemberException {
        JsonResponse res = new JsonResponse();
        try {
            Contacts contacts = contactsService.findById(ApiUtil.getRequestUserId(request));
            Profile profile = new Profile();
            profile.setUserId(contacts.getUserId());
            profile.setLoginId(contacts.getUsername());
            profile.setPhoneNumber(contacts.getPhoneNumber());
            profile.setLastname(contacts.getLastname());
            profile.setFirstname(contacts.getFirstname());
            profile.setPortraitUri(contacts.getPortraitUri());
            res.setResponse(profile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ECMemberException(e.getMessage());
        }
        return res;
    }

    /**
     * Update member password
     *
     * @param request
     * @param response
     * @return
     * @throws ECAuthException
     * @throws ECMemberException
     */
    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public JsonResponse updatePassword(HttpServletRequest request, HttpServletResponse response,
                                       @RequestParam("oldPassword") String oldPassword,
                                       @RequestParam("newPassword") String newPassword
    ) throws ECAuthException, ECMemberException {
        JsonResponse res = new JsonResponse();

        try {
            boolean result = memberDao.updatePassword(ApiUtil.getRequestUserId(request), oldPassword.trim(), newPassword.trim()) > 0;
            if(!result) {
                throw new ECMemberException("Update password failed,please check the oldPassword");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ECMemberException(e.getMessage());
        }
        return res;
    }
}

