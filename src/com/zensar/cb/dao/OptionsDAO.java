package com.zensar.cb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zensar.cb.entity.Options;
import com.zensar.cb.entity.Questions;
import com.zensar.cb.utility.ConnectionManager;

public class OptionsDAO {

	public Options[] getOptionByID(long questionId) throws SQLException, ClassNotFoundException
	{
		ConnectionManager connectionManager=new ConnectionManager();
		Connection connection=connectionManager.openConnection();
		PreparedStatement preparedStatement =connection.prepareStatement("Select * from options where question_id=?");
		preparedStatement.setLong(1, questionId);
		ResultSet resultSet=preparedStatement.executeQuery();
		resultSet.last();
		int resultSetLength=resultSet.getRow();
		resultSet.beforeFirst();
		Options[] optionIds=new Options[resultSetLength];
		int index=-1;
		while(resultSet.next())
		{
			index++;
			optionIds[index]=new Options();
			optionIds[index].setOptionId(resultSet.getLong("Option_id"));
			optionIds[index].setOptionDescription(resultSet.getString("Option_description"));
			optionIds[index].setOptionIsCorrect(resultSet.getBoolean("is_option_correct"));
			optionIds[index].setQuestionId(resultSet.getLong("question_id"));	
		}
		connectionManager.CloseConnection();
		return optionIds;
	}
	
	public Options[] getCorrectOptionByQuestionId(long questionId) throws SQLException, ClassNotFoundException
	{
		ConnectionManager connectionManager=new ConnectionManager();
		Connection connection=connectionManager.openConnection();
		PreparedStatement preparedStatement =connection.prepareStatement("Select * from options where question_id=? and is_option_correct ='Y'");
		preparedStatement.setLong(1, questionId);
		ResultSet resultSet=preparedStatement.executeQuery();
		resultSet.last();
		int resultSetLength=resultSet.getRow();
		resultSet.beforeFirst();
		Options[] optionIds=new Options[resultSetLength];
		int index=-1;
		while(resultSet.next())
		{
			index++;
			optionIds[index]=new Options();
			optionIds[index].setOptionId(resultSet.getLong("Option_id"));
			optionIds[index].setOptionDescription(resultSet.getString("Option_description"));
			optionIds[index].setOptionIsCorrect(resultSet.getBoolean("is_option_correct"));
			optionIds[index].setQuestionId(resultSet.getLong("question_id"));	
		}
		connectionManager.CloseConnection();
		return optionIds;
	}

	public boolean setOption(Options option,Questions question, long qid) throws SQLException {
		ConnectionManager connectionManager=new ConnectionManager();
		Connection connection=connectionManager.openConnection();
		try{
			PreparedStatement pstmt=connection.prepareStatement("insert into options(Option_description,is_option_correct,question_id) values(?,?,?);");
			pstmt.setString(1, option.getOptionDescription());
			pstmt.setBoolean(2, option.getIsOptionIsCorrect());
			pstmt.setLong(3, qid);
			pstmt.execute();
			pstmt.close();
			connection.close();
		}		
		catch(SQLException e){
			throw e;
		}
		return true;
	}
}