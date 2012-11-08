/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo.model;

import java.sql.Timestamp;

/**
 *
 * @author meherzad
 */
public class chat {
    private int projId;
    private int userId;
    private String chat;
    private Timestamp time;
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public int getProjId() {
        return projId;
    }

    public int getUserId() {
        return userId;
    }

    public String getChat() {
        return chat;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "chat{" + "projId=" + projId + ", userId=" + userId + ", chat=" + chat + ", time=" + time + '}';
    }
    
}
