package com.telusko.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.telusko.Bean.QuestionBean;

public class LeaderBoardDAO {
	
	static final String USER = "root";
    static final String PASS = "admin";

	static Connection connection = null;
    static ResultSet rs = null;  
    static Statement stmt = null;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/ssdi";
	
    
    public void storeLeaderBoardResponse(String uname, String topic, int score) throws SQLException, ClassNotFoundException {
	
    	Class.forName("com.mysql.jdbc.Driver");
   

  // STEP 3: Open a connection
        connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        
    
    String query = "Insert into leaderboard(username,topic,score) values (?,?,?)";
 
	
	PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
	preparedStatement.setString(1, uname);
	preparedStatement.setInt(3,score );
	preparedStatement.setString(2,topic);
	preparedStatement.executeUpdate();

	}
    
    public ResultSet viewLeaderboard() throws SQLException, ClassNotFoundException {
    	
    	Class.forName("com.mysql.jdbc.Driver");
  
  // STEP 3: Open a connection
        connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        
    String query = "select username, avg(score) from leaderboard group by username order by avg(score) desc;";
    Statement s = (Statement) connection.createStatement();
    return rs = s.executeQuery(query);
	}
}

