package com.telusko.Bean;

public class LeaderBoardBean {
	
	String username;
	String topic;
	double score;
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
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public LeaderBoardBean(String username, String topic, double score) {
		super();
		this.username = username;
		this.topic = topic;
		this.score = score;
	}
	public LeaderBoardBean(String username, double score) {
		super();
		this.username = username;
		this.score = score;
	}
	@Override
	public String toString() {
		return "LeaderBoardBean [username=" + username + ", score=" + score + "]";
	}
	
	
	

}
