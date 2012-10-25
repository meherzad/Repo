/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.model;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author Meherzad
 */
public class Projectinvitation  {

    private Integer invitationId;
    private Integer fromUser;
    private Integer toUser;
    private Integer projId;
    private Date timeStamp;
    private String flag;
    private String status;

    public Projectinvitation() {
    }

    public Projectinvitation(Integer invitationId) {
        this.invitationId = invitationId;
    }

    public Integer getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(Integer invitationId) {
        this.invitationId = invitationId;
    }

    public Integer getFromUser() {
        return fromUser;
    }

    public void setFromUser(Integer fromUser) {
        this.fromUser = fromUser;
    }

    public Integer getToUser() {
        return toUser;
    }

    public void setToUser(Integer toUser) {
        this.toUser = toUser;
    }

    public Integer getProjId() {
        return projId;
    }

    public void setProjId(Integer projId) {
        this.projId = projId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invitationId != null ? invitationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projectinvitation)) {
            return false;
        }
        Projectinvitation other = (Projectinvitation) object;
        if ((this.invitationId == null && other.invitationId != null) || (this.invitationId != null && !this.invitationId.equals(other.invitationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClass.Projectinvitation[ invitationId=" + invitationId + " ]";
    }
}
