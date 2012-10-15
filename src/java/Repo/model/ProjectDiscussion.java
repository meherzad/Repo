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
@Table(name = "ProjectDiscussion", catalog = "repo", schema = "")
@NamedQueries({
    @NamedQuery(name = "ProjectDiscussion.findAll", query = "SELECT p FROM ProjectDiscussion p"),
    @NamedQuery(name = "ProjectDiscussion.findByDiscussionId", query = "SELECT p FROM ProjectDiscussion p WHERE p.discussionId = :discussionId"),
    @NamedQuery(name = "ProjectDiscussion.findByProjId", query = "SELECT p FROM ProjectDiscussion p WHERE p.projId = :projId"),
    @NamedQuery(name = "ProjectDiscussion.findByDiscussionHead", query = "SELECT p FROM ProjectDiscussion p WHERE p.discussionHead = :discussionHead"),
    @NamedQuery(name = "ProjectDiscussion.findByTimeStamp", query = "SELECT p FROM ProjectDiscussion p WHERE p.timeStamp = :timeStamp"),
    @NamedQuery(name = "ProjectDiscussion.findByUserId", query = "SELECT p FROM ProjectDiscussion p WHERE p.userId = :userId")})
public class ProjectDiscussion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "discussionId", nullable = false)
    private Integer discussionId;
    @Column(name = "projId")
    private Integer projId;
    @Column(name = "discussionHead", length = 500)
    private String discussionHead;
    @Column(name = "timeStamp")
    @Temporal(TemporalType.DATE)
    private Date timeStamp;
    @Column(name = "userId")
    private Integer userId;

    public ProjectDiscussion() {
    }

    public ProjectDiscussion(Integer discussionId) {
        this.discussionId = discussionId;
    }

    public Integer getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(Integer discussionId) {
        this.discussionId = discussionId;
    }

    public Integer getProjId() {
        return projId;
    }

    public void setProjId(Integer projId) {
        this.projId = projId;
    }

    public String getDiscussionHead() {
        return discussionHead;
    }

    public void setDiscussionHead(String discussionHead) {
        this.discussionHead = discussionHead;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (discussionId != null ? discussionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectDiscussion)) {
            return false;
        }
        ProjectDiscussion other = (ProjectDiscussion) object;
        if ((this.discussionId == null && other.discussionId != null) || (this.discussionId != null && !this.discussionId.equals(other.discussionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Repo.model.ProjectDiscussion[ discussionId=" + discussionId + " ]";
    }
    
}
