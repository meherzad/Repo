package Repo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
        //DatabaseManager obj = new DatabaseManager();
        try {
            connect();
            System.out.println("------------------------>connected");
            PreparedStatement pst = con.prepareStatement("insert into usermaster (username, password, alternateEmail, jDate, "
                    + "verified, verificationId )values(?, ?, ?, ?, ?, ?);");
            pst.setString(1, user.getUsername());
            pst.setString(2, Hashing.getHashValue(user.getPassword()));
            pst.setString(3, user.getAlternateEmail());
            pst.setDate(4, new java.sql.Date(user.getJDate().getTime()));
            pst.setString(5, "no");
            pst.setString(6, Hashing.getHashValue(user.getUsername()));
            //System.out.println("======" + user);
            pst.executeUpdate();
            //System.out.println("---" + user);
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
            Statement st = con.createStatement();
            rs = st.executeQuery("Select * from usermaster where verificationId='" + verfID + "';");
            if (rs.next()) {
                PreparedStatement pst = con.prepareStatement("update usermaster set verified='yes' where verificationId = ?;");
                pst.setString(1, verfID);
                pst.executeUpdate();
                result = true;
            } else {
                result = false;
            }
        } catch (Exception e) {
            result = false;
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
            PreparedStatement pst = con.prepareCall("select * from projectmember where projId=?;");
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
        Projecttaskdetail st=null;
        try {
            connect();
            PreparedStatement pst=con.prepareCall("select * from projecttaskdetail where taskId=?");
            pst.setInt(1, taskId);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                st=new Projecttaskdetail();
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
}
