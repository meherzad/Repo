/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "ProjectFollower", catalog = "repo", schema = "")
@NamedQueries({
    @NamedQuery(name = "ProjectFollower.findAll", query = "SELECT p FROM ProjectFollower p"),
    @NamedQuery(name = "ProjectFollower.findByProjectId", query = "SELECT p FROM ProjectFollower p WHERE p.projectFollowerPK.projectId = :projectId"),
    @NamedQuery(name = "ProjectFollower.findByUserId", query = "SELECT p FROM ProjectFollower p WHERE p.projectFollowerPK.userId = :userId"),
    @NamedQuery(name = "ProjectFollower.findByJDate", query = "SELECT p FROM ProjectFollower p WHERE p.jDate = :jDate")})
public class ProjectFollower implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjectFollowerPK projectFollowerPK;
    @Column(name = "jDate")
    @Temporal(TemporalType.DATE)
    private Date jDate;

    public ProjectFollower() {
    }

    public ProjectFollower(ProjectFollowerPK projectFollowerPK) {
        this.projectFollowerPK = projectFollowerPK;
    }

    public ProjectFollower(int projectId, int userId) {
        this.projectFollowerPK = new ProjectFollowerPK(projectId, userId);
    }

    public ProjectFollowerPK getProjectFollowerPK() {
        return projectFollowerPK;
    }

    public void setProjectFollowerPK(ProjectFollowerPK projectFollowerPK) {
        this.projectFollowerPK = projectFollowerPK;
    }

    public Date getJDate() {
        return jDate;
    }

    public void setJDate(Date jDate) {
        this.jDate = jDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectFollowerPK != null ? projectFollowerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectFollower)) {
            return false;
        }
        ProjectFollower other = (ProjectFollower) object;
        if ((this.projectFollowerPK == null && other.projectFollowerPK != null) || (this.projectFollowerPK != null && !this.projectFollowerPK.equals(other.projectFollowerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Repo.model.ProjectFollower[ projectFollowerPK=" + projectFollowerPK + " ]";
    }
    
}
