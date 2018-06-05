package com.telusko;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.telusko.Bean.QuestionBean;
import com.telusko.service.QuestionService;

/**
 * Servlet implementation class QuestionServlet
 */
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String subtopicaction = request.getParameter("subtopicsubmit");
		HttpSession session = request.getSession();
		String topic= (String) session.getAttribute("topic");
		if(subtopicaction.equals("Submit"))
		{
			String subTopic = request.getParameter("subtopic");
			System.out.println("inside get subtopic" + subTopic);
			int count=0;
			QuestionService questservice = new QuestionService();
			ArrayList<QuestionBean> questions=questservice.myrecommendQuestions(subTopic,topic);
			System.out.println("recomended size" + questions.size());
			ArrayList<QuestionBean> displayquestions=new ArrayList<QuestionBean>();
			HttpSession questionsession = request.getSession();
			Random rand = new Random();
			 int numberOfElements = 10;
			 
			 if(questions.size()>numberOfElements)
			 {
				 System.out.println("inside if");
				 ArrayList<QuestionBean> givenList = questions;
				 for (int i = 0; i < numberOfElements; i++) 
				 {
			        int randomIndex = rand.nextInt(givenList.size());
			        displayquestions.add(givenList.get(randomIndex));
			        givenList.remove(randomIndex);
				 }
				 givenList = new ArrayList<QuestionBean>(); 
			 
				 request.setAttribute("questionslist", displayquestions);
				 questionsession.setAttribute("displayqlist", displayquestions);
			 }
			 else 
			 {
				 System.out.println("inside else");
				 request.setAttribute("questionslist", questions);
				 questionsession.setAttribute("displayqlist", questions);
			 }
			request.getRequestDispatcher("recommendedquiz.jsp").forward(request, response);
		
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside post");
		String topicaction =request.getParameter("topic");
		String topic = request.getParameter("selecttopic");
		HttpSession session = request.getSession();
		session.setAttribute("topic", topic);
		
		if(topicaction.equals("Submit"))
		{
			int count=0;
			QuestionService questservice = new QuestionService();
			ArrayList<QuestionBean> questions=questservice.myQuestions(topic);
			ArrayList<QuestionBean> displayquestions=new ArrayList<QuestionBean>();
			HttpSession questionsession = request.getSession();
			  Random rand = new Random();
			 int numberOfElements = 10;
			 
			 ArrayList<QuestionBean> givenList = questions;
			    for (int i = 0; i < numberOfElements; i++) {
			        int randomIndex = rand.nextInt(givenList.size());
			        displayquestions.add(givenList.get(randomIndex));
			        givenList.remove(randomIndex);
			    }
			 givenList = new ArrayList<QuestionBean>(); 
            request.setAttribute("questionslist", displayquestions);
			questionsession.setAttribute("qList", questions);
			questionsession.setAttribute("displayqlist", displayquestions);
			request.getRequestDispatcher("mytestquestion.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		}
	}
}
