package Repo.model;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
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
//                licId
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

    /**
     * return No of Downloads for Particular Project(Parameter Project ID)
     *
     * @param projectId
     * @return object of projectmaster class
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Projectmaster getdownload(int projectId) throws ClassNotFoundException, SQLException {
        Projectmaster project = new Projectmaster();
        try {
            connect();
            PreparedStatement pst = con.prepareStatement("select * from projectmaster where projId=?;");
            pst.setInt(1, projectId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                project.setDownloads(Integer.parseInt(rs.getString("downloads")));
                project.setLikes(Integer.parseInt(rs.getString("likes")));
                project.setProjDesc(rs.getString("projDesc"));
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
        return project;
    }

    public ProjectLicense getLicense(int licenseId) {
        ProjectLicense obj = new ProjectLicense();
        try {
            connect();
            PreparedStatement stmt = con.prepareStatement("select * from licensemaster "
                    + "where licenseId = ?");
            stmt.setInt(1, licenseId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                InputStream is = rs.getBinaryStream("licenseDesc");
                java.io.BufferedReader in = new BufferedReader(new java.io.InputStreamReader(is));
                String total = "";
                String str1;
                while ((str1 = in.readLine()) != null) {
                    total += str1;
                }
                obj.setLicenseId(licenseId);
                obj.setLicenseName(rs.getString("licenseName"));
                obj.setLicenseDesc(total);
            } else {
                obj = null;
            }
        } catch (Exception e) {
            obj = null;
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

    public boolean setLicense(Projectmaster project) {
        boolean result;
        try {
            connect();
            PreparedStatement pst = con.prepareStatement("Update projectmaster set licenseId=? "
                    + "where projId=?;");
            pst.setInt(1, project.getLicenseId());
            pst.setInt(2, project.getProjId());
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

    public ProjectLicense getProjectLicense(int projId) {
        ProjectLicense proj = new ProjectLicense();
        try {
            connect();
            PreparedStatement pst = con.prepareStatement("select * from licensemaster where "
                    + "licenseId = (select licenseId from projectmaster where projId=?);");
            pst.setInt(1, projId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                InputStream is = rs.getBinaryStream("licenseDesc");
                java.io.BufferedReader in = new BufferedReader(new java.io.InputStreamReader(is));
                String total = "";
                String str1;
                while ((str1 = in.readLine()) != null) {
                    total += str1;
                }
                proj.setLicenseDesc(total);
                proj.setLicenseId(rs.getInt("licenseId"));
                proj.setLicenseName(rs.getString("licenseName"));
            } else {
                proj = null;
            }

        } catch (Exception e) {
            //result = false;
            proj = null;
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return proj;
    }

    public Projectmaster viewDocument(int projId) {
        boolean result;
        Projectmaster doc = new Projectmaster();
        try {
            connect();

            PreparedStatement pst = con.prepareStatement("select * from projectmaster where "
                    + "projId=?;");
            pst.setInt(1, projId);

            ResultSet rs = pst.executeQuery();
            rs.next();
            InputStream is = rs.getBinaryStream("projDoc");
            System.out.println(is);
            java.io.BufferedReader in = new BufferedReader(new java.io.InputStreamReader(is));
            String total = "";
            String str1;
            while ((str1 = in.readLine()) != null) {
                total += str1;
            }
            // doc.setData(total);
            doc.setProjId(projId);
            doc.setProjectDoc(total);
            doc.setProjOwner(rs.getInt("projOwner"));
            //doc.setDateCreate(rs.getDate("dateOfCreation"));
            //doc.setDateModify(rs.getDate("dateOfModification"));

            //   System.out.println("000000000000000----- > " + total);
            is.close();
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
        System.out.println(doc);

        return doc;
    }

    //get user detail for particular user
    public Usermaster getuser(int userId) throws ClassNotFoundException, SQLException, ParseException {
        //Usermaster> detail = new ArrayList<Usermaster>();
        Usermaster user = null;
        try {
            connect();
            PreparedStatement st = con.prepareStatement("select * from usermaster where userId =?");
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            rs.next();
            user = new Usermaster();
            user.setIurl(rs.getString("iUrl"));
            user.setUsername(rs.getString("username"));
            user.setjDate(rs.getDate("jDate"));
            user.setUserId(rs.getInt("userId"));
            user.setAboutUser(rs.getString("aboutuser"));
            user.setNick(rs.getString("nick"));
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
        return user;
    }

    //get list of project inwhich particular user is owner
    public ArrayList<Projectmaster> getprojectList(int userId) throws ClassNotFoundException, SQLException {
        ArrayList<Projectmaster> detail = new ArrayList<Projectmaster>();
        Projectmaster project = null;
        try {
            connect();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from projectmaster where projOwner =" + userId);
            while (rs.next()) {
                project = new Projectmaster();
                project.setProjName(rs.getString("projName"));
                project.setProjId(rs.getInt("projId"));
                detail.add(project);
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
        return detail;
    }
    //get list of project inwhich Particular user is devloper

    public ArrayList<Projectmaster> getdevloperprojectList(int userId) throws ClassNotFoundException, SQLException {
        ArrayList<Projectmaster> detail = new ArrayList<Projectmaster>();
        Projectmaster project = null;
        try {
            connect();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from projectmaster where projId in(select projectId from projectdetail where userId =" + userId + ")");
            while (rs.next()) {
                project = new Projectmaster();
                project.setProjName(rs.getString("projName"));
                project.setProjId(rs.getInt("projId"));
                detail.add(project);
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
        return detail;
    }

    //get list of project inwhich Particular user is following
    public ArrayList<Projectmaster> getfollowerprojectList(int userId) throws ClassNotFoundException, SQLException {
        ArrayList<Projectmaster> detail = new ArrayList<Projectmaster>();
        Projectmaster project = null;
        try {
            connect();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from projectmaster where projId in(select projectId from projectfollower where userId=" + userId + ")");
            while (rs.next()) {
                project = new Projectmaster();
                project.setProjName(rs.getString("projName"));
                project.setProjId(rs.getInt("projId"));

                detail.add(project);
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
        return detail;
    }
    // To get devloper's detail for particular project

    public ArrayList<Usermaster> getdevloper(int id) throws ClassNotFoundException, SQLException, ParseException {
        ArrayList<Usermaster> members = new ArrayList<Usermaster>();
        Usermaster user = null;
        try {
            connect();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT nick AS username,u.userId as userId,p.jDate AS jDate,u.iUrl AS image FROM usermaster u "
                    + " join projectdetail p on u.userId=p.userId WHERE p.projectId=" + id + "");
            while (rs.next()) {
                user = new Usermaster();
                user.setUserId(rs.getInt("userId"));
                user.setIurl(rs.getString("image"));
                user.setUsername(rs.getString("username"));
                user.setjDate(rs.getDate("jDate"));
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

    // To get follower's detail for particular project
    public ArrayList<Usermaster> getallfollower(int id) throws ClassNotFoundException, SQLException, ParseException {
        ArrayList<Usermaster> members = new ArrayList<Usermaster>();
        Usermaster user = null;
        try {
            connect();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT nick AS username,u.userId as userId,f.jDate AS jDate,u.iUrl AS image FROM usermaster u "
                    + " join projectfollower f on u.userId=f.userId WHERE f.projectId=" + id + " ORDER BY jDate DESC");
            while (rs.next()) {
                user = new Usermaster();

                user.setIurl(rs.getString("image"));
                user.setUserId(rs.getInt("userId"));
                user.setUsername(rs.getString("username"));
                user.setjDate(rs.getDate("jDate"));
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

    public ArrayList<Usermaster> getowner(int id) throws ClassNotFoundException, SQLException, ParseException {
        ArrayList<Usermaster> members = new ArrayList<Usermaster>();
        Usermaster user = null;
        try {
            connect();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from usermaster where userId in(select projOwner "
                    + "from projectmaster where projId=" + id + ");");
            while (rs.next()) {
                user = new Usermaster();
                user.setUserId(rs.getInt("userId"));
                user.setIurl(rs.getString("iurl"));
                user.setUsername(rs.getString("nick"));
                user.setjDate(rs.getDate("jDate"));
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

    public void updateimage(int userId, String name) {
        try {
            connect();
            Statement st = con.createStatement();
            name = "images/userPic/" + name;
            st.executeUpdate("Update usermaster set iUrl='" + name + "'where userId='" + userId + "'");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean addDocumentation(Projectmaster doc) {
        boolean result;
        try {
            connect();
            byte[] data = doc.getProjectDoc().getBytes();
            java.io.InputStream is = new ByteArrayInputStream(data);
            PreparedStatement pst = con.prepareStatement("update projectmaster set projDoc=?"
                    + " where projId=?;");
            pst.setInt(2, doc.getProjId());
            pst.setBinaryStream(1, is);
            pst.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public ArrayList<Projectmaster> getProject(String searchstring) throws SQLException {

        String query = "select * from projectmaster where projName like "
                + "'" + searchstring + "%' OR projDesc like '" + searchstring + "%'";

        ResultSet rs;

        ArrayList<Projectmaster> project = new ArrayList();
        try {
            connect();//connecting to the databse
            Statement st = con.createStatement();

            rs = st.executeQuery(query);//fetch the data from the table

            while (rs.next()) {//fetching the information from the resultset and setting it to the projectMaster class object.
                Projectmaster pm = new Projectmaster();
                pm.setProjId(rs.getInt("projId"));
                pm.setProjName(rs.getString("projName"));
                pm.setProjDesc(rs.getString("projDesc"));
                pm.setProjOwner(rs.getInt("projOwner"));
                pm.setDownloads(rs.getInt("downloads"));
                pm.setLikes(rs.getInt("likes"));
                pm.setProjType(rs.getString("projType"));
                System.out.println(pm);

                project.add(pm);//adding the projectmaster class object to the arraylist.
            }
            disConnect();//closing the database connection
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return project;//returning the arraylist
    }

    //--------fetching the user details from the usermaster table.-----------------
    public ArrayList<Usermaster> getUsername(String searchstring) throws SQLException {
        String query = "select * from usermaster where username like '" + searchstring + "%'";

        ResultSet rs;

        ArrayList<Usermaster> username = new ArrayList();//arraylist for storing the objects of usermaster.
        try {
            connect();//opening the connection to the database
            Statement st = con.createStatement();
            rs = st.executeQuery(query);//fetching the user details form usermaster table

            while (rs.next()) {//fetching the data from the resultset and setting to the usermaster class object.

                Usermaster um = new Usermaster();
                um.setUserId(rs.getInt("userId"));
                um.setUsername(rs.getString("username"));
                um.setPassword(rs.getString("password"));
                um.setJDate(rs.getDate("jDate"));
                System.out.println(um);
                username.add(um);
                //username.add(um);//adding the usermaster objects to the arraylist
            }
            disConnect();//closing the database connection
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return username;//returning the arraylist.
    }

    public String checkAllId(String usr) {
        String status = "";

        try {
            connect();
            PreparedStatement ps = con.prepareStatement("select * from usermaster where "
                    + "username='" + usr + "';");
            ResultSet rs = ps.executeQuery();
            int cnt = 0;
            if (rs.next()) {
                status = "true";
            } else {
                status = "false";
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        return status;
    }

    public int verifyRand(String rnd) {
        int userid = 0;
        try {
            connect();
            PreparedStatement pst = con.prepareStatement("Select userId from usermaster "
                    + "where rand like '" + rnd + "'");
            ResultSet rs = pst.executeQuery();
            rs.next();
            userid = rs.getInt("userId");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userid;
    }

    public String updateRand(String username) {
        boolean status = false;
        int userid;
        java.util.Date date = new java.util.Date();
        String stamp = date.toString();
        String random = "";
        //Hashing hash = new Hashing();
        try {
            connect();
            random = Hashing.getHashValue(stamp);
            PreparedStatement ps = con.prepareStatement("update usermaster set rand = '" + random
                    + "' where username like '" + username + "';");
            ps.executeUpdate();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return random;
    }

    public boolean changePass(String pass, String userid, String rnd) {
        boolean status = false;
        try {
            connect();
            PreparedStatement pst = con.prepareStatement("update usermaster set password='" + pass
                    + "' where userId = '" + userid + "' and rand = '" + rnd + "';");
            pst.executeUpdate();

            status = true;

        } catch (Exception e) {
            e.printStackTrace();
            status = false;
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return status;
    }

    public boolean personalstatement(int userId, String statement) {
        boolean result;
        try {
            connect();
            Statement st = con.createStatement();
            st.executeUpdate("Update usermaster set aboutUser='" + statement
                    + "'where userId='" + userId + "'");
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean changepassword(String newpass, String oldPass, int userId) throws ClassNotFoundException, SQLException {
        boolean result;

        try {
            connect();
            Statement st = con.createStatement();
            oldPass = Hashing.getHashValue(oldPass);
            newpass = Hashing.getHashValue(newpass);
            PreparedStatement pst = con.prepareStatement("select * from usermaster "
                    + "where userId=? and password=?;");
            pst.setInt(1, userId);
            pst.setString(2, oldPass);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                st.executeUpdate("Update usermaster set password='" + newpass
                        + "'where userId='" + userId + "'");
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

    public boolean updatedesc(int projectId, String desc) {
        boolean result;
        try {
            connect();
            Statement st = con.createStatement();
            st.executeUpdate("Update projectmaster set projDesc='" + desc + "'where projId='"
                    + projectId + "';");
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public Projectmaster getprojectdetail(int projectId) throws ClassNotFoundException, SQLException, ParseException {
        //Usermaster> detail = new ArrayList<Usermaster>();
        Projectmaster project = null;
        try {
            connect();
            PreparedStatement st = con.prepareStatement("select * from projectmaster where projId =?");
            st.setInt(1, projectId);
            ResultSet rs = st.executeQuery();
            rs.next();
            project = new Projectmaster();
            project.setProjId(rs.getInt("projId"));
            project.setProjName(rs.getString("projName"));
            project.setDownloads(rs.getInt("downloads"));
            project.setLikes(rs.getInt("likes"));
            project.setProjDesc(rs.getString("projDesc"));
            project.setProjOwner(rs.getInt("projOwner"));
            project.setProjType(rs.getString("projType"));
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
        return project;
    }

    public boolean updateprojtype(int projectId, String type) {
        boolean result;
        try {
            connect();
            Statement st = con.createStatement();
            st.executeUpdate("Update projectmaster set projType='" + type + "'where projId='"
                    + projectId + "'");
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateprojectimage(int projectId, String image) {
        boolean result;
        image = "images/" + image;
        try {
            connect();
            Statement st = con.createStatement();
            st.executeUpdate("Update projectmaster set iUrl='" + image + "'where projId='"
                    + projectId + "';");
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void updatedreview(Downloadreview review) {
        try {
            connect();
            PreparedStatement pst = con.prepareStatement("insert into projectreview "
                    + "(projId, userId, review, rate,time)values(?, ?, ?, ?, ?);");
            pst.setInt(1, review.getProjId());
            pst.setInt(2, review.getUserId());
            pst.setString(3, review.getReview());
            pst.setInt(4, review.getRate());
            pst.setDate(5, new java.sql.Date(review.getTime().getTime()));
            pst.executeUpdate();
            //System.out.println("---" + user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Downloadreview> getdownloadreviews(int projectId) throws ClassNotFoundException, SQLException {
        ArrayList<Downloadreview> detail = new ArrayList<Downloadreview>();
        Downloadreview review = null;
        try {
            connect();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT *,u.username AS username FROM "
                    + "projectreview p, usermaster u, projectmaster pm where "
                    + " u.userId=p.userId and pm.projId=p.projId=" + projectId);
            while (rs.next()) {
                review = new Downloadreview();
                review.setUsername(rs.getString("username"));
                review.setReviewId(rs.getInt("reviewId"));
                review.setProjId(rs.getInt("projId"));
                review.setUserId(rs.getInt("userId"));
                review.setRate(rs.getInt("rate"));
                review.setTime(rs.getDate("time"));
                review.setReview(rs.getString("review"));
                detail.add(review);

            }
            System.out.println(detail);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return detail;
    }

    public ArrayList<Downloadreview> download_project(int projectId) throws ClassNotFoundException, SQLException {
        ArrayList<Downloadreview> detail = new ArrayList<Downloadreview>();
        Downloadreview review = null;
        try {
            connect();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT *,u.username AS username,AVG(rate) AS Rating ,"
                    + "COUNT(reviewId) AS Reviewed,downloads,projName FROM projectreview p, "
                    + "usermaster u, projectmaster pm where u.userId=p.userId "
                    + "and pm.projId=p.projId=" + projectId);
            while (rs.next()) {
                review = new Downloadreview();
                review.setDownloads(rs.getInt("downloads"));
                review.setProjName(rs.getString("projName"));
                review.setRating(rs.getFloat("Rating"));
                review.setReviewd(rs.getInt("Reviewed"));

                detail.add(review);

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
        return detail;
    }

    public ArrayList<Usermaster> search(Usermaster umc, String name) throws SQLException,
            ClassNotFoundException {
        connect();
        ArrayList<Usermaster> nameList = new ArrayList();
        Statement stm = con.createStatement();
        //String name=umc.getName();
        name += '%';
        PreparedStatement stmt = con.prepareStatement("select * from usermaster where username "
                + "like ?;");
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            umc = new Usermaster();
            umc.setUsername(rs.getString("username"));
            umc.setUserId(rs.getInt("userId"));
            umc.setjDate(rs.getDate("jdate"));
            umc.setPassword(rs.getString("password"));
//umc.setDate(null);
            //stmt.setString(1,name);
            nameList.add(umc);
            System.out.println(umc);
        }
        disConnect();

        return nameList;
    }

    public boolean requestinvi(Projectinvitation obj) {

        boolean value;
        try {
            connect();
            Statement st = con.createStatement();

            //ProjectInvitation pi = new ProjectInvitation();
            PreparedStatement pstobj = con.prepareStatement("insert into projectinvitation "
                    + "(fromUser,toUser,projId,timeStamp,flag,status) values(?,?,?,?,?,?);");
            pstobj.setInt(1, obj.getFromUser());
            pstobj.setInt(2, obj.getToUser());
            pstobj.setInt(3, obj.getProjId());
            pstobj.setDate(4, new java.sql.Date(obj.getTimeStamp().getTime()));
            pstobj.setString(5, obj.getFlag());
            pstobj.setString(6, obj.getStatus());

            pstobj.executeUpdate();
            value = true;
        } catch (Exception e) {
            e.printStackTrace();
            value = false;
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    public ArrayList<Projectmaster> displayinvi(int id) {
        ArrayList<Projectmaster> nameList = new ArrayList<Projectmaster>();
        try {
            connect();
            Statement st = con.createStatement();
            Projectmaster pm = new Projectmaster();
            Projectinvitation pi = new Projectinvitation();
            PreparedStatement pstobj = con.prepareStatement("select * from projectmaster where "
                    + "projId IN(select projId from projectinvitation "
                    + "where toUser=? and status=?);");

            pstobj.setInt(1, id);
            pstobj.setString(2, "Pending");
            ResultSet rs = pstobj.executeQuery();
            while (rs.next()) {
                //pd = new UserMasterClass();
                pm.setProjId(rs.getInt("projId"));
                pm.setProjName(rs.getString("projName"));
                pm.setProjDesc(rs.getString("projDesc"));
                pm.setProjOwner(rs.getInt("projOwner"));
                pm.setDownloads(rs.getInt("downloads"));
                pm.setLikes(rs.getInt("likes"));
                pm.setProjType(rs.getString("projtype"));
                pm.setLicenseId(rs.getInt("licenseId"));
                nameList.add(pm);
            }

            // value = true;
        } catch (Exception e) {
            e.printStackTrace();
            //value = false;
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return nameList;
    }

    public boolean update(Projectdetail obj, String type, int projId, int UserId) {
        boolean value;
        try {
            connect();
            Statement st = con.createStatement();
            if (type.equals("accept")) {
                PreparedStatement pstobj = con.prepareStatement("Insert into projectdetail("
                        + "projectId,userId,jDate) values (?,?,?);");
                pstobj.setInt(1, obj.getProjectId());
                pstobj.setInt(2, obj.getUserId());
                pstobj.setDate(3, new java.sql.Date(obj.getjDate().getTime()));
                pstobj.executeUpdate();
            }
            PreparedStatement pstmtobj = con.prepareStatement("Update projectinvitation set "
                    + "status=? where projId=? and toUser=?;");
            pstmtobj.setString(1, type);
            pstmtobj.setInt(2, projId);
            pstmtobj.setInt(3, UserId);
            pstmtobj.executeUpdate();
            value = true;
        } catch (Exception e) {
            e.printStackTrace();
            value = false;
        } finally {
            try {
                disConnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value;
    }
    
    
}
