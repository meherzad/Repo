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
@Table(name = "ProjectTask", catalog = "repo", schema = "")
@NamedQueries({
    @NamedQuery(name = "ProjectTask.findAll", query = "SELECT p FROM ProjectTask p"),
    @NamedQuery(name = "ProjectTask.findByTaskId", query = "SELECT p FROM ProjectTask p WHERE p.taskId = :taskId"),
    @NamedQuery(name = "ProjectTask.findByProjectId", query = "SELECT p FROM ProjectTask p WHERE p.projectId = :projectId"),
    @NamedQuery(name = "ProjectTask.findByPhaseId", query = "SELECT p FROM ProjectTask p WHERE p.phaseId = :phaseId"),
    @NamedQuery(name = "ProjectTask.findByDeadLine", query = "SELECT p FROM ProjectTask p WHERE p.deadLine = :deadLine"),
    @NamedQuery(name = "ProjectTask.findByTaskDescription", query = "SELECT p FROM ProjectTask p WHERE p.taskDescription = :taskDescription")})
public class ProjectTask implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "taskId", nullable = false)
    private Integer taskId;
    @Column(name = "projectId")
    private Integer projectId;
    @Column(name = "phaseId")
    private Integer phaseId;
    @Column(name = "deadLine")
    @Temporal(TemporalType.DATE)
    private Date deadLine;
    @Column(name = "taskDescription", length = 100)
    private String taskDescription;

    public ProjectTask() {
    }

    public ProjectTask(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(Integer phaseId) {
        this.phaseId = phaseId;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskId != null ? taskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectTask)) {
            return false;
        }
        ProjectTask other = (ProjectTask) object;
        if ((this.taskId == null && other.taskId != null) || (this.taskId != null && !this.taskId.equals(other.taskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Repo.model.ProjectTask[ taskId=" + taskId + " ]";
    }
    
}
