package com.telusko.Bean;

public class AnalysisBean {

	String topic;
	String predicted_label;
	int count;
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getPredicted_label() {
		return predicted_label;
	}
	public void setPredicted_label(String predicted_label) {
		this.predicted_label = predicted_label;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public AnalysisBean(String topic, String predicted_label, int count) {
		super();
		this.topic = topic;
		this.predicted_label = predicted_label;
		this.count = count;
	}
	

}
