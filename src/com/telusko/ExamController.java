package com.telusko;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.Bean.ExamBean;
import com.telusko.Bean.QuestionBean;
import com.telusko.service.ExamService;
import com.telusko.service.QuestionService;

@Controller
public class ExamController {
	
	@RequestMapping("/registerexam")
	public ModelAndView registerExam(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
//		String ans1 = request.getParameter("examid");
		int exam_id = Integer.parseInt(request.getParameter("examid"));
		System.out.println(exam_id);
		ExamService es = new ExamService();
		int i = es.registerExam(exam_id);
		if ( i ==1 ) {
			HttpSession session = request.getSession(true);	    
	        String user = (String) session.getAttribute("currentSessionUsername");
	        int x = es.registerUserExam(exam_id,user);
			if ( x == 1) {
	        ModelAndView mv = new ModelAndView();
			mv.setViewName("userhome.jsp");
			return mv;
			}
		}
		return null;
	}		

}
