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
public class ProjectDetailPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "projectId", nullable = false)
    private int projectId;
    @Basic(optional = false)
    @Column(name = "userId", nullable = false)
    private int userId;

    public ProjectDetailPK() {
    }

    public ProjectDetailPK(int projectId, int userId) {
        this.projectId = projectId;
        this.userId = userId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
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
        hash += (int) projectId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectDetailPK)) {
            return false;
        }
        ProjectDetailPK other = (ProjectDetailPK) object;
        if (this.projectId != other.projectId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Repo.model.ProjectDetailPK[ projectId=" + projectId + ", userId=" + userId + " ]";
    }
    
}
