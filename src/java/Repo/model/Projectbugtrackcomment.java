/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClass;

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
 * @author Meherzad
 */
@Entity
@Table(name = "projectbugtrackcomment")
@NamedQueries({
    @NamedQuery(name = "Projectbugtrackcomment.findAll", query = "SELECT p FROM Projectbugtrackcomment p")})
public class Projectbugtrackcomment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uId")
    private Integer uId;
    @Column(name = "bugId")
    private Integer bugId;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "timeSatmp")
    @Temporal(TemporalType.DATE)
    private Date timeSatmp;
    @Column(name = "comment")
    private String comment;
    @Column(name = "likes")
    private Integer likes;

    public Projectbugtrackcomment() {
    }

    public Projectbugtrackcomment(Integer uId) {
        this.uId = uId;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public Integer getBugId() {
        return bugId;
    }

    public void setBugId(Integer bugId) {
        this.bugId = bugId;
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
        if (!(object instanceof Projectbugtrackcomment)) {
            return false;
        }
        Projectbugtrackcomment other = (Projectbugtrackcomment) object;
        if ((this.uId == null && other.uId != null) || (this.uId != null && !this.uId.equals(other.uId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClass.Projectbugtrackcomment[ uId=" + uId + " ]";
    }
}
