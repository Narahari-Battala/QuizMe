package com.telusko.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.telusko.Bean.NotebookBean;
import com.telusko.DAO.NotebookDAO;

public class NotebookService {

	public ArrayList<NotebookBean> viewMyNotes(String uname) throws ClassNotFoundException, SQLException {
        
//		NotebookBean notebean;
		NotebookDAO viewmynote = new NotebookDAO();
		ResultSet rs = viewmynote.myNotebooks(uname);
		ArrayList<NotebookBean> mylistofnotebooks = new ArrayList<NotebookBean>();
		
		while(rs.next()){
			int nid = rs.getInt(1);
			String nbname = rs.getString(2);
			String content = rs.getString(4);
			Date update = rs.getDate(5);
			NotebookBean nb = new NotebookBean(nbname,content,update,nid);
			mylistofnotebooks.add(nb);
		}
		
		return mylistofnotebooks;
//		 return notebean = new NotebookBean(mynotebean.getNotebook_name(),mynotebean.getUsername(),mynotebean.getContent(), mynotebean.getDate_lastupdated(),mylistofnotebooks);
		
		//ResultSet rs2 = viewmynote.viewMyNote(mynotebean);
		
		
	}
	
	
	public String displayNotebook(NotebookBean mynotebean) throws ClassNotFoundException, SQLException {
        
		NotebookBean notebean;
		NotebookDAO displaymynote = new NotebookDAO();
		ResultSet rs = displaymynote.viewMyNoteContent(mynotebean);
		String notebook_content = null;
		while(rs.next()){
			notebook_content= rs.getString(1);
		}
	   
		return notebook_content;
	
		
		
	}

	public void updateNotes(NotebookBean mynotebean) throws ClassNotFoundException, SQLException {    
		//NotebookBean notebean;
		NotebookDAO addnote = new NotebookDAO();
		int rs = addnote.updateNotes(mynotebean);
	}

	
	
	
	public NotebookBean addNewNotebook(NotebookBean mynotebean) throws ClassNotFoundException, SQLException {    
		//NotebookBean notebean;
		NotebookDAO addnote = new NotebookDAO();
		NotebookBean newnote = addnote.addNewNote(mynotebean);
		return newnote;
	}

}
