package com.telusko.DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.telusko.Bean.ExamBean;
import com.telusko.Bean.QuestionBean;
import com.telusko.Bean.UserBean;

public class AdminDAO {
	
	static final String USER = "root";
    static final String PASS = "admin";

	static Connection connection = null;
    static ResultSet rs = null;  
    static Statement stmt = null;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/ssdi";
	
	public int insertQuestion(QuestionBean bean) throws SQLException, ClassNotFoundException{
		
		

	    Class.forName("com.mysql.jdbc.Driver");

	    // STEP 3: Open a connection
	    System.out.print("\nConnecting to database...");
	    connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
	    
	    //q_details,q_answer,q_topic,q_subtopic,q_level
	    
	    String question = "insert into questionbank(q_details,q_answer,q_topic,q_subtopic,q_level) values(?,?,?,?,?)";
	  
	    PreparedStatement ps = connection.prepareStatement(question);
	    ps.setString(1, bean.getQuestion());
	    ps.setString(2, bean.getAnswer());
	    ps.setString(3, bean.getTopic());
	    //ps.setString(4, bean.getTopic());
	    ps.setString(4, bean.getSubtopic());
	    ps.setInt(5, bean.getQ_level());
	    int x= ps.executeUpdate();
	    
	    String query_qID = "SELECT max(q_id) FROM questionbank";
	    System.out.println("1>>>>>>>>>>>>>>>");
	    //UserBean userbean =null;
	    PreparedStatement ps2 = connection.prepareStatement(query_qID);
	    rs = ps2.executeQuery();
	    int q_id = 0;
	    while(rs.next()){
	    q_id = rs.getInt(1);
	    }
	    
	    String options = "insert into options(q_id,option_value) values(?,?)";
	    PreparedStatement ps1 = connection.prepareStatement(options);
	    
	    for(int i=0;i<4;i++){
	    ps1.setInt(1, q_id);
	    ps1.setString(2, bean.getOptions().get(i));
	    int x1= ps1.executeUpdate();
	    }
	    return x;
	    }

	public ResultSet deleteQuestion(String topic) throws SQLException, ClassNotFoundException {
	
		
		   Class.forName("com.mysql.jdbc.Driver");

		    // STEP 3: Open a connection
		    System.out.print("\nConnecting to database...");
		    connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
	    String query = "SELECT * FROM questionbank where q_topic = ?";
	    System.out.println("1.. select question for delete >>>");
        
        PreparedStatement stmt=(PreparedStatement) connection.prepareStatement(query);  
        stmt.setString(1,topic);//1 specifies the first parameter in the query    
          
        rs =stmt.executeQuery(); 
        return rs;
	    /*while(rs.next()){
	    int  q_id = rs.getInt(1);
	    String q_details = rs.getString(2);
	    String q_topic = rs.getString(3);
	    String q_subtopic = rs.getString(4);
	    int level = rs.getInt(5);
		question= new QuestionBean(q_id, q_details, q_topic, q_subtopic,level);
		questionset.add(question);
	    }*/
		
		
	
	}
	
	public void actualDeleteQuestion(String[] questionIds) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");

	    // STEP 3: Open a connection
	    System.out.print("\nConnecting to database...");
	    connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
////	    Statement st = con.createStatement();
//	    Statement st = (Statement) connection.createStatement();
		for ( int i =0;i<questionIds.length;i++){
//			st.addBatch("DELETE FROM questionbank where");
//		}
//	    int[] results = st.executeBatch();
	    PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM questionbank WHERE q_ID = ?";

		try {
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, Integer.valueOf(questionIds[i]));
			preparedStatement.executeUpdate();
			System.out.println("Record is deleted!");
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

		}
		}

	}
	
	 public static int addExam(ExamBean bean) throws ClassNotFoundException, SQLException{
		    Class.forName("com.mysql.jdbc.Driver");
		    // STEP 3: Open a connection
		    System.out.print("\nConnecting to database...");
		    connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		   
		    String query = "insert into exams(exam_topic,exam_date,duration,capacity,registered) values(?,?,?,?,?) ";
		   
		    PreparedStatement ps = connection.prepareStatement(query);
		    ps.setString(1, bean.getExam_topic());
		    ps.setTimestamp(2, bean.getExam_time());
		    ps.setInt(3, bean.getDuration());
		    ps.setInt(4, bean.getCapacity());
		    ps.setInt(5, bean.getRegistered());
		    
		    int x= ps.executeUpdate();
		    
		    return x;
		    }
		
		
		
}
	


