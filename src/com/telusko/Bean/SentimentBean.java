package com.telusko.Bean;

public class SentimentBean {

	String username;
	String topic;
	String subtopic;
	String comment;
	
	public SentimentBean(String username, String topic, String subtopic, String comment) {
		super();
		this.username = username;
		this.topic = topic;
		this.subtopic = subtopic;
		this.comment = comment;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getSubtopic() {
		return subtopic;
	}
	public void setSubtopic(String subtopic) {
		this.subtopic = subtopic;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
