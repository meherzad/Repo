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
public class UserMaster {

    private Integer userId;
    private String username;
    private String password;
    private Date jDate;

    public UserMaster() {
    }

    public UserMaster(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getJDate() {
        return jDate;
    }

    public void setJDate(Date jDate) {
        this.jDate = jDate;
    }

    @Override
    public String toString() {
        return "Repo.model.UserMaster[ userId=" + userId + " ]";
    }
}
