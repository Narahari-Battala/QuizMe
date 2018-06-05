package com.telusko.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.telusko.Bean.QuestionBean;
import com.telusko.DAO.QuestionDAO;

public class QuestionService {

	ResultSet rs = null;
	ResultSet rs1 = null;
	public ArrayList<QuestionBean> myQuestions(String topicname) {
		
		QuestionBean question;
		ArrayList<QuestionBean> questions = new ArrayList<QuestionBean>();
		
		try {
			rs = QuestionDAO.getResultSet(topicname);
			
			while (rs.next())
			{
				int qid= rs.getInt(1);
				String ques= rs.getString(2);
				String answer = rs.getString(3);
				String topic = rs.getString(4);
				String subtopic = rs.getString(5);
				int ql= rs.getInt(6);
				
				System.out.println("test............");
				rs1= QuestionDAO.getOptions(qid);
				ArrayList<String> options = new ArrayList<String>();
				while (rs1.next())
				{
					String option = rs1.getString(3);
					options.add(option);
				}
				question= new QuestionBean(ques, answer, topic, subtopic,qid,ql,options);
				//QuestionBean(String question, String answer, String topic, String subtopic,int questionid, int q_level, ArrayList<String> options
				System.out.println(question.toString());
				questions.add(question)
;			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return questions;
		
	}
	
	public ArrayList<String> getTopics() throws ClassNotFoundException, SQLException
	{
		ArrayList<String> topics=QuestionDAO.getTopics();
		return topics;
	}
	
	

public ArrayList<QuestionBean> myrecommendQuestions(String subtopicname, String selecttopic) {
		
		QuestionBean question;
		ArrayList<QuestionBean> questions = new ArrayList<QuestionBean>();
		
		try {
			rs = QuestionDAO.getrecommendResultSet(subtopicname,selecttopic);
			while (rs.next())
			{
				System.out.println("rs next");
				int qid= rs.getInt(1);
				String ques= rs.getString(2);
				String answer = rs.getString(3);
				String topic = rs.getString(4);
				String subtopic = rs.getString(5);
				int ql= rs.getInt(6);
				rs1= QuestionDAO.getOptions(qid);
				ArrayList<String> options = new ArrayList<String>();
				while (rs1.next())
				{
					String option = rs1.getString(3);
					options.add(option);
				}
				question= new QuestionBean(ques, answer, topic, subtopic,qid,ql,options);
//				question= new QuestionBean(ques, answer, topic, subtopic,qid,ql,options);
				System.out.println(question.toString());
				questions.add(question)
;			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return questions;
		
	}
	
}
