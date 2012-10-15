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
@Table(name = "UserLog", catalog = "repo", schema = "")
@NamedQueries({
    @NamedQuery(name = "UserLog.findAll", query = "SELECT u FROM UserLog u"),
    @NamedQuery(name = "UserLog.findByUserId", query = "SELECT u FROM UserLog u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserLog.findByUId", query = "SELECT u FROM UserLog u WHERE u.uId = :uId"),
    @NamedQuery(name = "UserLog.findByTimeStamp", query = "SELECT u FROM UserLog u WHERE u.timeStamp = :timeStamp"),
    @NamedQuery(name = "UserLog.findByProjectId", query = "SELECT u FROM UserLog u WHERE u.projectId = :projectId")})
public class UserLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "userId")
    private Integer userId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uId", nullable = false)
    private Integer uId;
    @Column(name = "timeStamp")
    @Temporal(TemporalType.DATE)
    private Date timeStamp;
    @Column(name = "projectId")
    private Integer projectId;

    public UserLog() {
    }

    public UserLog(Integer uId) {
        this.uId = uId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uId != null ? uId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserLog)) {
            return false;
        }
        UserLog other = (UserLog) object;
        if ((this.uId == null && other.uId != null) || (this.uId != null && !this.uId.equals(other.uId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Repo.model.UserLog[ uId=" + uId + " ]";
    }
    
}
