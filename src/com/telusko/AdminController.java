package com.telusko;

import java.io.IOException;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.Bean.QuestionBean;
import com.telusko.Bean.UserBean;
import com.telusko.Bean.ExamBean;

import com.telusko.service.AdminServices;
import com.telusko.service.LoginService;
import com.telusko.service.QuestionService;

@Controller
public class AdminController {

	
	@RequestMapping("/createqusetion")
	public ModelAndView createQuestion( HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		

		 ModelAndView mv = new ModelAndView();
	     mv.setViewName("addquestion.jsp");
         return mv;
	}
	

	@RequestMapping("/showtopics")
	public ModelAndView showtopics(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
	
		ModelAndView mv = new ModelAndView();
		HttpSession questionsession = request.getSession();
		QuestionService service = new QuestionService();
		ArrayList<String> topics=service.getTopics();
		request.setAttribute("topiclist", topics);
		questionsession.setAttribute("topiclist", topics);
		String submit = request.getParameter("submit");
		if(submit.equals("Delete Questions")) {
			questionsession.setAttribute("admintask", "delete");	
		}
		else {
			questionsession.setAttribute("admintask", "view");	
		}
		//request.getRequestDispatcher("Select Topic.jsp").forward(request, response);
		mv.setViewName("admintopic.jsp");
		return mv;
	}
	
	@RequestMapping("/addexampage")
	public ModelAndView addexampage( HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		

		 ModelAndView mv = new ModelAndView();
	     mv.setViewName("addexam.jsp");
         return mv;
	}
	@RequestMapping("/adminhome")
	public ModelAndView adminhome( HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		

		 ModelAndView mv = new ModelAndView();
	     mv.setViewName("adminhome.jsp");
         return mv;
	}
	
	
	@RequestMapping("/addquestion")
	public ModelAndView addqQuestion( HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		
		
		//String question, String answer, String topic, String subtopic,int questionid, int q_level, ArrayList<String> options		
		
		String question = request.getParameter("question");
		
		String correct = request.getParameter("correct");
		String topic = request.getParameter("topic");
		String subtopic = request.getParameter("subtopic");
		int level = Integer.valueOf(request.getParameter("level"));
		ArrayList<String> options = new ArrayList<String>();
		options.add(request.getParameter("option1"));
		options.add(request.getParameter("option2"));
		options.add(request.getParameter("option3"));
		options.add(request.getParameter("option4"));
		
		QuestionBean qbean = new QuestionBean(question,correct,topic,subtopic,level,options);

		
		
		AdminServices adminservices = new AdminServices();
		adminservices.insertQuestion(qbean);
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("adminhome.jsp");
        return mv;
		


	}
	
	
	
	@RequestMapping("/admintask")
	public ModelAndView deleteQuestion( HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException, ServletException{
	
		
		String topic = request.getParameter("selecttopic");
		
		AdminServices adminservices = new AdminServices();
		ArrayList<QuestionBean> qlist = adminservices.deleteQuestion(topic);	
		request.setAttribute("qlist", qlist);
		HttpSession questionsession = request.getSession();
		questionsession.setAttribute("qList", qlist);
		if(questionsession.getAttribute("admintask").equals("delete")) {
			request.getRequestDispatcher("deletequestion.jsp").forward(request, response);	
		}
		else {
			request.getRequestDispatcher("viewquestion.jsp").forward(request, response);
		}
		
//		ModelAndView mv = new ModelAndView();
//	    mv.setViewName("adminhome.jsp");
        return null;
//		


	}
	
	@RequestMapping("/actualdelete")
	public ModelAndView actualDelete(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		String[] selectedQuestionIds = request.getParameterValues("selected");
		if(selectedQuestionIds!=null) {
		AdminServices adminservices = new AdminServices();
		adminservices.actualDeleteQuestion(selectedQuestionIds);
		}
		 ModelAndView mv = new ModelAndView();
	     mv.setViewName("adminhome.jsp");
         return mv;
	}
	
	
/*	@RequestMapping("/signup")
	public ModelAndView signUp() throws ClassNotFoundException, SQLException, IOException{
		
		 ModelAndView mv = new ModelAndView();
	     mv.setViewName("signup.jsp");
         return mv;
	}*/
	
	
	/*
	@RequestMapping("/userInfo")
	public ModelAndView userProfile(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		
   
	String usertype = (String) request.getParameter("user");	
	String firstname = (String) request.getParameter("firstname");	
	String lastname = (String) request.getParameter("lastname");	
	String email = (String) request.getParameter("email");
	String password = (String) request.getParameter("password");
	String username = (String) request.getParameter("id");
	System.out.println(usertype + firstname + lastname + email + password + username);
	UserBean bean = new UserBean(usertype, username,  password,  firstname,  lastname,email);
	
	LoginService loginservice = new LoginService();
	boolean b=loginservice.addUser(bean);
	ModelAndView mv =new ModelAndView();
	
	
	
	if(b)
	{
		
		mv.setViewName("index.jsp");
	}
 
		    return mv;
	}
	*/
	
	@RequestMapping("/addexam")
	public ModelAndView addExam(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException, ParseException{

	String topic = (String) request.getParameter("topic");	
	String datetime = (String) request.getParameter("datetime");	
	String capacity = (String) request.getParameter("capacity");	
	String duration = (String) request.getParameter("duration");
	Timestamp timestamp =null;
	System.out.println("string date is: "+datetime);
	String time = datetime.substring(11);
	String date = datetime.substring(0,10);
	String act = date + " " + time;
	System.out.println("string date is: "+act);
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
	    Date parsedDate = dateFormat.parse(act);
	    System.out.println("parsed date is"+parsedDate);
	    timestamp = new java.sql.Timestamp(parsedDate.getTime());
	    System.out.println("parsed time is"+timestamp);
	
	
	ExamBean bean = new ExamBean(topic, Integer.parseInt(capacity),0,Integer.parseInt(duration),timestamp);
	
	AdminServices adminservice = new AdminServices();
	adminservice.addExam(bean);
	ModelAndView mv =new ModelAndView();
	mv.setViewName("adminhome.jsp");
	return mv;
	}
	
}
