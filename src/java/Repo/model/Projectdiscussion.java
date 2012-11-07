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
public class Projectdiscussion {

    private Integer discussionId;
    private Integer projId;
    private String discussionHead;
    private Date timeStamp;
    private Integer userId;

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getUsrName() {
        return usrName;
    }
    private String usrName;


    public Projectdiscussion() {
    }

    public Projectdiscussion(Integer discussionId) {
        this.discussionId = discussionId;
    }

    public Integer getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(Integer discussionId) {
        this.discussionId = discussionId;
    }

    public Integer getProjId() {
        return projId;
    }

    public void setProjId(Integer projId) {
        this.projId = projId;
    }

    public String getDiscussionHead() {
        return discussionHead;
    }

    public void setDiscussionHead(String discussionHead) {
        this.discussionHead = discussionHead;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (discussionId != null ? discussionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projectdiscussion)) {
            return false;
        }
        Projectdiscussion other = (Projectdiscussion) object;
        if ((this.discussionId == null && other.discussionId != null) || (this.discussionId != null && !this.discussionId.equals(other.discussionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClass.Projectdiscussion[ discussionId=" + discussionId + " ]";
    }
}
