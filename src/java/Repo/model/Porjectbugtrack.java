/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.model;

import java.util.Date;

/**
 *
 * @author Meherzad
 */
public class Porjectbugtrack {

    private Integer bugId;
    private Integer projectId;
    private String issue;
    private Date timeStamp;
    private Integer userId;
    private String bugState;
    private String solution;
    private String fileUrl;

    public Porjectbugtrack() {
    }

    public Porjectbugtrack(Integer bugId) {
        this.bugId = bugId;
    }

    public Integer getBugId() {
        return bugId;
    }

    public void setBugId(Integer bugId) {
        this.bugId = bugId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBugState() {
        return bugState;
    }

    public void setBugState(String bugState) {
        this.bugState = bugState;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bugId != null ? bugId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Porjectbugtrack)) {
            return false;
        }
        Porjectbugtrack other = (Porjectbugtrack) object;
        if ((this.bugId == null && other.bugId != null) || (this.bugId != null && !this.bugId.equals(other.bugId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClass.Porjectbugtrack[ bugId=" + bugId + " ]";
    }
}
