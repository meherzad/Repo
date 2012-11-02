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

    private Integer userId;
    private String username;
    private String password;
    private Date jDate;
    private String iurl;
    private String nick;
    private String aboutUser;
    private String forgetPasswordId;
    private String verificationId;
    private String verified;

    public void setIurl(String iurl) {
        this.iurl = iurl;
    }

    public void setAboutUser(String aboutUser) {
        this.aboutUser = aboutUser;
    }

    public void setForgetPasswordId(String forgetPasswordId) {
        this.forgetPasswordId = forgetPasswordId;
    }

    public void setVerificationId(String verificationId) {
        this.verificationId = verificationId;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public String getIurl() {
        return iurl;
    }

    public String getAboutUser() {
        return aboutUser;
    }

    public String getForgetPasswordId() {
        return forgetPasswordId;
    }

    public String getVerificationId() {
        return verificationId;
    }

    public String getVerified() {
        return verified;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }

    public Usermaster() {
    }

    public void setjDate(Date jDate) {
        this.jDate = jDate;
    }

    public Date getjDate() {
        return jDate;
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
