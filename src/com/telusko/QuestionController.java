package com.telusko;
import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.Bean.QuestionBean;
import com.telusko.service.QuestionService;


@Controller
public class QuestionController {

//	@RequestMapping("/questions")
//	public ModelAndView questionSet(HttpServletRequest request, HttpServletResponse response){
//		
//		
//	    String level = request.getParameter("level");
//		System.out.println("level is:"+level);
//		QuestionService questservice = new QuestionService();
//		ArrayList<QuestionBean> questions=questservice.myQuestions();
//		
//		System.out.println(questions.get(0).getQuestion());
//		System.out.println(questions.get(0).getOptions());
//		
//		System.out.println(questions.get(1).getQuestion());
//		System.out.println(questions.get(1).getOptions());
//		//int k = i+j;
//		
//		ModelAndView mv = new ModelAndView();
//	    /*if(level.equals("easy")){
//		mv.setViewName("easyquestion1.jsp");
//	    }else if(level.equals("easy")){
//		mv.setViewName("mediumques.jsp");
//	    }else{
//	    mv.setViewName("hardques.jsp");	
//	    }*/
//
//	    mv.setViewName("mytestquestion.jsp");	
//		ModelMap map= new ModelMap();
//		map.addAttribute("questionlist", questions);
//		mv.addObject("questionlist", map);
//		//request.setAttribute("questions", questions);
//		//mv.
//		return mv;
		//return new ModelAndView("questionlist", map);
		//return null;
//	}
	
}
