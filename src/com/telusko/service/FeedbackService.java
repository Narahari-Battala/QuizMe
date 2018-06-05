package com.telusko.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.telusko.DAO.FeedbackDAO;
import com.telusko.DAO.UserAnswerDAO;

public class FeedbackService {
	LinkedHashMap<String, String> dbselect = new LinkedHashMap<String, String>();
	ResultSet rs = null;

	
	
	public void myFeed(LinkedHashMap<Integer, String> myanswers, HttpServletRequest request) throws SQLException, ClassNotFoundException {
		
	UserAnswerDAO myresponse = new UserAnswerDAO();
	myresponse.storeMyResponse(myanswers,request);
	
	}
	
	public ArrayList<String> getRecommendations(String topic,String userName) throws ClassNotFoundException, SQLException
	{
		ArrayList<String> subTopics = FeedbackDAO.getRecomend(topic,userName);
		return subTopics;
	}



}
