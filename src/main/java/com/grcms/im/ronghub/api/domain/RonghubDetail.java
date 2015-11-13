/* 
 * Globalroam 2015 @copyright 
 */
package com.grcms.im.ronghub.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Member;
import java.util.Date;

/**
 * @Author: jiepeng
 * @Date:2015/11/13 0013
 * @Description: everytime send request to ronghub then return this object.
 */
public class RonghubDetail {
    @JsonIgnore
    private String id; //UUID
    @SerializedName("user_id")
    private String userId;//ronghub user id
    private String token; //token from ronghub
    @SerializedName("expire_date")
    private Date expireDate; //expire date for token

    public RonghubDetail() {}

    public RonghubDetail(String userId,String token,Date expireDate) {
        this.userId = userId;
        this.token = token;
        this.expireDate = expireDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

}
