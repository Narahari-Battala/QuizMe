package com.telusko.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.telusko.Bean.ExamBean;
import com.telusko.Bean.QuestionBean;
import com.telusko.DAO.ExamDAO;
import com.telusko.DAO.QuestionDAO;

public class ExamService {
ResultSet rs;
public ArrayList<ExamBean> upcomingExams() {
	System.out.println("in view exam service method");
		ExamBean exam;
		ArrayList<ExamBean> exams = new ArrayList<ExamBean>();
		
		try {
			rs = ExamDAO.getExamSet();
			
			while (rs.next())
			{
				int exam_id= rs.getInt(1);
				String topic= rs.getString(2);
				Timestamp time = rs.getTimestamp(3);
				int duration = rs.getInt(4);
				int capacity = rs.getInt(5);
				int registered = rs.getInt(6);
				System.out.println("test............");
				exam = new ExamBean(topic, capacity,registered,duration,time);
				exam.setExam_id(exam_id);
				exam.toString();
				exams.add(exam);			
				}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return exams;
		
	}
public int registerExam(int examid) throws ClassNotFoundException, SQLException {
	return ExamDAO.registerExam(examid);

}

public int registerUserExam(int examid, String user) throws ClassNotFoundException, SQLException {
	return ExamDAO.registerUserExam(examid,user);

}
}
