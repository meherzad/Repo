/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.model;

import java.util.Date;

/**
 *
 * @author Meherzad
 */
public class Usermaster {

    private static final long serialVersionUID = 1L;
    private Integer userId;
    private String username;
    private String password;
    private Date jDate;
    private String alternateEmail;

    public Usermaster() {
    }

    public void setjDate(Date jDate) {
        this.jDate = jDate;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public Date getjDate() {
        return jDate;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public Usermaster(Integer userId) {
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
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usermaster)) {
            return false;
        }
        Usermaster other = (Usermaster) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClass.Usermaster[ userId=" + userId + " ]";
    }
}
