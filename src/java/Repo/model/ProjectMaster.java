/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.model;

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
 * @author meherzad
 */
@Entity
@Table(name = "ProjectMaster", catalog = "repo", schema = "")
@NamedQueries({
    @NamedQuery(name = "ProjectMaster.findAll", query = "SELECT p FROM ProjectMaster p"),
    @NamedQuery(name = "ProjectMaster.findByProjId", query = "SELECT p FROM ProjectMaster p WHERE p.projId = :projId"),
    @NamedQuery(name = "ProjectMaster.findByProjName", query = "SELECT p FROM ProjectMaster p WHERE p.projName = :projName"),
    @NamedQuery(name = "ProjectMaster.findByProjDesc", query = "SELECT p FROM ProjectMaster p WHERE p.projDesc = :projDesc"),
    @NamedQuery(name = "ProjectMaster.findByProjOwner", query = "SELECT p FROM ProjectMaster p WHERE p.projOwner = :projOwner"),
    @NamedQuery(name = "ProjectMaster.findByDownloads", query = "SELECT p FROM ProjectMaster p WHERE p.downloads = :downloads"),
    @NamedQuery(name = "ProjectMaster.findByLikes", query = "SELECT p FROM ProjectMaster p WHERE p.likes = :likes"),
    @NamedQuery(name = "ProjectMaster.findByProjType", query = "SELECT p FROM ProjectMaster p WHERE p.projType = :projType")})
public class ProjectMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "projId", nullable = false)
    private Integer projId;
    @Column(name = "projName", length = 20)
    private String projName;
    @Column(name = "projDesc", length = 20)
    private String projDesc;
    @Column(name = "projOwner")
    private Integer projOwner;
    @Column(name = "downloads")
    private Integer downloads;
    @Column(name = "likes")
    private Integer likes;
    @Column(name = "projType", length = 10)
    private String projType;

    public ProjectMaster() {
    }

    public ProjectMaster(Integer projId) {
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
        if (!(object instanceof ProjectMaster)) {
            return false;
        }
        ProjectMaster other = (ProjectMaster) object;
        if ((this.projId == null && other.projId != null) || (this.projId != null && !this.projId.equals(other.projId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Repo.model.ProjectMaster[ projId=" + projId + " ]";
    }
    
}
