package Repo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import model.sendMail;

/**
 *
 * @author meherzad
 */
public class DatabaseManager {
    
    private String DATABASEDRIVER;// = "com.mysql.jdbc.Driver";
    private String DATABASEURL;// = "jdbc:mysql://localhost:3306/repo?user=root&password=12345";
    private Connection con;
    
    public DatabaseManager() {
        ResourceBundle rb = ResourceBundle.getBundle("Repo.Config");
        DATABASEDRIVER = rb.getString("DatabaseVendorDriver");
        DATABASEURL = rb.getString("DatabaseURL");
    }

    /**
     * Connect with the database
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName(DATABASEDRIVER);
        con = DriverManager.getConnection(DATABASEURL);
    }

    /**
     * Disconnect with database
     *
     * @throws SQLException
     */
    public void disConnect() throws SQLException {
        con.close();
    }
    
    public boolean putData(String query) {
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public Statement getStatement() throws SQLException {
        return con.createStatement();
    }
    
    public ResultSet getData(Statement st, String query) throws SQLException {
        //Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        return rs;
    }

    /**
     * Method to insert new user used during sign up
     *
     * @param user
     * @return
     */
    public boolean insertUser(Usermaster user) {
        boolean result;
        String verfId, email;
        //DatabaseManager obj = new DatabaseManager();
        try {
            connect();
            email = user.getUsername();
            System.out.println("------------------------>connected");
            PreparedStatement pst = con.prepareStatement("insert into usermaster (username, password, "
                    + "jDate, verified, verificationId, nick )values(?, ?, ?, ?, ?, ?);");
            pst.setString(1, user.getUsername());
            
            pst.setString(2, Hashing.getHashValue(user.getPassword()));
            //pst.setString(3, user.getAlternateEmail());
            pst.setDate(3, new java.sql.Date(user.getJDate().getTime()));
            pst.setString(4, "no");
            verfId = Hashing.getHashValue(user.getUsername());
            pst.setString(5, verfId);
            pst.setString(6, user.getNick());
            //System.out.println("======" + user);
            pst.executeUpdate();
            String body = " Thank you for registering with XYZ. To complete the XYZ registration "
                    + "process and activate your account we ask that you complete your registration "
                    + "by confirming your account information at "
                    + "<br>http://localhost:8084/Repo/UserVerification?verfId=" + verfId
                    + "                </p>\n"
                    + "                <br>\n"
                    + "                <p>\n"
                    + "                    If you experience issues, you may generate a new confirmation email or contact us for assistance.";
            //System.out.println("---" + user);
            if (sendMail.SendEmail(email, "Verification Email", body)) {
                sendMail.SendEmail(email, "Verification Email", body);
            };
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            try {
                disConnect();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
        
    }

    /**
     * method used for email verification of new user email
     *
     * @param verfID
     * @return boolean
     */
    public boolean userVerification(String verfID) {
        boolean result;
        ResultSet rs = null;
        
        try {
            connect();
            PreparedStatement ps = con.prepareStatement("Select * from usermaster where "
                    + "verificationId like ?;");
            ps.setString(1, verfID);
            rs = ps.executeQuery();
            System.out.println("------>*** " + verfID);
            if (rs.next()) {
                System.out.println("found ");
                PreparedStatement pst = con.prepareStatement("update usermaster set "
                        + "verified='yes' where verificationId = ?;");
                pst.setString(1, verfID);
                pst.executeUpdate();
                result = true;
            } else {
                System.out.println("not found ");
                result = false;
            }
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * method used to get most download most followed and newest project
     *
     * @param type (1- Most downloaded, 2- Newest, 3- Most followed)
     * @return ArrayList<Projectmaster>
     */
    public ArrayList<Projectmaster> getMostDownload(int type) {
        ArrayList<Projectmaster> list = new ArrayList<Projectmaster>();
        Projectmaster obj;
        String query = null;
        try {
            connect();
            Statement st = con.createStatement();
            if (type == 1) {
                query = "select * from projectmaster order by downloads desc;";
            } else if (type == 2) {
                query = "select * from projectmaster order by projId desc;";
            } else {
                query = "select * from projectmaster order by likes desc;";
            }
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new Projectmaster();
                obj.setProjId(rs.getInt("projId"));
                obj.setLikes(rs.getInt("likes"));
                obj.setProjOwner(rs.getInt("projOwner"));
                obj.setProjType(rs.getString("projType"));
                obj.setProjName(rs.getString("projName"));
                obj.setProjDesc(rs.getString("projDesc"));
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * method to check whether a particular username is available or not
     *
     * @param user
     * @return
     */
    public boolean checkUsername(Usermaster user) {
        boolean result;
        try {
            connect();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from usermaster where username='"
                    + user.getUsername() + "';");
            result = rs.next();
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public int addTask(Projecttask task) {
        int taskId;
        PreparedStatement pst;
        ArrayList<Projecttaskdetail> subTask;
        ArrayList<Projecttaskmember> member;
        try {
            connect();
            pst = con.prepareStatement("insert into projecttask (projectId, "
                    + "phaseId, deadLine, taskDescription) values(?, ?, ?, ?);");
            pst.setInt(1, task.getProjectId());
            pst.setInt(2, task.getPhaseId());
            pst.setDate(3, new java.sql.Date(task.getDeadLine().getTime()));
            pst.setString(4, task.getTaskDescription());
            pst.executeUpdate();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select LAST_INSERT_ID();");
            rs.next();
            taskId = rs.getInt("LAST_INSERT_ID()");
            rs.close();
            task.setTaskId(taskId);
            subTask = task.getSubTask();
            member = task.getTaskMember();
            for (Projecttaskdetail ptd : subTask) {
                pst = con.prepareStatement("insert into projecttaskdetail (taskId, "
                        + "subTask, status, timeStamp) values(?, ?, ?, ?)");
                pst.setInt(1, taskId);
                pst.setString(2, ptd.getSubTask());
                pst.setString(3, ptd.getStatus());
                pst.setDate(4, new java.sql.Date(ptd.getTimeStamp().getTime()));
                pst.executeUpdate();
            }
            for (Projecttaskmember ptm : member) {
                pst = con.prepareStatement("Insert into projecttaskmember (taskId, "
                        + "userId) values(?, ?);");
                pst.setInt(1, taskId);
                System.out.println("{{{{{{{{{{{{{   " + ptm);
                pst.setInt(2, ptm.getUserId());
                pst.executeUpdate();
            }
        } catch (Exception e) {
            taskId = -1;
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return taskId;
    }
    
    public ArrayList<Projecttask> getTask(int projId, int phasId) {
        ArrayList<Projecttask> taskList = new ArrayList<Projecttask>();
        Projecttask task;
        try {
            connect();
            PreparedStatement pst = con.prepareStatement("Select * from projecttask where projectId=?"
                    + " and phaseId=?;");
            pst.setInt(1, projId);
            pst.setInt(2, phasId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                task = new Projecttask();
                task.setTaskId(rs.getInt("taskId"));
                task.setProjectId(projId);
                task.setTaskDescription(rs.getString("taskDescription"));
                task.setDeadLine(rs.getDate("deadLine"));
                task.setPhaseId(rs.getInt("phaseId"));
                taskList.add(task);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return taskList;
    }
    
    public ArrayList<Usermaster> getProjectMembers(int projId) {
        ArrayList<Usermaster> members = new ArrayList<Usermaster>();
        Usermaster user = null;
        try {
            connect();
            PreparedStatement pst = con.prepareCall("select * from projectdetail where projectId=?;");
            pst.setInt(1, projId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                user = new Usermaster();
                user.setUserId(rs.getInt("userId"));
                user.setNick(rs.getString("memberName"));
                members.add(user);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return members;
    }
    
    public ArrayList<Projecttaskdetail> getSubTask(int taskId) {
        ArrayList<Projecttaskdetail> subTask = new ArrayList<Projecttaskdetail>();
        Projecttaskdetail st = null;
        try {
            connect();
            PreparedStatement pst = con.prepareCall("select * from projecttaskdetail where taskId=?");
            pst.setInt(1, taskId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                st = new Projecttaskdetail();
                st.setSubTask(rs.getString("subTask"));
                st.setStatus(rs.getString("status"));
                st.setTimeStamp(rs.getDate("timeStamp"));
                st.setUId(rs.getInt("uId"));
                subTask.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return subTask;
    }
    
    public ArrayList<Usermaster> getUserByTask(int taskId) {
        
        ArrayList<Usermaster> members = new ArrayList<Usermaster>();
        Usermaster user = null;
        try {
            connect();
            PreparedStatement pst = con.prepareCall("select a.taskId, a.userId, b.nick from "
                    + "projecttaskmember a, usermaster b  where a.userId=b.userId and taskId=?;");
            pst.setInt(1, taskId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                user = new Usermaster();
                user.setUserId(rs.getInt("userId"));
                user.setNick(rs.getString("nick"));
                members.add(user);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return members;
    }
    
    public boolean updateStatusSubTask(Projecttaskdetail subTask) {
        boolean result;
        int uId = subTask.getUId();
        String cType = subTask.getStatus();
        System.out.println(cType);
        if (cType.equals("checked")) {
            cType = "Complete";
        } else {
            cType = "Incomplete";
        }
        System.out.println(cType);
        try {
            connect();
            PreparedStatement pst = con.prepareStatement("Update projecttaskdetail set status=? where "
                    + "uId=?;");
            pst.setString(1, cType);
            pst.setInt(2, uId);
            pst.executeUpdate();
            result = true;
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public boolean deleteTask(Projecttask task) {
        boolean result;
        PreparedStatement pst = null;
        try {
            connect();
            pst = con.prepareStatement("delete from projecttask where taskId=?;");
            pst.setInt(1, task.getTaskId());
            pst.executeUpdate();
            pst = con.prepareStatement("delete from projecttaskdetail where taskId=?;");
            pst.setInt(1, task.getTaskId());
            pst.executeUpdate();
            pst = con.prepareStatement("delete from projecttaskmember where taskId=?;");
            pst.setInt(1, task.getTaskId());
            pst.executeUpdate();
            result = true;
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public Usermaster LoginVerify(Usermaster user) throws SQLException {
        boolean result = false;
        Usermaster verifiedUser = null;
        try {
            connect();
        } catch (ClassNotFoundException ex) {
            // Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        Statement st = con.createStatement();
        PreparedStatement pst = con.prepareStatement("select * from usermaster where username=? and "
                + "password=? and verified = 'yes';");
        pst.setString(1, user.getUsername());
        pst.setString(2, user.getPassword());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            verifiedUser = new Usermaster();
            verifiedUser.setUserId(rs.getInt("userId"));
            verifiedUser.setUsername(rs.getString("username"));
            verifiedUser.setPassword(rs.getString("password"));
            verifiedUser.setjDate(rs.getDate("jDate"));
            //verifiedUser.setAlternateEmail(rs.getString("alternateEmail"));

            
        }
        System.out.println(verifiedUser);
        return verifiedUser;
    }
    
    public ArrayList<Projectmaster> select_all_proj() throws SQLException {
        Projectmaster objproj = null;
        ArrayList<Projectmaster> allprojlist = new ArrayList();
        try {
            connect();
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("Select * from projectmaster where projType='public';");
            while (rs.next()) {
                objproj = new Projectmaster();
                objproj.setProjId(rs.getInt("projId"));
                objproj.setProjName(rs.getString("projName"));
                objproj.setProjDesc(rs.getString("projdesc"));
                objproj.setProjOwner(rs.getInt("projOwner"));
                objproj.setDownloads(rs.getInt("downloads"));
                objproj.setLikes(rs.getInt("likes"));
                objproj.setProjType(rs.getString("projType"));
                allprojlist.add(objproj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
            }
        }
        return allprojlist;
    }
    
    public boolean joinproj(Projectfollower obj) {
        
        
        boolean result;
        try {
            connect();
            ResultSet rs = null;
            PreparedStatement pst = con.prepareCall("Insert into follower(projectId,userId,jDate) values(?,?,?);");
            pst.setInt(1, obj.getProjectId());
            pst.setInt(2, obj.getUserId());
            pst.setDate(3, new java.sql.Date(obj.getjDate().getTime()));
            
            pst.executeUpdate();
            
            Statement st = con.createStatement();
            rs = st.executeQuery("Select userId from  projectfollower where projected = "
                    + obj.getProjectId());
            while (rs.next()) {
                pst = con.prepareCall("insert into usernotification(userId, notification, "
                        + "timeStamp, notType, rID) values (?,?,?,?,?);");
                pst.setInt(1, rs.getInt("userId"));
                pst.setString(2, "New Member");
                pst.setDate(3, new java.sql.Date(obj.getjDate().getTime()));
                pst.setString(4, "New User");
                pst.setInt(5, obj.getProjectId());
                
                pst.executeUpdate();
            }
            result = true;
            
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public Usermaster getUser(int uId) {
        Usermaster user = new Usermaster();
        
        try {
            connect();
            PreparedStatement pst = con.prepareStatement("select * from usermaster where userId=?;");
            pst.setInt(1, uId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                user.setUserId(uId);
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setJDate(rs.getDate("jDate"));
                user.setVerified(rs.getString("verified"));
                user.setIurl(rs.getString("iUrl"));
                user.setNick(rs.getString("nick"));
                user.setAboutUser(rs.getString("aboutUser"));
            } else {
                user = null;
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }
    
    public ArrayList<Notification> select_notifications(int uid) throws SQLException {
        ArrayList<Notification> not_list = new ArrayList();
        // notifications objnot = null;
        try {
            connect();
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("Select * from usernotification where userId=" + uid + ";");
            
            while (rs.next()) {
                Notification objnot = new Notification();
                objnot.setNotId(rs.getInt("notId"));
                objnot.setUserId(rs.getInt("userId"));
                objnot.setNotification(rs.getString("notification"));
                objnot.setTimeStamp(rs.getDate("timeStamp"));
                objnot.setNotType(rs.getString("notType"));
                objnot.setrID(rs.getInt("rID"));
                
                not_list.add(objnot);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return not_list;
        
    }
    
    public ArrayList<Projectmaster> select_proj(int uid) throws SQLException {
        ArrayList<Projectmaster> projlist = new ArrayList();
        ResultSet rs = null;
        Projectmaster objproj = null;
        try {
            connect();
            Statement st = con.createStatement();
            rs = st.executeQuery("Select * from projectmaster where projectmaster.projId "
                    + "IN (Select projectdetail.projectId from projectdetail where "
                    + "projectdetail.userId=" + uid + ")");
            while (rs.next()) {
                objproj = new Projectmaster();
                objproj.setProjId(rs.getInt("projId"));
                objproj.setProjName(rs.getString("projName"));
                objproj.setProjDesc(rs.getString("projdesc"));
                objproj.setProjOwner(rs.getInt("projOwner"));
                objproj.setDownloads(rs.getInt("downloads"));
                objproj.setLikes(rs.getInt("likes"));
                objproj.setProjType(rs.getString("projType"));
                projlist.add(objproj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return projlist;
    }
    
    public Projectmaster getProject(int projId) {
        Projectmaster objproj = new Projectmaster();
        try {
            connect();
            PreparedStatement pst = con.prepareStatement("select * from projectmaster where "
                    + "projId=?;");
            pst.setInt(1, projId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                objproj = new Projectmaster();
                objproj.setProjId(rs.getInt("projId"));
                objproj.setProjName(rs.getString("projName"));
                objproj.setProjDesc(rs.getString("projdesc"));
                objproj.setProjOwner(rs.getInt("projOwner"));
                objproj.setDownloads(rs.getInt("downloads"));
                objproj.setiUrl(rs.getString("iUrl"));
                objproj.setLikes(rs.getInt("likes"));
                objproj.setProjType(rs.getString("projType"));
            } else {
                objproj = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return objproj;
    }

    /**
     * to check whether user is part of that project
     *
     * @return
     */
    public boolean checkUserInProject(int projId, int userId) {
        boolean result;
        try {
            connect();
            PreparedStatement pst = con.prepareStatement("select userId from projectdetail where "
                    + "projectId=? and userId=? UNION select projOwner from projectmaster "
                    + "where projId=? and projOwner=?;");
            pst.setInt(1, projId);
            pst.setInt(2, userId);
            pst.setInt(3, projId);
            pst.setInt(4, userId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = true;
            } else {
                result = false;
            }
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
