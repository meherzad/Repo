/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author meherzad
 */
@Entity
@Table(name = "ProjectTaskMember", catalog = "repo", schema = "")
@NamedQueries({
    @NamedQuery(name = "ProjectTaskMember.findAll", query = "SELECT p FROM ProjectTaskMember p"),
    @NamedQuery(name = "ProjectTaskMember.findByTaskId", query = "SELECT p FROM ProjectTaskMember p WHERE p.projectTaskMemberPK.taskId = :taskId"),
    @NamedQuery(name = "ProjectTaskMember.findByUserId", query = "SELECT p FROM ProjectTaskMember p WHERE p.projectTaskMemberPK.userId = :userId")})
public class ProjectTaskMember implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjectTaskMemberPK projectTaskMemberPK;

    public ProjectTaskMember() {
    }

    public ProjectTaskMember(ProjectTaskMemberPK projectTaskMemberPK) {
        this.projectTaskMemberPK = projectTaskMemberPK;
    }

    public ProjectTaskMember(int taskId, int userId) {
        this.projectTaskMemberPK = new ProjectTaskMemberPK(taskId, userId);
    }

    public ProjectTaskMemberPK getProjectTaskMemberPK() {
        return projectTaskMemberPK;
    }

    public void setProjectTaskMemberPK(ProjectTaskMemberPK projectTaskMemberPK) {
        this.projectTaskMemberPK = projectTaskMemberPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectTaskMemberPK != null ? projectTaskMemberPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectTaskMember)) {
            return false;
        }
        ProjectTaskMember other = (ProjectTaskMember) object;
        if ((this.projectTaskMemberPK == null && other.projectTaskMemberPK != null) || (this.projectTaskMemberPK != null && !this.projectTaskMemberPK.equals(other.projectTaskMemberPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Repo.model.ProjectTaskMember[ projectTaskMemberPK=" + projectTaskMemberPK + " ]";
    }
    
}
