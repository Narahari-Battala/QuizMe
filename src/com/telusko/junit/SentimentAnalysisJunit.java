package com.telusko.junit;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.telusko.DAO.SentimentAnalysisDAO;

public class SentimentAnalysisJunit {

	@Test
	public void trainingDataAvailable() throws ClassNotFoundException, SQLException {
		SentimentAnalysisDAO sentimentjunit = new SentimentAnalysisDAO();
		String target = "positive" ;
		if (target.equals("positive")) {
			ResultSet rs = sentimentjunit.goldlabel(target);
			assertEquals(rs.next(), true);
		} else {
			ResultSet rs = sentimentjunit.goldlabel(target);
			assertNotEquals(rs.next(), null);
		}

	}
	
	
}
