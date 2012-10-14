/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 *
 * @author meherzad
 */
public class DatabaseManager {

    private String DATABASEDRIVER;
    private String DATABASEURL;
    private Connection con;

    public DatabaseManager() {
        ResourceBundle rb = ResourceBundle.getBundle("org.crudapp.Config");
        DATABASEDRIVER = rb.getString("DatabaseVendorDriver");
        DATABASEURL = rb.getString("DatabaseURL");
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

    public ResultSet getData(String query) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        return rs;
    }
}
