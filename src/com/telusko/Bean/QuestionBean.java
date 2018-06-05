package com.telusko.Bean;

import java.util.ArrayList;

public class QuestionBean {

	String question;
	String answer;
	String topic;
	String subtopic;
	int q_level; 
	int questionid;
	ArrayList<String> options;
	
	public int getQ_level() {
		return q_level;
	}

	public void setQ_level(int q_level) {
		this.q_level = q_level;
	}




	@Override
	public String toString() {
		return "QuestionBean [question=" + question + ", answer=" + answer + ", topic=" + topic + ", subtopic="
				+ subtopic + ", q_level=" + q_level + ", questionid=" + questionid + ", options=" + options + "]";
	}
	
	
	public QuestionBean(String question, String answer, String topic, String subtopic,int questionid, int q_level, ArrayList<String> options) {
		super();
		this.question = question;
		this.answer = answer;
		this.topic = topic;
		this.subtopic = subtopic;
		this.questionid=questionid;
		this.q_level=q_level;
		this.options=options;
	}
	
	public QuestionBean(String question, String answer, String topic, String subtopic, int q_level, ArrayList<String> options) {
		super();
		this.question = question;
		this.answer = answer;
		this.topic = topic;
		this.subtopic = subtopic;
		this.q_level=q_level;
		this.options=options;
	}
	
	
/*    int  q_id = rs.getInt(1);
    String q_details = rs.getString(2);
    String q_answer = rs.getString(3);
    String q_topic = rs.getString(4);
    String q_subtopic = rs.getString(5);
    String level = rs.getString(6);*/
	
	public QuestionBean(int questionid, String question, String topic, String subtopic, int q_level) {
		super();
		this.questionid=questionid;
		this.question = question;
		this.topic = topic;
		this.subtopic = subtopic;
		this.q_level=q_level;
	}
	
	
	public ArrayList<String> getOptions() {
		return options;
	}




	public void setOptions(ArrayList<String> options) {
		this.options = options;
	}




	public int getQuestionid() {
		return questionid;
	}


	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}


	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
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
	
	
	
}
