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
@Table(name = "ProjectPhase", catalog = "repo", schema = "")
@NamedQueries({
    @NamedQuery(name = "ProjectPhase.findAll", query = "SELECT p FROM ProjectPhase p"),
    @NamedQuery(name = "ProjectPhase.findByPhaseId", query = "SELECT p FROM ProjectPhase p WHERE p.phaseId = :phaseId"),
    @NamedQuery(name = "ProjectPhase.findByPhaseName", query = "SELECT p FROM ProjectPhase p WHERE p.phaseName = :phaseName")})
public class ProjectPhase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "phaseId", nullable = false)
    private Integer phaseId;
    @Column(name = "phaseName", length = 20)
    private String phaseName;

    public ProjectPhase() {
    }

    public ProjectPhase(Integer phaseId) {
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
        if (!(object instanceof ProjectPhase)) {
            return false;
        }
        ProjectPhase other = (ProjectPhase) object;
        if ((this.phaseId == null && other.phaseId != null) || (this.phaseId != null && !this.phaseId.equals(other.phaseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Repo.model.ProjectPhase[ phaseId=" + phaseId + " ]";
    }
    
}
