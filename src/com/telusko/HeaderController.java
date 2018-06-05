package com.telusko;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.Bean.LeaderBoardBean;
import com.telusko.Bean.NotebookBean;
import com.telusko.Bean.ProfileBean;
import com.telusko.Bean.UserBean;
import com.telusko.service.LeaderBoardService;
import com.telusko.service.NotebookService;
import com.telusko.service.ProfileService;

@Controller
public class HeaderController {
	
	@RequestMapping(value="/hhome")
	public ModelAndView hHome( HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		
		HttpSession session = request.getSession();
       
       String utype = (String) session.getAttribute("usertype");
       ModelAndView mv = new ModelAndView(); 
       if(utype.equalsIgnoreCase("user")) {
    	   mv.setViewName("userhome.jsp");
        }
        else {
        	 mv.setViewName("adminhome.jsp");	
        }
        return mv;
	}
	
	@RequestMapping(value="/hleaderboard")
	public ModelAndView hleaderboard( HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		LeaderBoardService lb = new LeaderBoardService();
		ArrayList<LeaderBoardBean> lblist= new ArrayList<LeaderBoardBean>();
		lblist = lb.getLeaderboard();
		ModelAndView mv = new ModelAndView();
		request.setAttribute("lblist", lblist);
		mv.setViewName("leaderboard.jsp");
		return mv;
	}
	@RequestMapping(value="/hlogout")
	public ModelAndView hLogout( HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		HttpSession session = request.getSession();
	    session.invalidate();   
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}
	@RequestMapping(value="/haboutus")
	public ModelAndView hAbout( HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{   
		ModelAndView mv = new ModelAndView();
		mv.setViewName("about.jsp");
		return mv;
	}
	@RequestMapping(value="/hservices")
	public ModelAndView hServices( HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{   
		ModelAndView mv = new ModelAndView();
		mv.setViewName("services.jsp");
		return mv;
	}
	@RequestMapping(value="/hfeedback")
	public ModelAndView hFeedback( HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{   
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usercomment.jsp");
		return mv;
	}
	
	@RequestMapping(value="/hnotebooks")
	public ModelAndView displayPreviousNotes( HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("currentSessionUsername");
		NotebookService mynote = new NotebookService();
		ArrayList<NotebookBean> noteslist = mynote.viewMyNotes(uname);
		request.setAttribute("noteslist", noteslist);
		session.setAttribute("noteslist",noteslist);
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("mypreviouslist.jsp");
        return mv;
	}
	@RequestMapping(value = "/hprofile")
	public ModelAndView createQuestion( HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		
		 UserBean bean;
		// bean.getUsername();
		 String username = (String)request.getSession().getAttribute("currentSessionUsername");

		 ProfileService profile = new ProfileService();
		 ProfileBean pbean = profile.myProfile(username);
		 request.setAttribute("profile", pbean);
		 System.out.println(pbean.toString());
		 ModelAndView mv = new ModelAndView();
		 mv.addObject(pbean);
	     mv.setViewName("displayprofile.jsp");
         return mv;
	}
	

}
