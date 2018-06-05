package com.telusko.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.telusko.Bean.UserBean;
import com.telusko.DAO.LoginDAO;
import com.telusko.DAO.addUserDAO;

public class LoginService {

	ResultSet rs = null;

	public UserBean validateUser(UserBean userbean) {
		
		UserBean bean=null;
		String msg=null;

		try {
			bean = LoginDAO.getResultSet(userbean);			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bean;
	}
	
	public boolean addUser(UserBean bean){
		
		int x=0;
		
		try {
			x= addUserDAO.addUser(bean);
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
	
	public boolean userExists(String uname) throws ClassNotFoundException, SQLException {
		addUserDAO ad = new addUserDAO();
		boolean x= ad.userExists(uname);
		return x;
	
	}
	
}
