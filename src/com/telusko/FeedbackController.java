package com.telusko;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.Bean.QuestionBean;
import com.telusko.service.FeedbackService;
import com.telusko.service.LeaderBoardService;
import com.telusko.service.QuestionService;

@Controller
public class FeedbackController {

	@RequestMapping("/Practice")
	public ModelAndView practice(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
	
		ModelAndView mv = new ModelAndView();
		HttpSession questionsession = request.getSession();
		questionsession.setAttribute("exam type", "practice");
		QuestionService service = new QuestionService();
		ArrayList<String> topics=service.getTopics();
		request.setAttribute("topiclist", topics);
		questionsession.setAttribute("topiclist", topics);
		//request.getRequestDispatcher("Select Topic.jsp").forward(request, response);
		mv.setViewName("Select Topic.jsp");
		return mv;
	}

	@RequestMapping("/mockexam")
	public ModelAndView mockExam(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("feedback.jsp");
		return mv;
		
	}
	@RequestMapping("/feedbackpage1")
	public ModelAndView feedbackpage1(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {

		
		HttpSession questionsession = request.getSession();
		int count=0;
		ArrayList<QuestionBean> qlist = (ArrayList<QuestionBean>) questionsession.getAttribute("displayqlist");
		//questionsession.getAttribute("qList");
		//ArrayList<String> selectedAnswers = new ArrayList<String>();
		LinkedHashMap<Integer,String> answermapping = new LinkedHashMap<Integer,String>(); 
		for(int i=0;i<qlist.size();i++){
		   QuestionBean ques = qlist.get(i);
		  /* System.out.println("id value is" +Integer.valueOf(ques.getQuestionid()).toString());
		   System.out.println("answer value " + Integer.valueOf(ques.getAnswer()).toString());*/
		   String myanswer = request.getParameter(Integer.toString(ques.getQuestionid()));
		   int actualanswer=ques.getQuestionid();
		   answermapping.put(actualanswer, myanswer);
		   if(ques.getAnswer().equalsIgnoreCase(myanswer))
		   {
			   count++;
		   }
		}
		FeedbackService feedback = new FeedbackService();
		feedback.myFeed(answermapping,request);
		questionsession.setAttribute("correct", count);
		System.out.println("returned after user response");
		String uname = (String) questionsession.getAttribute("currentSessionUsername");
		String ltopic = (String) questionsession.getAttribute("topic");
		LeaderBoardService lb = new LeaderBoardService();
		lb.addLeaderboard(uname,ltopic,count);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("feedback.jsp");
		return mv;
	}

	@RequestMapping("/nextaction")
	public ModelAndView nextaction(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {

		String nextaction = request.getParameter("action");
		System.out.println(nextaction);
		if(nextaction.equals("Recommendation"))
		{
			HttpSession questionsession = request.getSession();
			String topic= (String) questionsession.getAttribute("topic");
			String username = (String) questionsession.getAttribute("currentSessionUsername");
			FeedbackService service =new FeedbackService();
			ArrayList<String> subTopics =service.getRecommendations(topic,username);

			ModelAndView mv = new ModelAndView();
			questionsession.setAttribute("recommendations", subTopics);
			mv.setViewName("Recommendation.jsp");
			return mv;
			
		}
		else if(nextaction.equals("retake"))
		{
			int count=0;
			HttpSession questionsession = request.getSession();
			ArrayList<QuestionBean> questionsdisplay= (ArrayList<QuestionBean>) questionsession.getAttribute("displayqlist");
			ArrayList<QuestionBean> questionstotal = (ArrayList<QuestionBean>) questionsession.getAttribute("qList");
			ArrayList<QuestionBean> questions = new ArrayList<QuestionBean>();
			System.out.println("display question size " + questionsdisplay.size());
			System.out.println("total question size " + questionstotal.size());
			questionstotal.removeAll(questionsdisplay);
			
			System.out.println("total size after removing" + questionstotal.size());	
			  Random rand = new Random();
				 int numberOfElements = 10;
				 
				 ArrayList<QuestionBean> givenList = questionstotal;
				    for (int i = 0; i < numberOfElements; i++) {
				        int randomIndex = rand.nextInt(givenList.size());
				        questions.add(givenList.get(randomIndex));
				        givenList.remove(randomIndex);
				    }
				 givenList = new ArrayList<QuestionBean>(); 
			 questionstotal.addAll(questionsdisplay);
			 questionsession.setAttribute("qList", questionstotal);
			 request.setAttribute("questionslist", questions);
			 questionsession.setAttribute("displayqlist", questions);
			 try {
				request.getRequestDispatcher("mytestquestion.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(nextaction.equals("changetopic"))
		{
			HttpSession questionsession = request.getSession();
			questionsession.setAttribute("qList", null);
			questionsession.setAttribute("displayqlist", null);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("Select Topic.jsp");
			return mv;
		}
		else
		{
		    // code for displaying the feedback form when he clicks on quit button.	
			HttpSession questionsession = request.getSession();
			 questionsession.setAttribute("qList", null);
			 questionsession.setAttribute("displayqlist", null);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("usercomment.jsp");
			return mv;
		}
		return null;
	}	
}