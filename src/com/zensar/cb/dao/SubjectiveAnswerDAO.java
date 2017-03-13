package com.zensar.cb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zensar.cb.entity.Questions;
import com.zensar.cb.entity.SubjectiveAnswers;
import com.zensar.cb.utility.ConnectionManager;

public class SubjectiveAnswerDAO {
	
	public boolean setAnswer(Questions question, SubjectiveAnswers answer,long qid) throws SQLException {
		
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();
		try{
			PreparedStatement pstmt= connection.prepareStatement("insert into answer(question_Id,answer) values(?,?);");
			pstmt.setLong(1, qid);
			pstmt.setString(2, answer.getAnswer());
			pstmt.execute();
			pstmt.close();
			connection.close();
		}
		catch(SQLException e){
			throw e;}
		return true;
	}
}
