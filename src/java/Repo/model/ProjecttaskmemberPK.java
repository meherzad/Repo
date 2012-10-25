/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClass;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Meherzad
 */
@Embeddable
public class ProjecttaskmemberPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "taskId")
    private int taskId;
    @Basic(optional = false)
    @Column(name = "userId")
    private int userId;

    public ProjecttaskmemberPK() {
    }

    public ProjecttaskmemberPK(int taskId, int userId) {
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
        if (!(object instanceof ProjecttaskmemberPK)) {
            return false;
        }
        ProjecttaskmemberPK other = (ProjecttaskmemberPK) object;
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
        return "EntityClass.ProjecttaskmemberPK[ taskId=" + taskId + ", userId=" + userId + " ]";
    }
}
