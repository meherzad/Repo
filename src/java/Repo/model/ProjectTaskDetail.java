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
@Table(name = "ProjectTaskDetail", catalog = "repo", schema = "")
@NamedQueries({
    @NamedQuery(name = "ProjectTaskDetail.findAll", query = "SELECT p FROM ProjectTaskDetail p"),
    @NamedQuery(name = "ProjectTaskDetail.findByUId", query = "SELECT p FROM ProjectTaskDetail p WHERE p.uId = :uId"),
    @NamedQuery(name = "ProjectTaskDetail.findByTaskId", query = "SELECT p FROM ProjectTaskDetail p WHERE p.taskId = :taskId"),
    @NamedQuery(name = "ProjectTaskDetail.findBySubTask", query = "SELECT p FROM ProjectTaskDetail p WHERE p.subTask = :subTask"),
    @NamedQuery(name = "ProjectTaskDetail.findByStatus", query = "SELECT p FROM ProjectTaskDetail p WHERE p.status = :status"),
    @NamedQuery(name = "ProjectTaskDetail.findByTimeStamp", query = "SELECT p FROM ProjectTaskDetail p WHERE p.timeStamp = :timeStamp")})
public class ProjectTaskDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uId", nullable = false)
    private Integer uId;
    @Column(name = "taskId")
    private Integer taskId;
    @Column(name = "subTask", length = 50)
    private String subTask;
    @Column(name = "status", length = 10)
    private String status;
    @Column(name = "timeStamp")
    @Temporal(TemporalType.DATE)
    private Date timeStamp;

    public ProjectTaskDetail() {
    }

    public ProjectTaskDetail(Integer uId) {
        this.uId = uId;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getSubTask() {
        return subTask;
    }

    public void setSubTask(String subTask) {
        this.subTask = subTask;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
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
        if (!(object instanceof ProjectTaskDetail)) {
            return false;
        }
        ProjectTaskDetail other = (ProjectTaskDetail) object;
        if ((this.uId == null && other.uId != null) || (this.uId != null && !this.uId.equals(other.uId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Repo.model.ProjectTaskDetail[ uId=" + uId + " ]";
    }
    
}
