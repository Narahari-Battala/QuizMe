package com.telusko.DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import com.mysql.jdbc.Statement;

public class QuestionDAO {

	static final String USER = "root";
    static final String PASS = "admin";

	static Connection connection = null;
    static ResultSet rs = null;  
    static Statement stmt = null;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/ssdi";
	
	
    public static ResultSet getResultSet(String topicname) throws ClassNotFoundException, SQLException{
    Class.forName("com.mysql.jdbc.Driver");

    // STEP 3: Open a connection
    System.out.print("\nConnecting to database...");
    connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
    
    String query = "SELECT * FROM questionbank where q_topic =?";
    System.out.println("1>>>>>>>>>>>>>>>");
    
    PreparedStatement s = (PreparedStatement) connection.prepareStatement(query);
    s.setString(1, topicname);
    return rs = s.executeQuery();
    
    
    }
    
    public static ResultSet getOptions(int id) throws ClassNotFoundException, SQLException
    {
    	 Class.forName("com.mysql.jdbc.Driver");

    	    // STEP 3: Open a connection
    	    System.out.print("\nConnecting to database...");
    	    connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
    	    
    	    String query = "SELECT * FROM options where q_ID="+Integer.valueOf(id).toString();
    	    System.out.println("1>>>>>>>>>>>>>>>");
    	    
    	   //Statement ps = connection.createStatement(query);
    	    Statement s = (Statement) connection.createStatement();
    	    return rs = s.executeQuery(query);
    	    //ps.setInt(1, id);
    	    //return rs = ps.executeQuery(query);
    }
	
    public static ArrayList<String> getTopics() throws ClassNotFoundException, SQLException
    {
    	Class.forName("com.mysql.jdbc.Driver");
    	
    	ArrayList<String> topics= new ArrayList<String>();

	    // STEP 3: Open a connection
	    System.out.print("\nConnecting to database...");
	    connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
	    
	    String query = "select distinct q_topic from questionbank";
	    Statement s = (Statement) connection.createStatement();
	    ResultSet rs = s.executeQuery(query);
	    while(rs.next())
	    {
	    	topics.add(rs.getString("q_topic"));
	    }
	    
	    return topics;
    }

	public static ResultSet getrecommendResultSet(String subtopicname,String topic) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		System.out.println("topic is" + topic);
		System.out.println("sub topic is"+ subtopicname);
	    // STEP 3: Open a connection
	    System.out.print("\nConnecting to database...");
	    connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
	    
	    String query = "SELECT * FROM questionbank where q_subtopic =? and q_topic=?";
	    System.out.println("1>>>>>>>>>>>>>>>");
	    
	    PreparedStatement s = (PreparedStatement) connection.prepareStatement(query);
	    s.setString(1, subtopicname);
	    s.setString(2, topic);
	    return rs = s.executeQuery();
	}
	
}
