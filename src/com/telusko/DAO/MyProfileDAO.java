package com.telusko.DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class MyProfileDAO {

	static final String USER = "root";
	static final String PASS = "admin";

	static Connection connection = null;
	static ResultSet rs = null;
	static Statement stmt = null;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/ssdi";


	public ResultSet selectMyProfileData(String user2) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");

		System.out.print("\nConnecting to database...");
		connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

	    String query = "select ud.username, ud.firstname, ud.lastname, ud.email, avg(l.score), max(ex.exam_date) from userdetails ud, leaderboard l,  exams ex, examsregistered er where ud.username = l.username and  ud.username = er.username and ud.username = ?";
	    
	    PreparedStatement ps = connection.prepareStatement(query);
	    ps.setString(1, user2);
	    return rs = ps.executeQuery();
	}


	

}
