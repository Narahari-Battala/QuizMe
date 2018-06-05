package com.telusko.Bean;

import java.sql.Date;

public class ProfileBean {
	
	public String username;
	
	public ProfileBean(String username, String firstname, String lastname, String email, String avgscore,
			Date dateOfUpcomingExam2) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.avgscore = avgscore;
		this.dateOfUpcomingExam = dateOfUpcomingExam2;
	}
	
	public String firstname;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAvgscore() {
		return avgscore;
	}
	public void setAvgscore(String avgscore) {
		this.avgscore = avgscore;
	}
	public Date getDateOfUpcomingExam() {
		return dateOfUpcomingExam;
	}
	public void setDateOfUpcomingExam(Date dateOfUpcomingExam) {
		this.dateOfUpcomingExam = dateOfUpcomingExam;
	}
	public String lastname;
	public String email;
	public String avgscore;
	public Date dateOfUpcomingExam;

	@Override
	public String toString() {
		return "ProfileBean [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", avgscore=" + avgscore + ", dateOfUpcomingExam=" + dateOfUpcomingExam + "]";
	}

}


