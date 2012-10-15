/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author meherzad
 */
@Entity
@Table(name = "ProjectInvitation", catalog = "repo", schema = "")
@NamedQueries({
    @NamedQuery(name = "ProjectInvitation.findAll", query = "SELECT p FROM ProjectInvitation p"),
    @NamedQuery(name = "ProjectInvitation.findByInvitationId", query = "SELECT p FROM ProjectInvitation p WHERE p.invitationId = :invitationId"),
    @NamedQuery(name = "ProjectInvitation.findByFromUser", query = "SELECT p FROM ProjectInvitation p WHERE p.fromUser = :fromUser"),
    @NamedQuery(name = "ProjectInvitation.findByToUser", query = "SELECT p FROM ProjectInvitation p WHERE p.toUser = :toUser"),
    @NamedQuery(name = "ProjectInvitation.findByProjId", query = "SELECT p FROM ProjectInvitation p WHERE p.projId = :projId"),
    @NamedQuery(name = "ProjectInvitation.findByTimeStamp", query = "SELECT p FROM ProjectInvitation p WHERE p.timeStamp = :timeStamp"),
    @NamedQuery(name = "ProjectInvitation.findByFlag", query = "SELECT p FROM ProjectInvitation p WHERE p.flag = :flag"),
    @NamedQuery(name = "ProjectInvitation.findByStatus", query = "SELECT p FROM ProjectInvitation p WHERE p.status = :status")})
public class ProjectInvitation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invitationId", nullable = false)
    private Integer invitationId;
    @Column(name = "fromUser")
    private Integer fromUser;
    @Column(name = "toUser")
    private Integer toUser;
    @Column(name = "projId")
    private Integer projId;
    @Column(name = "timeStamp")
    @Temporal(TemporalType.DATE)
    private Date timeStamp;
    @Column(name = "flag", length = 10)
    private String flag;
    @Column(name = "status", length = 10)
    private String status;

    public ProjectInvitation() {
    }

    public ProjectInvitation(Integer invitationId) {
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
        if (!(object instanceof ProjectInvitation)) {
            return false;
        }
        ProjectInvitation other = (ProjectInvitation) object;
        if ((this.invitationId == null && other.invitationId != null) || (this.invitationId != null && !this.invitationId.equals(other.invitationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Repo.model.ProjectInvitation[ invitationId=" + invitationId + " ]";
    }
    
}
