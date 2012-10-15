/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author meherzad
 */
@Embeddable
public class ProjectTaskMemberPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "taskId", nullable = false)
    private int taskId;
    @Basic(optional = false)
    @Column(name = "userId", nullable = false)
    private int userId;

    public ProjectTaskMemberPK() {
    }

    public ProjectTaskMemberPK(int taskId, int userId) {
        this.taskId = taskId;
        this.userId = userId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) taskId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectTaskMemberPK)) {
            return false;
        }
        ProjectTaskMemberPK other = (ProjectTaskMemberPK) object;
        if (this.taskId != other.taskId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Repo.model.ProjectTaskMemberPK[ taskId=" + taskId + ", userId=" + userId + " ]";
    }
    
}
