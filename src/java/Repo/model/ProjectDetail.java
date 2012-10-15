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
@Table(name = "ProjectDetail", catalog = "repo", schema = "")
@NamedQueries({
    @NamedQuery(name = "ProjectDetail.findAll", query = "SELECT p FROM ProjectDetail p"),
    @NamedQuery(name = "ProjectDetail.findByProjectId", query = "SELECT p FROM ProjectDetail p WHERE p.projectDetailPK.projectId = :projectId"),
    @NamedQuery(name = "ProjectDetail.findByUserId", query = "SELECT p FROM ProjectDetail p WHERE p.projectDetailPK.userId = :userId"),
    @NamedQuery(name = "ProjectDetail.findByJDate", query = "SELECT p FROM ProjectDetail p WHERE p.jDate = :jDate")})
public class ProjectDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjectDetailPK projectDetailPK;
    @Column(name = "jDate")
    @Temporal(TemporalType.DATE)
    private Date jDate;

    public ProjectDetail() {
    }

    public ProjectDetail(ProjectDetailPK projectDetailPK) {
        this.projectDetailPK = projectDetailPK;
    }

    public ProjectDetail(int projectId, int userId) {
        this.projectDetailPK = new ProjectDetailPK(projectId, userId);
    }

    public ProjectDetailPK getProjectDetailPK() {
        return projectDetailPK;
    }

    public void setProjectDetailPK(ProjectDetailPK projectDetailPK) {
        this.projectDetailPK = projectDetailPK;
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
        hash += (projectDetailPK != null ? projectDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectDetail)) {
            return false;
        }
        ProjectDetail other = (ProjectDetail) object;
        if ((this.projectDetailPK == null && other.projectDetailPK != null) || (this.projectDetailPK != null && !this.projectDetailPK.equals(other.projectDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Repo.model.ProjectDetail[ projectDetailPK=" + projectDetailPK + " ]";
    }
    
}
