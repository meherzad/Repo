package Repo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author meherzad
 */
public class DatabaseManager {

    private String DATABASEDRIVER = "com.mysql.jdbc.Driver";
    private String DATABASEURL = "jdbc:mysql://localhost:3306/repo?user=root&password=12345";
    private Connection con;

    public DatabaseManager() {
        /*        ResourceBundle rb = ResourceBundle.getBundle("Repo.Config");
         DATABASEDRIVER = rb.getString("DatabaseVendorDriver");
         DATABASEURL = rb.getString("DatabaseURL");*/
    }

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName(DATABASEDRIVER);
        con = DriverManager.getConnection(DATABASEURL);
    }

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
    
    public boolean checkUsername(Usermaster user){
        boolean result;
        try{
            connect();
            Statement st=con.createStatement();
            ResultSet rs = st.executeQuery("select * from usermaster where username='" + 
                    user.getUsername() + "';");
            result=rs.next();
        }catch (Exception e) {
            result=false;
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
