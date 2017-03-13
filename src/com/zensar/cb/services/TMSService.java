package com.zensar.cb.services;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;

import org.json.simple.JSONObject;

import com.zensar.cb.dao.OngoingTestDAO;
import com.zensar.cb.dao.OptionsDAO;
import com.zensar.cb.dao.QuestionsDAO;
import com.zensar.cb.dao.TestDAO;
import com.zensar.cb.entity.Options;
import com.zensar.cb.entity.QuestionPack;
import com.zensar.cb.entity.Questions;
import com.zensar.cb.entity.Test;
import com.zensar.cb.exceptions.LessQuestionFoundExceptions;
import com.zensar.cb.exceptions.throwInvalidQuestionType;

/**
 * 
 * @author mohamadali
 *
 */
public class TMSService {

	@SuppressWarnings("unchecked")
	public String resumeTest(long userId,long testId) throws ClassNotFoundException, SQLException, throwInvalidQuestionType, LessQuestionFoundExceptions
	{
		OngoingTestDAO ongoingTestDAO=new OngoingTestDAO();
		long questionIdlist[]=ongoingTestDAO.getOngoingTestQuestionsId(userId, testId);
		shuffleArray(questionIdlist);
		QuestionPack[] questionPacks=getPackedQuestion(questionIdlist);
		String result[]=new String[questionPacks.length];
		for(int index2=0;index2<questionPacks.length;index2++)
		{
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("questionId", questionPacks[index2].getQuestion().getQuestionId());
			jsonObject.put("questionStatement",questionPacks[index2].getQuestion().getQuestionStatement());
			jsonObject.put("questionType",questionPacks[index2].getQuestion().getQuestionType());
			OptionsDAO optionsDAO=new OptionsDAO();
			if(questionPacks[0].getQuestion().getQuestionType()!=3)
			{
				Options[] options=optionsDAO.getOptionByID(questionPacks[index2].getQuestion().getQuestionId());
					jsonObject.put("numberOfOptions", options.length);
					for(int index1=0;index1<options.length;index1++)
					{
						jsonObject.put("optionId"+index1, options[index1].getOptionId());
						jsonObject.put("optionstatement"+index1, options[index1].getOptionDescription());
					}
			}
			result[index2]=jsonObject.toString();
		}
		System.out.println(Arrays.toString(result));
		return Arrays.toString(result).replace("\"", "\\\"").replace("{", "\"{").replace("}", "}\"");	
	}
	
	
	public boolean removeTestOngoingTest(long userId, long testId) throws ClassNotFoundException, SQLException
	{//TODO this function needs to be written
		//Akshay
		OngoingTestDAO ongoingtestDAO = new OngoingTestDAO();
	    ongoingtestDAO.removeOngoingTest(userId, testId);
		
		return true;
	}
	
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	public boolean finishTest(long userId,long testId) throws ClassNotFoundException, SQLException
	{
		//TODO this function needs to be written
		//Chaitanya		
		return false;
	}
	/**
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public boolean saveAnswersSCQ(long ongoingTestUserId, long ongoingTestTestId, long ongoingTestQuestionId,long ongoingTestMarkedAnswers[]) throws ClassNotFoundException, SQLException
	{
		//TODO this function needs to be written
		// written by Akshay
		//removed bug by Mohamadali
		System.out.println(""+ongoingTestUserId+":"+ongoingTestTestId+":"+ongoingTestQuestionId+"/"+ ongoingTestMarkedAnswers);
		OngoingTestDAO ongoingTestDAO=new OngoingTestDAO();
		ongoingTestDAO.updateAnswersTest(ongoingTestUserId, ongoingTestTestId, ongoingTestQuestionId, ongoingTestMarkedAnswers);
		return true;
	}
	public boolean saveAnswersSub(long ongoingTestUserId, long ongoingTestTestId, long ongoingTestQuestionId,String ongoingTestMarkedAnswers) throws ClassNotFoundException, SQLException
	{
		//TODO this function needs to be written
		//written by Mohamadali
		System.out.println(""+ongoingTestUserId+":"+ongoingTestTestId+":"+ongoingTestQuestionId+"/"+ ongoingTestMarkedAnswers);
		OngoingTestDAO ongoingTestDAO=new OngoingTestDAO();
		ongoingTestDAO.updateAnswersTestSub(ongoingTestUserId, ongoingTestTestId, ongoingTestQuestionId, ongoingTestMarkedAnswers);
		return true;
	}
	/**
	 * 
	 * @param userId
	 * @param testId
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws throwInvalidQuestionType 
	 * @throws LessQuestionFoundExceptions 
	 */
	@SuppressWarnings("unchecked")
	public String startTest(long userId,long testId) throws ClassNotFoundException, SQLException, throwInvalidQuestionType, LessQuestionFoundExceptions
	{
		TestDAO testDAO=new TestDAO();
		Test test=testDAO.getTestById(testId);
		long questionIdlist[]=generateQuestionSet(userId,test);
		shuffleArray(questionIdlist);
		QuestionPack[] questionPacks=getPackedQuestion(questionIdlist);
		String result[]=new String[questionPacks.length];
		for(int index2=0;index2<questionPacks.length;index2++)
		{
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("questionId", questionPacks[index2].getQuestion().getQuestionId());
			jsonObject.put("questionStatement",questionPacks[index2].getQuestion().getQuestionStatement());
			jsonObject.put("questionType",questionPacks[index2].getQuestion().getQuestionType());
			OptionsDAO optionsDAO=new OptionsDAO();
			if(questionPacks[0].getQuestion().getQuestionType()!=3)
			{
				Options[] options=optionsDAO.getOptionByID(questionPacks[index2].getQuestion().getQuestionId());
					jsonObject.put("numberOfOptions", options.length);
					for(int index1=0;index1<options.length;index1++)
					{
						jsonObject.put("optionId"+index1, options[index1].getOptionId());
						jsonObject.put("optionstatement"+index1, options[index1].getOptionDescription());
					}
			}
			result[index2]=jsonObject.toString();
		}
		addQuestionsInOngoingTest(userId, testId, questionIdlist);
		return Arrays.toString(result).replace("\"", "\\\"").replace("{", "\"{").replace("}", "}\"");
			
	}
	/**
	 * @author mohamadali
	 * @param ar
	 * Implementing Fisher–Yates shuffle
	 */
	 private void shuffleArray(long[] ar)
	  {
	    Random rnd = new Random();
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      long a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	  }
	
