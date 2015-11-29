/* 
 * Globalroam 2015 @copyright 
 */
package com.grcms.im.ronghub.api.domain;

import java.lang.reflect.Member;
import java.util.Date;

/**
 * @Author: jiepeng
 * @Date:2015/11/13 0013
 * @Description: attendence will provide location information and so on.
 */
public class Attendence {
    private String id; //UUID
    private String memberId;
    private String location; //location information from client
    private String remark;
    private String updateDate;
    private String updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
