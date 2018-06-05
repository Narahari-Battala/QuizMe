package com.telusko.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class ExamDAO {

	static final String USER = "root";
    static final String PASS = "admin";

	static Connection connection = null;
    static ResultSet rs = null;  
    static Statement stmt = null;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/ssdi";
	
	
    public static ResultSet getExamSet() throws ClassNotFoundException, SQLException{
    Class.forName("com.mysql.jdbc.Driver");

    // STEP 3: Open a connection
    System.out.print("\nConnecting to database...");
    connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
    
    String query = "select *from exams where capacity>registered and exam_date> CURDATE();";
    System.out.println("1>>>>>>>>>>>>>>>");
    
    Statement s = (Statement) connection.createStatement();
    return rs = s.executeQuery(query);
    
    
    }
    public static int registerExam(int examid) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");

        // STEP 3: Open a connection
        System.out.print("\nConnecting to database...");
        connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        
        String query = "update exams set registered = registered + 1 where exam_id = ?";
        System.out.println("1>>>>>>>>>>>>>>>");
        
        PreparedStatement stmt=(PreparedStatement) connection.prepareStatement(query);  
        stmt.setInt(1,examid);//1 specifies the first parameter in the query    
          
        int i=stmt.executeUpdate(); 
        return i;
        }
    public static int registerUserExam(int examid, String user) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");

        // STEP 3: Open a connection
        System.out.print("\nConnecting to database...");
        connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
 
        String query = "insert into examsregistered values(?,?) ";
      
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
        ps.setInt(1,examid);
        ps.setString(2,user);
        int x= ps.executeUpdate();
        
        return x;
        }
    
    
}
