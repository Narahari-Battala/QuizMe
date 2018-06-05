package com.telusko.DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.telusko.Bean.UserBean;

public class addUserDAO {


	static final String USER = "root";
    static final String PASS = "admin";

	static Connection connection = null;
    static ResultSet rs = null;  
    static Statement stmt = null;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/ssdi";
	
	
    public static int addUser(UserBean bean) throws ClassNotFoundException, SQLException{
    Class.forName("com.mysql.jdbc.Driver");

    // STEP 3: Open a connection
    System.out.print("\nConnecting to database...");
    connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
    
    String query = "insert into userdetails values(?,?,?,?,?,?) ";
  
    PreparedStatement ps = connection.prepareStatement(query);
    ps.setString(1, bean.getUsername());
    ps.setString(2, bean.getFirstName());
    ps.setString(3, bean.getLastName());
    ps.setString(4, bean.getPassword());
    ps.setString(5, bean.getUsertype());
    ps.setString(6, bean.getEmail());
    int x= ps.executeUpdate();
    return x;
    }
    
    public static boolean userExists(String username) throws ClassNotFoundException, SQLException {
    	Class.forName("com.mysql.jdbc.Driver");

        // STEP 3: Open a connection
        System.out.print("\nConnecting to database...");
        connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        String query = "select * from userdetails where username=?";
        try {
        	PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {

        }
    }


}
