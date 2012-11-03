/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.model;

import java.util.Date;

/**
 *
 * @author meherzad
 */
public class Notification {

    private int notId;
    private int userId;
    private String notification;
    private Date timeStamp;
    private String notType;
    private int rID;

    public int getNotId() {
        return notId;
    }

    public void setNotId(int notId) {
        this.notId = notId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNotType() {
        return notType;
    }

    public void setNotType(String notType) {
        this.notType = notType;
    }

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }
}
