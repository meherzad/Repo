/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClass;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Meherzad
 */
@Entity
@Table(name = "projecttaskmember")
@NamedQueries({
    @NamedQuery(name = "Projecttaskmember.findAll", query = "SELECT p FROM Projecttaskmember p")})
public class Projecttaskmember implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjecttaskmemberPK projecttaskmemberPK;

    public Projecttaskmember() {
    }

    public Projecttaskmember(ProjecttaskmemberPK projecttaskmemberPK) {
        this.projecttaskmemberPK = projecttaskmemberPK;
    }

    public Projecttaskmember(int taskId, int userId) {
        this.projecttaskmemberPK = new ProjecttaskmemberPK(taskId, userId);
    }

    public ProjecttaskmemberPK getProjecttaskmemberPK() {
        return projecttaskmemberPK;
    }

    public void setProjecttaskmemberPK(ProjecttaskmemberPK projecttaskmemberPK) {
        this.projecttaskmemberPK = projecttaskmemberPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projecttaskmemberPK != null ? projecttaskmemberPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projecttaskmember)) {
            return false;
        }
        Projecttaskmember other = (Projecttaskmember) object;
        if ((this.projecttaskmemberPK == null && other.projecttaskmemberPK != null) || (this.projecttaskmemberPK != null && !this.projecttaskmemberPK.equals(other.projecttaskmemberPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClass.Projecttaskmember[ projecttaskmemberPK=" + projecttaskmemberPK + " ]";
    }
}
