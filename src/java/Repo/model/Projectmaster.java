/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClass;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Meherzad
 */
@Entity
@Table(name = "projectmaster")
@NamedQueries({
    @NamedQuery(name = "Projectmaster.findAll", query = "SELECT p FROM Projectmaster p")})
public class Projectmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "projId")
    private Integer projId;
    @Column(name = "projName")
    private String projName;
    @Column(name = "projDesc")
    private String projDesc;
    @Column(name = "projOwner")
    private Integer projOwner;
    @Column(name = "downloads")
    private Integer downloads;
    @Column(name = "likes")
    private Integer likes;
    @Column(name = "projType")
    private String projType;

    public Projectmaster() {
    }

    public Projectmaster(Integer projId) {
        this.projId = projId;
    }

    public Integer getProjId() {
        return projId;
    }

    public void setProjId(Integer projId) {
        this.projId = projId;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getProjDesc() {
        return projDesc;
    }

    public void setProjDesc(String projDesc) {
        this.projDesc = projDesc;
    }

    public Integer getProjOwner() {
        return projOwner;
    }

    public void setProjOwner(Integer projOwner) {
        this.projOwner = projOwner;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getProjType() {
        return projType;
    }

    public void setProjType(String projType) {
        this.projType = projType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projId != null ? projId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projectmaster)) {
            return false;
        }
        Projectmaster other = (Projectmaster) object;
        if ((this.projId == null && other.projId != null) || (this.projId != null && !this.projId.equals(other.projId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClass.Projectmaster[ projId=" + projId + " ]";
    }
}
