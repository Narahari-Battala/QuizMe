package com.telusko.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.telusko.Bean.ExamBean;
import com.telusko.Bean.QuestionBean;
import com.telusko.Bean.UserBean;
import com.telusko.DAO.AdminDAO;
import com.telusko.DAO.addUserDAO;

public class AdminServices {

	
	
	public int insertQuestion(QuestionBean bean) throws ClassNotFoundException, SQLException{
		
		
		AdminDAO qdao = new AdminDAO();
		int insert = qdao.insertQuestion(bean);
		return 1;
	}
	public void actualDeleteQuestion(String[] questionIds) throws ClassNotFoundException, SQLException{
		AdminDAO qdao = new AdminDAO();
		qdao.actualDeleteQuestion(questionIds);
	}

	public ArrayList<QuestionBean> deleteQuestion(String topic) throws SQLException, ClassNotFoundException {
		
		QuestionBean question;
		ArrayList<QuestionBean> questionset = new ArrayList<QuestionBean>();
		
		AdminDAO qdao = new AdminDAO();
		ResultSet rs = qdao.deleteQuestion(topic);
		while(rs.next()){
	    int  q_id = rs.getInt(1);
	    String q_details = rs.getString(2);
	    String q_topic = rs.getString(4);
	    String q_subtopic = rs.getString(5);
	    int level = rs.getInt(6);
		question= new QuestionBean(q_id, q_details, q_topic, q_subtopic,level);
		questionset.add(question);
	    }
		return questionset;
		
	}
	
	public boolean addExam(ExamBean bean){	
		int x=0;
		try {
			x= AdminDAO.addExam(bean);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(x==1)
		{
			return true;
		}
		
		return false;
		
	}
	
	
}
