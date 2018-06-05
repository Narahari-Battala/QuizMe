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
import com.telusko.Bean.UserBean;

public class UserAnswerDAO {

	
	
    static final String USER = "root";
    static final String PASS = "admin";

	static Connection connection = null;
    static ResultSet rs = null;  
    static Statement stmt = null;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/ssdi";
	
    
    public void storeMyResponse(LinkedHashMap<Integer, String> myresponse, HttpServletRequest request) throws SQLException, ClassNotFoundException {
	
    	Class.forName("com.mysql.jdbc.Driver");
    	int i=0;

        // STEP 3: Open a connection
        connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        
    HttpSession session = request.getSession();
    String username = (String) session.getAttribute("currentSessionUsername");
    ArrayList<QuestionBean> qlist = (ArrayList<QuestionBean>) session.getAttribute("displayqlist");
    
    String query = "Insert into user_response(username,q_ID,q_answer,user_resp,q_topic,q_subtopic,current_t) values (?,?,?,?,?,?,?)";
    Calendar cal = Calendar.getInstance();
    Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
    for (Map.Entry<Integer, String> entry : myresponse.entrySet()) {
	
	PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
	preparedStatement.setString(1, username);
	preparedStatement.setInt(2, qlist.get(i).getQuestionid());
	preparedStatement.setString(3, qlist.get(i).getAnswer());
	preparedStatement.setString(4, entry.getValue());
	preparedStatement.setString(5, qlist.get(i).getTopic());
	preparedStatement.setString(6, qlist.get(i).getSubtopic());
	preparedStatement.setTimestamp(7, timestamp);
	preparedStatement .executeUpdate();
	i++;
	}	
}
}	
