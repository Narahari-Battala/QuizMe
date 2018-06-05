package com.telusko;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.Bean.AnalysisBean;
import com.telusko.Bean.SentimentBean;
import com.telusko.service.SentimentAnalysisService;

@Controller
public class SentimentController {

	
	@RequestMapping("/sentimentanalysis")
	public ModelAndView mySentiment( HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		
		System.out.println("in sentiment controller");
		HttpSession session = request.getSession(true);	    
        String username = (String) session.getAttribute("currentSessionUsername");
		String topic="";
		if(request.getParameter("topic")!=null)
		{
		   topic=request.getParameter("topic");
		}
		String subtopic=request.getParameter("subtopic");
		String comment=request.getParameter("feedback");
		SentimentBean sentiment;
		System.out.println("topic from drop down is "+ topic);
		
		sentiment = new SentimentBean(username,topic,subtopic,comment);
		
		SentimentAnalysisService mysentiment = new SentimentAnalysisService();
		mysentiment.commentClassifier(sentiment);
		
		
		 ModelAndView mv = new ModelAndView();
	     mv.setViewName("userhome.jsp");
         return mv;
	}
	
	@RequestMapping("/viewsentiment")
	public ModelAndView viewSentiment( HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		SentimentAnalysisService mysentiment = new SentimentAnalysisService();
		ArrayList<AnalysisBean> ablist = mysentiment.viewSentiments();
		request.setAttribute("ablist",ablist);
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("viewsentiments.jsp");
        return mv;
	}
	

	@RequestMapping("/getreportoptions")
	public ModelAndView getReportOptions( HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("selectoptions.jsp");
        return mv;
	}
	
	@RequestMapping("/getsentimentreport")
	public ModelAndView getSentimentReport( HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		String topic="";
		if(request.getParameter("topic")!=null)
		{
		   topic=request.getParameter("topic");
		}
		String label="";
		if(request.getParameter("label")!=null)
		{
		   label=request.getParameter("label");
		}
		SentimentAnalysisService mysentiment = new SentimentAnalysisService();
		ArrayList<SentimentBean> sbeanlist = mysentiment.viewSentimentsReport(topic,label);
		request.setAttribute("sbeanlist",sbeanlist);
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("viewreport.jsp");
        return mv;
	}
	
}
