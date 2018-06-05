package com.telusko.DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.telusko.Bean.UserBean;

public class LoginDAO {

	
    static final String USER = "root";
    static final String PASS = "admin";

	static Connection connection = null;
    static ResultSet rs = null;  
    static Statement stmt = null;
    static boolean  valid= false;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/ssdi";
	
	
    public static UserBean getResultSet(UserBean bean) throws ClassNotFoundException, SQLException{
    Class.forName("com.mysql.jdbc.Driver");

    // STEP 3: Open a connection
    System.out.print("\nConnecting to database...");
    connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
    
    String query = "SELECT * FROM userdetails where username=? and password =?";
    System.out.println("1>>>>>>>>>>>>>>>");
    UserBean userbean =null;
    PreparedStatement ps = connection.prepareStatement(query);
    ps.setString(1, bean.getUsername());
    ps.setString(2, bean.getPassword());
    rs = ps.executeQuery();
    
    while(rs.next())
    {
    	String username = rs.getString(1);
    	String firstname = rs.getString(2);
    	String lastname = rs.getString(3);
    	String password = rs.getString(4);
    	String usertype = rs.getString(5);
    	String email = rs.getString(6);
    	userbean = new UserBean(usertype, email,  username, password,firstname,
    			lastname);
    	valid = true;
    	
    	userbean.setValid(valid);
    	
    }
    
    
    return userbean;
    }
}
