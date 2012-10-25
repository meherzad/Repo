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
public class Projectdetail implements Serializable {
    private int projectId;
    private int userId;
    private Date jDate;

    public void setjDate(Date jDate) {
        this.jDate = jDate;
    }

    public Date getjDate() {
        return jDate;
    }

    public Projectdetail() {
    }

    public Projectdetail(int projectId, int userId, Date jDate) {
        this.projectId = projectId;
        this.userId = userId;
        this.jDate=jDate;
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
        if (!(object instanceof Projectdetail)) {
            return false;
        }
        Projectdetail other = (Projectdetail) object;
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
        return "EntityClass.Projectdetail[ projectId=" + projectId + ", userId=" + userId + " ]";
    }
}
