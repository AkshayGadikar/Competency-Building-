package com.zensar.cb.Testers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;

import com.zensar.cb.dao.TopicDAO;
import com.zensar.cb.exceptions.InvalidTestType;
import com.zensar.cb.exceptions.LessQuestionFoundExceptions;
import com.zensar.cb.exceptions.throwInvalidQuestionType;
import com.zensar.cb.services.EvaluationService;
import com.zensar.cb.utility.ConfigurationResuorce;


/**
 * @author mohamadali
 * note this class is only for testing purpose this will be deleted as development of project will complete
 */
public class TesterClass {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, throwInvalidQuestionType, LessQuestionFoundExceptions, InvalidTestType {
		long userId=1;
		long historyId=1;
		TopicDAO topicDAO= new TopicDAO();
		ConfigurationResuorce configurationResuorce=new ConfigurationResuorce();
		
			HashMap<Long, Float> results=new EvaluationService().evaluateCommentedResult(userId, historyId);
			Set<Long> keys=results.keySet();
			for (Long long1 : keys) {
				float percentage =results.get(long1)*100;
				if(percentage<=configurationResuorce.getOneStarCutOff())
				{
					System.out.println(topicDAO.getTopicById(long1).getTopicName());
					System.out.println(configurationResuorce.getOneStarComment());
				}
				else if(percentage <=configurationResuorce.getTwoStarCutOff())
				{
					
				}
				else if(percentage <=configurationResuorce.getThreeStarCutOff())
				{
					
				}
				else if(percentage <=configurationResuorce.getFourStarCutOff())
				{
					
				}
				else
				{
					
				}
			}
	}
}
