package com.telusko;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.Bean.UserBean;
import com.telusko.DAO.addUserDAO;
import com.telusko.service.HashPassword;
import com.telusko.service.LoginService;


@Controller
public class LoginController {

	@RequestMapping("/login")
	public ModelAndView validateUser(@RequestParam("username") String username, HttpServletRequest request,@RequestParam("password") String password, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		

	     UserBean userbean = new UserBean();
	     userbean.setUserName(username);
	     String hr;
	     try {
	    		hr = HashPassword.hashPwd(password);
	    	}
	    catch(NoSuchAlgorithmException e1) {
	    		hr = "error";
	    	}
	    if(!hr.equals("error")) {
	    		password = hr;
	    	}
	     userbean.setPassword(password);
		 LoginService loginservice = new LoginService();
		 UserBean bean = loginservice.validateUser(userbean);
		 Boolean validuser = bean.isValid();
		 String msg =null;
		 
		 ModelAndView mv = new ModelAndView();
		 if (validuser)
	     {	          
	          HttpSession session = request.getSession(true);	    
	          session.setAttribute("currentSessionUsername",request.getParameter("username"));
	          if(bean.getUsertype().equals("user"))
	          {
	        	  session.setAttribute("usertype","user");
			  mv.setViewName("userhome.jsp");
	          }
	          
	          else if (bean.getUsertype().equals("admin"))
	          {
	        	  session.setAttribute("usertype","admin");
	        	  mv.setViewName("adminhome.jsp");
	          }
			  mv.addObject("username",userbean.getUsername());
			  return mv;   		
	     }  else{ 
	    	  
	    	 msg ="UserName/Password is incorrect";
	    	 request.setAttribute("msg", msg );
	          try {
				response.sendRedirect("index.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			} 
	     }
		    return mv;
	}
	
	
	
	@RequestMapping("/signup")
	public ModelAndView signUp() throws ClassNotFoundException, SQLException, IOException{
		
		 ModelAndView mv = new ModelAndView();
	     mv.setViewName("signup.jsp");
         return mv;
	}

	@RequestMapping("/GoHome")
	public ModelAndView goHome() throws ClassNotFoundException, SQLException, IOException{
		
		 ModelAndView mv = new ModelAndView();
	     mv.setViewName("userhome.jsp");
         return mv;
	}
	
	@RequestMapping("/userInfo")
	public ModelAndView userProfile(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		
   
	String usertype = "user";	
	String firstname = (String) request.getParameter("firstname");	
	String lastname = (String) request.getParameter("lastname");	
	String email = (String) request.getParameter("email");
	String password = (String) request.getParameter("password");
	String con_pwd = (String) request.getParameter("cpassword");
	String username = (String) request.getParameter("id");
	System.out.println(usertype + firstname + lastname + email + password + username);
	ModelAndView mv =new ModelAndView();
	LoginService loginservice = new LoginService();
	Boolean b=false;
	if(username.length()<5){
//    	request.setAttribute("msg", "Enter a 9 digit student id.");
//        request.setAttribute("email", email);
//        request.setAttribute("name", name);
//        url = "/signup.jsp";
		System.out.println("in user length");
		mv.setViewName("signup.jsp");
    }else if(password.length()<4){
//    	request.setAttribute("msg", "Password length must be minimum 4 characters.");
//        request.setAttribute("email", email);
//        request.setAttribute("name", name);
//        url = "/signup.jsp";
    	System.out.println("in pwd length");
    	mv.setViewName("signup.jsp");
    }
    else if (!password.equals(con_pwd))
    {
//      request.setAttribute("msg", "Incorrect!! Passwords dont match.");
//      request.setAttribute("email", email);
//      request.setAttribute("name", name);
//      url = "/signup.jsp";
    	System.out.println("in cpwd length");
    	mv.setViewName("signup.jsp");
    }
    else if (loginservice.userExists(username))
    {
//        request.setAttribute("msg", "Enter the valid student id");
//        request.setAttribute("studentid", studentid);
//        request.setAttribute("name", name);
//        url = "/signup.jsp";
    	System.out.println("in user exists");
    	mv.setViewName("signup.jsp");
      }
    else {
    	
    	String hr;
    	try {
    		hr = HashPassword.hashPwd(password);
    		}
    	catch(NoSuchAlgorithmException e1) {
    		hr = "error";
    		}
    	if(!hr.equals("error")) {
    		password = hr;
    		}
    	UserBean bean = new UserBean(usertype,email, username,  password,  firstname,  lastname);
    	b =loginservice.addUser(bean);
    }
//	 HttpSession session = request.getSession(true);	    
//     session.setAttribute("currentSessionUsername",request.getParameter("username"));
//     session.setAttribute("usertype","user");
	  mv.setViewName("index.jsp");
	return mv;
	
//	if(b)
//	{
//		
//		mv.setViewName("index.jsp");
//	}
// 
//		    return mv;
//	}
	
	}
	}
