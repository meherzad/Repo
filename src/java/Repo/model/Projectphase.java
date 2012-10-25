/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.model;

/**
 *
 * @author Meherzad
 */
public class Projectphase {

    private Integer phaseId;
    private String phaseName;

    public Projectphase() {
    }

    public Projectphase(Integer phaseId) {
        this.phaseId = phaseId;
    }

    public Integer getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(Integer phaseId) {
        this.phaseId = phaseId;
    }

    public String getPhaseName() {
        return phaseName;
    }

    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phaseId != null ? phaseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projectphase)) {
            return false;
        }
        Projectphase other = (Projectphase) object;
        if ((this.phaseId == null && other.phaseId != null) || (this.phaseId != null && !this.phaseId.equals(other.phaseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClass.Projectphase[ phaseId=" + phaseId + " ]";
    }
}
