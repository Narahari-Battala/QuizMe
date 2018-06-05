package com.telusko.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.telusko.Bean.ProfileBean;
import com.telusko.DAO.MyProfileDAO;

public class ProfileService {

	public ProfileBean myProfile(String user) throws ClassNotFoundException, SQLException {

		
		
		//Fetch user details from user details table
		MyProfileDAO pdao= new MyProfileDAO(); 
		ResultSet rs = pdao.selectMyProfileData(user);
		String username = null;
		String firstname = null;
		String lastname = null;
		String email = null;
		String avgscore = null;
		Date dateOfUpcomingExam = null;
		while(rs.next()){
			username=rs.getString(1);
			firstname=rs.getString(2);	
			lastname=rs.getString(3);	
			email=rs.getString(4);	
			avgscore=rs.getString(5);	
			dateOfUpcomingExam=rs.getDate(6);	
		}

	ProfileBean profilebean = new ProfileBean(username,firstname,lastname,email,avgscore,dateOfUpcomingExam);
	return profilebean;
		
		
		}
		
	}
	
	


