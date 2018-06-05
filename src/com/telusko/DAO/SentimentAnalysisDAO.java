package com.telusko.DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.telusko.Bean.SentimentBean;
import com.telusko.Bean.UserBean;

public class SentimentAnalysisDAO {

	
	static final String USER = "root";
    static final String PASS = "admin";

	static Connection connection = null;
    static ResultSet rs = null;  
    static Statement stmt = null;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/ssdi";
	
	
    public ResultSet goldlabel(String target) throws SQLException, ClassNotFoundException {
    	
		
		Class.forName("com.mysql.jdbc.Driver");

		    // STEP 3: Open a connection
		System.out.print("\nConnecting to database...");
		connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
	    String label = "SELECT * FROM goldlabels where goldlabel =?";
//	    System.out.println("1.. select question for delete >>>");
	    
	    PreparedStatement ps = connection.prepareStatement(label);
	    ps.setString(1,target);
	    return rs = ps.executeQuery();
    
}
    
    
    public int insertSentiment(SentimentBean sentiment, String predictedlabel) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");

        // STEP 3: Open a connection
        System.out.print("\nConnecting to database...");
        connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        
        
/*        username varchar(100),
        topic varchar(100),
        subtopic varchar(100),
        comment varchar(100),
        predicted_label*/
        
        String query = "insert into sentiments(username,topic,subtopic,comment,predicted_label) values(?,?,?,?,?) ";
      
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, sentiment.getUsername());
        ps.setString(2, sentiment.getTopic());
        ps.setString(3, sentiment.getSubtopic());
        ps.setString(4, sentiment.getComment());
        ps.setString(5, predictedlabel);
        int x= ps.executeUpdate();
        return x;
        }

    
    
    public ResultSet viewSentiment() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");

        // STEP 3: Open a connection
        System.out.print("\nConnecting to database...");
        connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        
        
/*        username varchar(100),
        topic varchar(100),
        subtopic varchar(100),
        comment varchar(100),
        predicted_label*/
        
        String query = "select predicted_label, topic, count(*) from sentiments group by predicted_label,topic order by topic";
        Statement s = (Statement) connection.createStatement();
	    return rs = s.executeQuery(query); 
//        PreparedStatement ps = connection.prepareStatement(query);
//        rs= ps.executeQuery();
//        return rs;
        }
    public ResultSet viewSentimentReport(String topic, String label) throws SQLException, ClassNotFoundException {
        	
    		
		Class.forName("com.mysql.jdbc.Driver");

		    // STEP 3: Open a connection
		System.out.print("\nConnecting to database...");
		connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
	    String query = "SELECT * FROM sentiments where topic =? and predicted_label =?";
//	    System.out.println("1.. select question for delete >>>");
	    
	    PreparedStatement ps = connection.prepareStatement(query);
	    ps.setString(1,topic);
	    ps.setString(2,label);
	    return rs = ps.executeQuery();
    }
}
