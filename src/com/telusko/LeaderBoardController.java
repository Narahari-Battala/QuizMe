package com.telusko;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.Bean.LeaderBoardBean;
import com.telusko.service.LeaderBoardService;
import com.telusko.service.QuestionService;

@Controller
public class LeaderBoardController {

	@RequestMapping("/viewleaderboard")
	public ModelAndView practice(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
		LeaderBoardService lb = new LeaderBoardService();
		ArrayList<LeaderBoardBean> lblist= new ArrayList<LeaderBoardBean>();
		lblist = lb.getLeaderboard();
		ModelAndView mv = new ModelAndView();
		request.setAttribute("lblist", lblist);
		HttpSession session = request.getSession(true);	    
	 	String utype =  (String) session.getAttribute("usertype");
        if(utype.equals("user"))
        {
    		mv.setViewName("leaderboard.jsp");
        }
        
        else
        {
    		mv.setViewName("adminleaderboard.jsp");
        }

		return mv;
		
		
	}
}