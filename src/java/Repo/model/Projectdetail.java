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
@Table(name = "projectdetail")
@NamedQueries({
    @NamedQuery(name = "Projectdetail.findAll", query = "SELECT p FROM Projectdetail p")})
public class Projectdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjectdetailPK projectdetailPK;
    @Column(name = "jDate")
    @Temporal(TemporalType.DATE)
    private Date jDate;

    public Projectdetail() {
    }

    public Projectdetail(ProjectdetailPK projectdetailPK) {
        this.projectdetailPK = projectdetailPK;
    }

    public Projectdetail(int projectId, int userId) {
        this.projectdetailPK = new ProjectdetailPK(projectId, userId);
    }

    public ProjectdetailPK getProjectdetailPK() {
        return projectdetailPK;
    }

    public void setProjectdetailPK(ProjectdetailPK projectdetailPK) {
        this.projectdetailPK = projectdetailPK;
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
        hash += (projectdetailPK != null ? projectdetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projectdetail)) {
            return false;
        }
        Projectdetail other = (Projectdetail) object;
        if ((this.projectdetailPK == null && other.projectdetailPK != null) || (this.projectdetailPK != null && !this.projectdetailPK.equals(other.projectdetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClass.Projectdetail[ projectdetailPK=" + projectdetailPK + " ]";
    }
}
