/* 
 * Globalroam 2015 @copyright 
 */
package com.grcms.im.ronghub.api.domain;

import java.util.List;

/**
 * @Author: jiepeng
 * @Date:2015/12/18 0018
 * @Description:
 */
public class ContactsGroup {
    private Integer groupId;
    private String groupName;
    private List<Contacts> contacts;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }
}
