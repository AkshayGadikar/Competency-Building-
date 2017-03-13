package com.zensar.cb.services;

import java.sql.SQLException;

import com.zensar.cb.dao.QuestionsDAO;
import com.zensar.cb.dao.TestDAO;
import com.zensar.cb.dao.TopicDAO;
import com.zensar.cb.entity.Options;
import com.zensar.cb.entity.Questions;
import com.zensar.cb.entity.SubjectiveAnswers;
import com.zensar.cb.entity.Test;
import com.zensar.cb.entity.Topic;
import com.zensar.cb.entity.Users;
import com.zensar.cb.exceptions.DataAccessException;

	public class AdminService {
		
	public boolean createTopic(Topic topic)   { 
			try {
				new TopicDAO().setTopic(topic);
			} catch (SQLException e) {		
				e.printStackTrace();
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
		return true;
	}

	public boolean createQuestion(Questions question, Users user,
			Options option, SubjectiveAnswers answer) throws SQLException,
			ClassNotFoundException {
		try {
			new QuestionsDAO().setQuestion(question, user, option, answer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean createTest(Test test) throws Exception {
		try{
		new TestDAO().setTest(test);
		}
		catch (SQLException e) {}
		catch(ClassNotFoundException e){}
		
		return true;
	}
	
}