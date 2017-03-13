
package com.zensar.cb.services;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;

import com.zensar.cb.dao.AskedQuestionDAO;
import com.zensar.cb.dao.HistoryDAO;
import com.zensar.cb.dao.OngoingTestDAO;
import com.zensar.cb.dao.OptionsDAO;
import com.zensar.cb.dao.QuestionsDAO;
import com.zensar.cb.dao.TestDAO;
import com.zensar.cb.dao.TopicDAO;
import com.zensar.cb.entity.History;
import com.zensar.cb.entity.Options;
import com.zensar.cb.entity.Questions;
import com.zensar.cb.entity.Test;
import com.zensar.cb.entity.Topic;
import com.zensar.cb.exceptions.InvalidTestType;
import com.zensar.cb.utility.ConfigurationResuorce;

public class EvaluationService {
	public EvaluationService() {
		// TODO Auto-generated constructor stub
		// dummy.
	}
	
	public void evaluateResult(long userId,long testId) throws ClassNotFoundException, SQLException, InvalidTestType
	{
		TestDAO testDAO=new TestDAO();
		Test test=testDAO.getTestById(testId);
		OngoingTestDAO ongoingTestDAO=new OngoingTestDAO();
		QuestionsDAO questionsDAO=new QuestionsDAO();
		if(test.getTestType()==1)							//objective
		{
			long[] topicIds=testDAO.getTestById(testId).getTestTopics();
			Arrays.sort(topicIds);
			testDAO.setTest(test);
			int[] marksPerTopic=new int[topicIds.length];
			long[] askedQuestions=ongoingTestDAO.getOngoingTestQuestionsId(userId, testId);
			for(int index1=0;index1<askedQuestions.length;index1++)
			{
				if(iscorrectAnswer(askedQuestions[index1], userId, testId))
				{
					long topicId=questionsDAO.getQuestionById(askedQuestions[index1]).getQuestionTopicId();
					for(int index2=0;index2<topicIds.length;index2++)
					{
						if(topicIds[index2]==topicId)
						{
							marksPerTopic[index2]++;
							break;
						}
					}
				}
			}
			HistoryDAO historyDAO=new HistoryDAO();
			History history=new History();
			history.setHistoryRemark("not commented yet");
			history.setHistoryTestId(testId);
			history.setHistoryUserId(userId);
			history.setResultPerTopics(marksPerTopic);
			historyDAO.addHistory(history);
			AskedQuestionDAO askedQuestionDAO=new AskedQuestionDAO();
			for (long l : askedQuestions) {
				askedQuestionDAO.addQuestions(l,userId);
			}
			ongoingTestDAO.removeOngoingTest(userId, testId);
		}
		else
		{
			System.out.println("subjective type question striked");
			throw new InvalidTestType();
		}
	}
	private boolean iscorrectAnswer(long questionId,long userId,long testId) throws ClassNotFoundException, SQLException
	{
		QuestionsDAO questionsDAO=new QuestionsDAO();
		OngoingTestDAO ongoingTestDAO=new OngoingTestDAO();
		Questions questions=questionsDAO.getQuestionById(questionId);
		OptionsDAO optionsDAO=new OptionsDAO();
		if(questions.getQuestionType()==1)							//objective with single answer
		{
			long[] markedAnswers=ongoingTestDAO.getMarkedAnswer(userId, testId, questionId);
			if(markedAnswers==null)
				return false;
			Options[] options=optionsDAO.getCorrectOptionByQuestionId(questionId);
			if(options[0].getOptionId()==markedAnswers[0])
			{
				return true;
			}
			else return false;
		}
		if(questions.getQuestionType()==2)							//objective with multiple answers
		{
			long[] markedAnswers=ongoingTestDAO.getMarkedAnswer(userId, testId, questionId);
			if(markedAnswers==null)
				return false;
			Options[] options=optionsDAO.getCorrectOptionByQuestionId(questionId);
			long optionsId[]=new long[options.length]; 
			for(int index=0;index<options.length;index++)
			{
				optionsId[index]=options[index].getOptionId();
			}
			System.out.println("comparing option length: "+optionsId.length+":"+markedAnswers.length);
			if(optionsId.length==markedAnswers.length)
			{
				return comparAnswers(markedAnswers, optionsId);
			}
			else return false;
		}
		return false;
	}
	private boolean comparAnswers(long markedAnswers[],long options[])
	{
		Arrays.sort(markedAnswers);
		Arrays.sort(options);
		boolean result=Arrays.toString(markedAnswers).equals(Arrays.toString(options));		
		return result;
	}
	public HashMap<Long, Float> evaluateCommentedResult(long userId,long historyId) throws ClassNotFoundException, SQLException
	{
		HashMap<Long, Float> results=new HashMap<Long,Float>();
		TestDAO testDAO=new TestDAO();
		HistoryDAO historyDAO=new HistoryDAO();
		History history=historyDAO.getHistory(historyId);
		Test test=testDAO.getTestById(history.getHistoryTestId());
		long testTopicsIId[]=test.getTestTopics();
		int testQuestionsPerTopic[]=test.getNumberOfQuestionPerTopic();
		int marksscored[]=history.getResultPerTopics();
		for(int index=0;index<testTopicsIId.length;index++)
		{
			results.put((Long)testTopicsIId[index], (Float)(float)( marksscored[index] / testQuestionsPerTopic[index]));
		}
		return results;
	}
}