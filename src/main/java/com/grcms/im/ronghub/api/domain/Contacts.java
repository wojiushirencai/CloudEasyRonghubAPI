/* 
 * Globalroam 2015 @copyright 
 */
package com.grcms.im.ronghub.api.domain;

/**
 * @Author: jiepeng
 * @Date:2015/11/19 0019
 * @Description:
 */
public class Contacts {
    private String userId;
    private String username;
    private String phoneNumber;
    private String portraitUri;
    private String token;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPortraitUri() {
        return portraitUri;
    }

    public void setPortraitUri(String portraitUri) {
        this.portraitUri = portraitUri;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
