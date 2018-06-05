package com.telusko.DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.telusko.Bean.NotebookBean;
import com.telusko.Bean.SentimentBean;

public class NotebookDAO {

	static final String USER = "root";
    static final String PASS = "admin";

	static Connection connection = null;
    static ResultSet rs = null;  
    static Statement stmt = null;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/ssdi";
	
	
    public ResultSet myNotebooks(String uname) throws SQLException, ClassNotFoundException {
    	
		
		Class.forName("com.mysql.jdbc.Driver");

		    // STEP 3: Open a connection
		System.out.print("\nConnecting to database...");
		connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
	    String listofNotebook = "SELECT * FROM mynotebook where username =?";
//	    System.out.println("1.. select question for delete >>>");
	    PreparedStatement ps = connection.prepareStatement(listofNotebook);
	    ps.setNString(1,uname);
	    return rs = ps.executeQuery();
    
}
    public ResultSet viewMyNoteContent(NotebookBean mynotebean) throws SQLException, ClassNotFoundException {
    	
		
		Class.forName("com.mysql.jdbc.Driver");

		    // STEP 3: Open a connection
		System.out.print("\nConnecting to database...");
		connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
	    String content = "SELECT * FROM mynotebook where username =? and notebook_name =?";
//	    System.out.println("1.. select question for delete >>>");
	    
	    PreparedStatement ps = connection.prepareStatement(content);
	   // ps.setNString(1,mynotebean);
	    return rs = ps.executeQuery();
    
}
    public int updateNotes(NotebookBean mynotebean) throws SQLException, ClassNotFoundException {
    	
		
  		Class.forName("com.mysql.jdbc.Driver");

  		    // STEP 3: Open a connection
  		System.out.print("\nConnecting to database...");
  		connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
  	    String query = "update mynotebook set content = ? ,lastupdated = CURDATE() where notebook_id =?";
//  	    System.out.println("1.. select question for delete >>>");
  	    
  	    PreparedStatement ps = connection.prepareStatement(query);
  	    ps.setString(1,mynotebean.getContent());
  	    ps.setInt(2,mynotebean.getId()); 
  	    int rs = ps.executeUpdate();
  	    return rs;
      
  }
    
    
    public NotebookBean addNewNote(NotebookBean mynotebean) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");

        // STEP 3: Open a connection
        System.out.print("\nConnecting to database...");
        connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        
       
        
        String query = "insert into mynotebook(notebook_name,username,content,lastupdated) values (?,?,?,CURDATE());";
      
        PreparedStatement ps = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, mynotebean.getNotebook_name());
        ps.setString(2, mynotebean.getUsername());
        ps.setString(3, mynotebean.getContent());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        int id=0;
        if(rs.next()){
            id=rs.getInt(1);
            System.out.println("id is: "+id);
        }
        
        mynotebean.setId(id);
        LocalDate date = LocalDate.now();
        java.util.Date today = java.sql.Date.valueOf(date);
        mynotebean.setLastupdated(today);
        return mynotebean;
    }
    

	
	
}
