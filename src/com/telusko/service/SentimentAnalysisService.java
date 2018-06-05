package com.telusko.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.telusko.Bean.AnalysisBean;
import com.telusko.Bean.SentimentBean;
import com.telusko.DAO.SentimentAnalysisDAO;

public class SentimentAnalysisService {

	static int total_pos_doc;
	static int total_neg_doc;
	public void commentClassifier(SentimentBean sentiment) throws ClassNotFoundException, SQLException{
		
		ArrayList<Double> positiveprob;
		ArrayList<Double> negativeprob;
		String usercomment= sentiment.getComment();
		
		positiveprob = getPositiveClassProb(usercomment);
		negativeprob = getNegativeClassProb(usercomment);
//		System.out.println("pos prob size: "+positiveprob.size());
//		for ( int x =0;x<positiveprob.size();x++) {
//			System.out.println("pos prob: "+positiveprob.get(x));
//		}
//		
//		
//		System.out.println("neg prob size: "+negativeprob.size());
//		for ( int x =0;x<negativeprob.size();x++) {
//			System.out.println("pos prob: "+negativeprob.get(x));
//		}
		double positiveclass =1;
		double negativeclass =1;
		for(int p=0;p<positiveprob.size();p++){
			positiveclass=positiveclass*positiveprob.get(p);
			negativeclass=negativeclass*negativeprob.get(p);
		}
		String predictedlabel;
		if((total_pos_doc*positiveclass)<(total_neg_doc*negativeclass)){
			
			predictedlabel = "negative";
		}else{
			predictedlabel = "positive";
		}
		
		
		SentimentAnalysisDAO SentimentAnalysis = new SentimentAnalysisDAO();
		SentimentAnalysis.insertSentiment(sentiment,predictedlabel);
			
		}
		
 
	
	

	private ArrayList<Double> getPositiveClassProb(String usercomment) throws ClassNotFoundException, SQLException {
		ArrayList<Double> positiveprob = new ArrayList<Double>();
		int count=0;
		total_pos_doc=0;
		SentimentAnalysisDAO SentimentAnalysis = new SentimentAnalysisDAO();
		ResultSet rs = SentimentAnalysis.goldlabel("positive");
		ArrayList positivelist = new ArrayList();
		while(rs.next()){
			total_pos_doc++;
			String goldcomment = rs.getString(2);
			String[] tokens = goldcomment.split(" ");
			
			for(int i=0;i<tokens.length;i++){	 
			String goldtoken = tokens[i];
			positivelist.add(goldtoken);
			}
		}
		
		String[] test_tokens = usercomment.split(" ");
	 
		for(int t = 0;t<test_tokens.length;t++){
		        count=1;
			for(int i=0;i<positivelist.size();i++){
                 if(positivelist.get(i).equals(test_tokens[t])){
				count++;
			}
		}
			positiveprob.add ((((double)count)/positivelist.size()));
		}
		
		return positiveprob;
	}

	private ArrayList<Double> getNegativeClassProb(String usercomment) throws ClassNotFoundException, SQLException {
		ArrayList<Double> negativeprob = new ArrayList<Double>();
		int count=1;
		total_neg_doc=0;
		SentimentAnalysisDAO SentimentAnalysis = new SentimentAnalysisDAO();
		ResultSet rs = SentimentAnalysis.goldlabel("negative");
		ArrayList negativelist = new ArrayList();
		while(rs.next()){
			total_neg_doc++;
			String goldcomment = rs.getString(2);
			String[] tokens = goldcomment.split(" ");
			
			for(int i=0;i<tokens.length;i++){	 
			String goldtoken = tokens[i];
			negativelist.add(goldtoken);
			}
		}
		
		String[] test_tokens = usercomment.split(" ");
	 
		for(int t = 0;t<test_tokens.length;t++){
			count =1;
			for(int i=0;i<negativelist.size();i++){
                 if(negativelist.get(i).equals(test_tokens[t])){
				count++;
			}
		}
			negativeprob.add ((((double)count)/negativelist.size()));
		}
		return negativeprob;
	}
	
		
public ArrayList<AnalysisBean> viewSentiments() throws ClassNotFoundException, SQLException{
		ResultSet rs;	
		SentimentAnalysisDAO SentimentAnalysis = new SentimentAnalysisDAO();
		rs = SentimentAnalysis.viewSentiment();
		AnalysisBean ab;
		ArrayList<AnalysisBean> ablist = new ArrayList<AnalysisBean>(); 
		while(rs.next()){
			String label= rs.getString(1);
			String topic= rs.getString(2);
			int count= rs.getInt(3);
			ab = new AnalysisBean(topic,label,count);
			ablist.add(ab);
			
			}
		
		return ablist;
		}
public ArrayList<SentimentBean> viewSentimentsReport(String ntopic, String plabel) throws ClassNotFoundException, SQLException{
	ResultSet rs;	
	SentimentAnalysisDAO SentimentAnalysis = new SentimentAnalysisDAO();
	rs = SentimentAnalysis.viewSentimentReport(ntopic,plabel);
	SentimentBean sb;
	ArrayList<SentimentBean> sbeanlist = new ArrayList<SentimentBean>(); 
	while(rs.next()){
		String uname= rs.getString(1);
		String topic= rs.getString(2);
		String subtopic= rs.getString(3);
		String comment= rs.getString(4);
		//String label= rs.getString(5);
		sb = new SentimentBean(uname,topic,subtopic,comment);
		sbeanlist.add(sb);
		
		}
	
	return sbeanlist;
	}
		
}

