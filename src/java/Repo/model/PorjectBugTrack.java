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
@Table(name = "PorjectBugTrack", catalog = "repo", schema = "")
@NamedQueries({
    @NamedQuery(name = "PorjectBugTrack.findAll", query = "SELECT p FROM PorjectBugTrack p"),
    @NamedQuery(name = "PorjectBugTrack.findByBugId", query = "SELECT p FROM PorjectBugTrack p WHERE p.bugId = :bugId"),
    @NamedQuery(name = "PorjectBugTrack.findByProjectId", query = "SELECT p FROM PorjectBugTrack p WHERE p.projectId = :projectId"),
    @NamedQuery(name = "PorjectBugTrack.findByIssue", query = "SELECT p FROM PorjectBugTrack p WHERE p.issue = :issue"),
    @NamedQuery(name = "PorjectBugTrack.findByTimeStamp", query = "SELECT p FROM PorjectBugTrack p WHERE p.timeStamp = :timeStamp"),
    @NamedQuery(name = "PorjectBugTrack.findByUserId", query = "SELECT p FROM PorjectBugTrack p WHERE p.userId = :userId"),
    @NamedQuery(name = "PorjectBugTrack.findByBugState", query = "SELECT p FROM PorjectBugTrack p WHERE p.bugState = :bugState"),
    @NamedQuery(name = "PorjectBugTrack.findBySolution", query = "SELECT p FROM PorjectBugTrack p WHERE p.solution = :solution"),
    @NamedQuery(name = "PorjectBugTrack.findByFileUrl", query = "SELECT p FROM PorjectBugTrack p WHERE p.fileUrl = :fileUrl")})
public class PorjectBugTrack implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bugId", nullable = false)
    private Integer bugId;
    @Column(name = "projectId")
    private Integer projectId;
    @Column(name = "issue", length = 500)
    private String issue;
    @Column(name = "timeStamp")
    @Temporal(TemporalType.DATE)
    private Date timeStamp;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "bugState", length = 50)
    private String bugState;
    @Column(name = "solution", length = 500)
    private String solution;
    @Column(name = "fileUrl", length = 50)
    private String fileUrl;

    public PorjectBugTrack() {
    }

    public PorjectBugTrack(Integer bugId) {
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
        if (!(object instanceof PorjectBugTrack)) {
            return false;
        }
        PorjectBugTrack other = (PorjectBugTrack) object;
        if ((this.bugId == null && other.bugId != null) || (this.bugId != null && !this.bugId.equals(other.bugId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Repo.model.PorjectBugTrack[ bugId=" + bugId + " ]";
    }
    
}
