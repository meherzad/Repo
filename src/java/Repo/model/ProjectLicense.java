/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.model;

/**
 *
 * @author meherzad
 */
public class ProjectLicense {
    private int licenseId;
    private String licenseName;
    private String licenseDesc;

    public int getLicenseId() {
        return licenseId;
    }

    public String getLicenseName() {
        return licenseName;
    }

    public String getLicenseDesc() {
        return licenseDesc;
    }

    public void setLicenseId(int licenseId) {
        this.licenseId = licenseId;
    }

    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName;
    }

    public void setLicenseDesc(String licenseDesc) {
        this.licenseDesc = licenseDesc;
    }
    
}
