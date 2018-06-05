package com.telusko.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.telusko.Bean.ExamBean;
import com.telusko.Bean.LeaderBoardBean;
import com.telusko.DAO.ExamDAO;
import com.telusko.DAO.LeaderBoardDAO;
import com.telusko.DAO.UserAnswerDAO;

public class LeaderBoardService {
	
	public void addLeaderboard(String uname, String topic, int score) throws SQLException, ClassNotFoundException {
		
	LeaderBoardDAO myresponse = new LeaderBoardDAO();
	myresponse.storeLeaderBoardResponse(uname,topic,score);
	
	}
	public ArrayList<LeaderBoardBean> getLeaderboard() throws SQLException, ClassNotFoundException {
		
		LeaderBoardDAO lbdao = new LeaderBoardDAO();
		LeaderBoardBean lb;
		ArrayList<LeaderBoardBean> lbs = new ArrayList<LeaderBoardBean>();
	    ResultSet rs;	
		try {
			rs = lbdao.viewLeaderboard();;
			
			while (rs.next())
			{
				Double score = rs.getDouble(2);
				String username = rs.getString(1);
				lb = new LeaderBoardBean(username,score);
				System.out.println(lb.toString());
				lbs.add(lb);			
				}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lbs;	
	}

}
