/* 
 * Globalroam 2015 @copyright 
 */
package com.grcms.im.ronghub.api.domain;

import java.lang.reflect.Member;
import java.util.Date;

/**
 * @Author: jiepeng
 * @Date:2015/11/13 0013
 * @Description: member can submit daily every morning and night
 */
public class Daily {
    private String id; //UUID
    private String title;
    private Date updateTime;
    private String updateTimeStr;
    private String content;
    private String memberId;
    private Integer departmentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
