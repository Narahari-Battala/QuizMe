package com.telusko.junit;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import com.telusko.DAO.QuestionDAO;

public class QuestionBankJUnit {


		@Test
		public void QuestionShouldBePresent() throws ClassNotFoundException, SQLException {
			QuestionDAO questionjunit = new QuestionDAO();
				ResultSet rs = questionjunit.getResultSet();
				assertNotEquals(rs.next(), false);
			}
		}
