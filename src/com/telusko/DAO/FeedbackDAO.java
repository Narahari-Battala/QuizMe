package com.telusko.DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class FeedbackDAO {

	
    static final String USER = "root";
    static final String PASS = "admin";

	static Connection connection = null;
    static ResultSet rs = null;  
    static Statement stmt = null;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/ssdi";
	
	
    public static ResultSet getResultSet(String query) throws ClassNotFoundException, SQLException{
    Class.forName("com.mysql.jdbc.Driver");

    // STEP 3: Open a connection
    System.out.print("\nConnecting to database...");
    connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
    
    //String query = "SELECT * FROM validate_login";
    System.out.println("1>>>>>>>>>>>>>>>");
    
    Statement s = (Statement) connection.createStatement();
    return rs = s.executeQuery(query);
    }
    
    public static ArrayList<String> getRecomend(String topic, String userName) throws SQLException, ClassNotFoundException
    {
    	ArrayList<String> subTopics = new ArrayList<String>();
    	Class.forName("com.mysql.jdbc.Driver");

        // STEP 3: Open a connection
        System.out.print("\nConnecting to database...");
        connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        
        String query="select count(response_id) score, q_subtopic subtopic from user_response where q_topic =? and q_answer!=user_resp and username=? group by q_subtopic order by score desc limit 3;";
        
        PreparedStatement ps =connection.prepareStatement(query);
        ps.setString(1, topic);
        ps.setString(2, userName);
        
        ResultSet rs =ps.executeQuery();
        
        while(rs.next())
        {
        	subTopics.add(rs.getString("subtopic"));
        	System.out.println(rs.getString("subtopic") + rs.getString("score"));
        }
        
        return subTopics;
    }
}
