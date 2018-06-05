package com.telusko.Bean;

import java.sql.Timestamp;

public class ExamBean {
	
	@Override
	public String toString() {
		return "ExamBean [exam_topic=" + exam_topic + ", capacity=" + capacity + ", registered=" + registered
				+ ", duration=" + duration + ", exam_time=" + exam_time + "]";
	}
	String exam_topic;
	int exam_id;
	int capacity;
	int registered;
	int duration;
	Timestamp exam_time;
	public String getExam_topic() {
		return exam_topic;
	}
	public void setExam_topic(String exam_topic) {
		this.exam_topic = exam_topic;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getRegistered() {
		return registered;
	}
	public void setRegistered(int registered) {
		this.registered = registered;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Timestamp getExam_time() {
		return exam_time;
	}
	public void setExam_time(Timestamp exam_time) {
		this.exam_time = exam_time;
	}
	
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	public ExamBean(String exam_topic, int capacity, int registered, int duration, Timestamp exam_time) {
		super();
		this.exam_topic = exam_topic;
		this.capacity = capacity;
		this.registered = registered;
		this.duration = duration;
		this.exam_time = exam_time;
	}
	
}
