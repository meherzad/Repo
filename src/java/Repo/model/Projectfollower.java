/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClass;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "projectfollower")
@NamedQueries({
    @NamedQuery(name = "Projectfollower.findAll", query = "SELECT p FROM Projectfollower p")})
public class Projectfollower implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjectfollowerPK projectfollowerPK;
    @Column(name = "jDate")
    @Temporal(TemporalType.DATE)
    private Date jDate;

    public Projectfollower() {
    }

    public Projectfollower(ProjectfollowerPK projectfollowerPK) {
        this.projectfollowerPK = projectfollowerPK;
    }

    public Projectfollower(int projectId, int userId) {
        this.projectfollowerPK = new ProjectfollowerPK(projectId, userId);
    }

    public ProjectfollowerPK getProjectfollowerPK() {
        return projectfollowerPK;
    }

    public void setProjectfollowerPK(ProjectfollowerPK projectfollowerPK) {
        this.projectfollowerPK = projectfollowerPK;
    }

    public Date getJDate() {
        return jDate;
    }

    public void setJDate(Date jDate) {
        this.jDate = jDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectfollowerPK != null ? projectfollowerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projectfollower)) {
            return false;
        }
        Projectfollower other = (Projectfollower) object;
        if ((this.projectfollowerPK == null && other.projectfollowerPK != null) || (this.projectfollowerPK != null && !this.projectfollowerPK.equals(other.projectfollowerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClass.Projectfollower[ projectfollowerPK=" + projectfollowerPK + " ]";
    }
}
