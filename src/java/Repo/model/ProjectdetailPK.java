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
public class ProjectdetailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "projectId")
    private int projectId;
    @Basic(optional = false)
    @Column(name = "userId")
    private int userId;

    public ProjectdetailPK() {
    }

    public ProjectdetailPK(int projectId, int userId) {
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
        if (!(object instanceof ProjectdetailPK)) {
            return false;
        }
        ProjectdetailPK other = (ProjectdetailPK) object;
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
        return "EntityClass.ProjectdetailPK[ projectId=" + projectId + ", userId=" + userId + " ]";
    }
}
