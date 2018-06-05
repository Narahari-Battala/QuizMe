package com.telusko;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.Bean.NotebookBean;
import com.telusko.Bean.SentimentBean;
import com.telusko.service.NotebookService;
import com.telusko.service.SentimentAnalysisService;
@Controller
public class NotebookController {

	@RequestMapping("/displaypreviousnotes")
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
	
	@RequestMapping("/savenotebook")
	public ModelAndView saveNotebook( HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		
		String content = request.getParameter("content");
		System.out.println("Content is"+content);
		HttpSession session = request.getSession();
		ArrayList<NotebookBean> noteslist = (ArrayList<NotebookBean>) session.getAttribute("noteslist");
        int id = (Integer) session.getAttribute("id");
		NotebookBean nb =  new NotebookBean();
		for ( int i=0;i<noteslist.size();i++) {
			if(id == noteslist.get(i).getId()) {
			 nb =  noteslist.get(i);
				break;
			}
		}
        //NotebookBean nb = noteslist.get(id);
        System.out.println("prev Content is"+nb.getContent());
        noteslist.remove(nb);
        nb.setContent(content);
        NotebookService mynote = new NotebookService();
		mynote.updateNotes(nb);
        noteslist.add(nb);
        session.setAttribute("noteslist",noteslist);
        session.setAttribute("id",id);
//		NotebookBean mynotebean;
//		
////		mynotebean = new NotebookBean(notebook_name,username,content, date_lastupdated);
//		
//		NotebookService mynote = new NotebookService();
//		String notebook_content = mynote.displayNotebook (mynotebean);
		
		
		 ModelAndView mv = new ModelAndView();
		 
	     mv.setViewName("userhome.jsp");
         return mv;
	}
	
	
	@RequestMapping("/addnotebook")
	public ModelAndView addContentsToNotebook( HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("currentSessionUsername");
		String nbname = request.getParameter("nbname");
		String content = request.getParameter("content");
		
		NotebookBean mynotebean;
		mynotebean = new NotebookBean(nbname,uname,content);
		System.out.println(mynotebean.toString());
		NotebookService mynote = new NotebookService();
		NotebookBean newnote= mynote.addNewNotebook (mynotebean);
		ArrayList<NotebookBean> noteslist = (ArrayList<NotebookBean>) session.getAttribute("noteslist");
		noteslist.add(newnote);
		session.setAttribute("noteslist",noteslist);
		request.setAttribute("noteslist",noteslist);
		 ModelAndView mv = new ModelAndView();
	     mv.setViewName("mypreviouslist.jsp");
         return mv;
	}
	
	
	@RequestMapping("/notesaction")
	public ModelAndView noteslistAction( HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
		ModelAndView mv = new ModelAndView();
	     
		String buttonClicked = request.getParameter("notes");
		if("View Content".equals(buttonClicked)) {
			String sid = request.getParameter("id");
			int id = Integer.valueOf(sid);
			//id = id-1;
			System.out.println("id selected is"+id);
			HttpSession session = request.getSession();
			ArrayList<NotebookBean> noteslist = (ArrayList<NotebookBean>) session.getAttribute("noteslist");
			NotebookBean nb =  new NotebookBean();
			for ( int i=0;i<noteslist.size();i++) {
				if(id == noteslist.get(i).getId()) {
				 nb =  noteslist.get(i);
					break;
				}
			}
		
			String content = nb.getContent();
			String nbname = nb.getNotebook_name();
			System.out.println("Content is "+content+" nbmae is: "+nbname);
			session.setAttribute("currentnb",nb);
			session.setAttribute("id",id);
			request.setAttribute("nbname", nbname);
			request.setAttribute("content", content);
			mv.setViewName("editnotebook.jsp");	
		}
			else if("Add New Notebook".equals(buttonClicked)) {
				mv.setViewName("addnote.jsp");
			
		}
		  return mv;
	}
	
}
