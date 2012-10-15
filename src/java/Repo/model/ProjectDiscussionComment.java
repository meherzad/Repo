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
@Table(name = "ProjectDiscussionComment", catalog = "repo", schema = "")
@NamedQueries({
    @NamedQuery(name = "ProjectDiscussionComment.findAll", query = "SELECT p FROM ProjectDiscussionComment p"),
    @NamedQuery(name = "ProjectDiscussionComment.findByUId", query = "SELECT p FROM ProjectDiscussionComment p WHERE p.uId = :uId"),
    @NamedQuery(name = "ProjectDiscussionComment.findByDiscussionId", query = "SELECT p FROM ProjectDiscussionComment p WHERE p.discussionId = :discussionId"),
    @NamedQuery(name = "ProjectDiscussionComment.findByUserId", query = "SELECT p FROM ProjectDiscussionComment p WHERE p.userId = :userId"),
    @NamedQuery(name = "ProjectDiscussionComment.findByTimeSatmp", query = "SELECT p FROM ProjectDiscussionComment p WHERE p.timeSatmp = :timeSatmp"),
    @NamedQuery(name = "ProjectDiscussionComment.findByComment", query = "SELECT p FROM ProjectDiscussionComment p WHERE p.comment = :comment"),
    @NamedQuery(name = "ProjectDiscussionComment.findByLikes", query = "SELECT p FROM ProjectDiscussionComment p WHERE p.likes = :likes")})
public class ProjectDiscussionComment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uId", nullable = false)
    private Integer uId;
    @Column(name = "discussionId")
    private Integer discussionId;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "timeSatmp")
    @Temporal(TemporalType.DATE)
    private Date timeSatmp;
    @Column(name = "comment", length = 500)
    private String comment;
    @Column(name = "likes")
    private Integer likes;

    public ProjectDiscussionComment() {
    }

    public ProjectDiscussionComment(Integer uId) {
        this.uId = uId;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public Integer getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(Integer discussionId) {
        this.discussionId = discussionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getTimeSatmp() {
        return timeSatmp;
    }

    public void setTimeSatmp(Date timeSatmp) {
        this.timeSatmp = timeSatmp;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uId != null ? uId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectDiscussionComment)) {
            return false;
        }
        ProjectDiscussionComment other = (ProjectDiscussionComment) object;
        if ((this.uId == null && other.uId != null) || (this.uId != null && !this.uId.equals(other.uId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Repo.model.ProjectDiscussionComment[ uId=" + uId + " ]";
    }
    
}
