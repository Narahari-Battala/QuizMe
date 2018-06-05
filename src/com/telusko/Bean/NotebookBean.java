package com.telusko.Bean;

import java.util.ArrayList;
import java.util.Date;

public class NotebookBean {

	String notebook_name;  
	String username; 
	String content; 
	Date lastupdated;
	int id;
	public Date getLastupdated() {
		return lastupdated;
	}
	public void setLastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public NotebookBean(String notebook_name, String content, Date lastupdated, int id) {
		super();
		this.notebook_name = notebook_name;
		this.content = content;
		this.lastupdated = lastupdated;
		this.id = id;
	}
	public NotebookBean(String notebook_name, String username, String content) {
		super();
		this.notebook_name = notebook_name;
		this.username = username;
		this.content = content;
	}
	
	public String getNotebook_name() {
		return notebook_name;
	}
	public NotebookBean() {
		super();
	}
	public void setNotebook_name(String notebook_name) {
		this.notebook_name = notebook_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	@Override
	public String toString() {
		return "NotebookBean [notebook_name=" + notebook_name + ", username=" + username + ", content=" + content
				+ ", lastupdated=" + lastupdated + ", id=" + id + "]";
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