	private QuestionPack[] getPackedQuestion(long questionId[]) throws ClassNotFoundException, SQLException
	{
		QuestionsDAO questionsDAO = new QuestionsDAO();
		QuestionPack questionPack[]=new QuestionPack[questionId.length];
		OptionsDAO optionsDAO=new OptionsDAO();
		
		for(int i=0;i<questionId.length;i++)
		{
			
			Questions questions=questionsDAO.getQuestionById(questionId[i]);
			questionPack[i]=new QuestionPack();
			questionPack[i].setQuestion(questions);
			if(questions.getQuestionType()!=3)
			{
				Options[] options=optionsDAO.getOptionByID(questionId[i]);
				questionPack[i].setOption(options);
			}
		}
		return questionPack;
	}
	
	private boolean addQuestionsInOngoingTest(long userId, long testId, long questionIdlist[]) throws ClassNotFoundException, SQLException
	{
		
		//Akshay
		//TODO This function needs to be written
		OngoingTestDAO ongoingtestDAO = new OngoingTestDAO(); 
		ongoingtestDAO.addquestionsinTest(userId, testId, questionIdlist);
		return true;
	}
	/**
	 * This class will provide set of question depending on it two parameters
	 * @author Mohamadali
	 * @param userID
	 * @param test
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws throwInvalidQuestionType 
	 * @throws LessQuestionFoundExceptions 
	 */
	private long[] generateQuestionSet(long userId,Test test) throws ClassNotFoundException, SQLException, throwInvalidQuestionType, LessQuestionFoundExceptions
	{
		//TODO
		/*
		 * This module  return list of all question depending on test object and userId
		 */
		long topics[]=test.getTestTopics();
		int numberOfQuestionsperTopic[]=test.getNumberOfQuestionPerTopic();
		int sum=0;
		for(int i=0;i<topics.length;i++)
		{
			sum+=numberOfQuestionsperTopic[i];
		}		
		long finalizedQuestionsList[]=new long[sum];
		int presentCount=0;
		for(int index=0;index<topics.length;index++)
		{
			long temp[]=getQuestionsPerTopic(topics[index], userId, test.getTestComplexityLevel(), numberOfQuestionsperTopic[index], test.getTestType());
			System.out.println(Arrays.toString(temp));
			for (long l : temp) {
				finalizedQuestionsList[presentCount++]=l;
			}
		}
		return finalizedQuestionsList;
	}
	
	/**
	 * @author Mohamadali
	 * @param topicId
	 * @param userId
	 * @param complextityLevel
	 * @param numberOfQuestions
	 * @param typeOfQuestions    1=Objective(MCQ & SCQ)       2=Subjective
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws throwInvalidQuestionType 
	 * @throws LessQuestionFoundExceptions 
	 */
	private long[] getQuestionsPerTopic(long topicId,long userId,int complextityLevel,int numberOfQuestions,int typeOfQuestions) throws ClassNotFoundException, SQLException, throwInvalidQuestionType, LessQuestionFoundExceptions
	{
		switch(typeOfQuestions)
		{
			case 1:	//this case is for MCQ and SCQ
				QuestionsDAO questionsDAO=new QuestionsDAO();
				long tempQuestionList[]=questionsDAO.getNonAskedQuestionsIdObjective(userId, topicId, complextityLevel);
				if(tempQuestionList.length< numberOfQuestions)
				{
					throw new LessQuestionFoundExceptions(topicId);
				}
				long confirmQuestions[]=new long[numberOfQuestions];
				for(int index=0;index<numberOfQuestions;index++)
				{
					confirmQuestions[index]=tempQuestionList[index];
				}
				return confirmQuestions;
			case 2:	//this is case for subjective
				QuestionsDAO questionsDAO1=new QuestionsDAO();
				long tempQuestionList1[]=questionsDAO1.getNonAskedQuestionsIdSubjective(userId, topicId, complextityLevel);
				if(tempQuestionList1.length< numberOfQuestions)
				{
					throw new LessQuestionFoundExceptions(topicId);
				}
				long confirmQuestions1[]=new long[numberOfQuestions];
				for(int index=0;index<numberOfQuestions;index++)
				{
					confirmQuestions1[index]=tempQuestionList1[index];
				}
				return confirmQuestions1;
			default:throw new throwInvalidQuestionType(typeOfQuestions);
		}
	}
}
