/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.model;

import java.util.ArrayList;

/**
 *
 * @author Meherzad
 */
public class Projectmaster {

    private Integer projId;
    private String projName;
    private String projDesc;
    private Integer projOwner;
    private Integer downloads;
    private Integer likes;
    private String projType;
    private String iUrl;
    private ArrayList<Usermaster> members;
    private Integer licenseId;
    private String projectDoc;
    private String codeUrl;

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setProjectDoc(String projectDesc) {
        this.projectDoc = projectDesc;
    }

    public String getProjectDoc() {
        return projectDoc;
    }

    public void setLicenseId(Integer licenseId) {
        this.licenseId = licenseId;
    }

    public Integer getLicenseId() {
        return licenseId;
    }

    public String getiUrl() {
        return iUrl;
    }

    public void setiUrl(String iUrl) {
        this.iUrl = iUrl;
    }

    public void addMember(Usermaster user) {
        members.add(user);
    }

    public void setMembers(ArrayList<Usermaster> members) {
        this.members = members;
    }

    public ArrayList<Usermaster> getMembers() {
        return members;
    }

    public Projectmaster() {
        members = new ArrayList<Usermaster>();
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
