/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.model;
/*
 *
 * @author Meherzad
 */

public class Projecttaskmember {

   
    private int taskId;
    private int userId;

    public Projecttaskmember() {
    }

    public Projecttaskmember(int taskId, int userId) {
        this.taskId = taskId;
        this.userId = userId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) taskId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projecttaskmember)) {
            return false;
        }
        Projecttaskmember other = (Projecttaskmember) object;
        if (this.taskId != other.taskId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClass.Projecttaskmember[ taskId=" + taskId + ", userId=" + userId + " ]";
    }
}
