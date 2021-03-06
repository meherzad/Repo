/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Meherzad
 */
public class Projecttask {

    private Integer taskId;
    private Integer projectId;
    private Integer phaseId;
    private Date deadLine;
    private String taskDescription;
    private ArrayList<Projecttaskdetail> subTask;
    private ArrayList<Projecttaskmember> taskMember;

    public void setSubTask(ArrayList<Projecttaskdetail> subTask) {
        this.subTask = subTask;
    }

    public void setTaskMember(ArrayList<Projecttaskmember> taskMember) {
        this.taskMember = taskMember;
    }

    public void addSubTask(Projecttaskdetail subTask) {
        this.subTask.add(subTask);
    }

    public void addMember(Projecttaskmember member) {
        this.taskMember.add(member);
    }

    public ArrayList<Projecttaskdetail> getSubTask() {
        return subTask;
    }

    public ArrayList<Projecttaskmember> getTaskMember() {
        return taskMember;
    }

    public Projecttask() {
        subTask = new ArrayList<Projecttaskdetail>();
        taskMember = new ArrayList<Projecttaskmember>();
    }

    public Projecttask(Integer taskId) {
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
        if (!(object instanceof Projecttask)) {
            return false;
        }
        Projecttask other = (Projecttask) object;
        if ((this.taskId == null && other.taskId != null) || (this.taskId != null && !this.taskId.equals(other.taskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClass.Projecttask[ taskId=" + taskId + " ]";
    }
}
