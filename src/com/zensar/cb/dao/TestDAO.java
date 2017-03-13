package com.zensar.cb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zensar.cb.entity.Test;
import com.zensar.cb.utility.ConnectionManager;
import com.zensar.cb.utility.StringParser;

/*
 * TODO This class will be completed as soon as class diagram is prepared
 */
public class TestDAO {
	public Test getTestById(long testId) throws SQLException, ClassNotFoundException
	{
	ConnectionManager connectionManager=new ConnectionManager();	
	Connection connection=connectionManager.openConnection();
	PreparedStatement preparedStatement =connection.prepareStatement("Select * from Test where Test_id=?");
	preparedStatement.setLong(1, testId);
	ResultSet resultSet=preparedStatement.executeQuery();
	if(resultSet.next())
	{
		Test test=new Test();
		test.setTestId(testId);
		test.setTestType(resultSet.getInt("Test_type"));
		test.setTestCreatedOn(resultSet.getDate("Test_createdOn"));
		test.setTestCreatedBy(resultSet.getInt("Test_createdBy"));
		test.setTestTime(resultSet.getInt("Test_time"));
		test.setTestComplexityLevel(resultSet.getInt("Test_complexityLevel"));
		test.setTestDescription(resultSet.getString("Test_description"));
		test.setNumberOfQuestionPerTopic(StringParser.ReleaseintoArrayOfint(";", resultSet.getString("Test_numberOfQuestionsPerTopic")));
		test.setTestTopics(StringParser.ReleaseintoArrayOfLongs(";", resultSet.getString("Test_topics")));
		return test;
	}
	connectionManager.CloseConnection();
	return null;

	}
	
	public boolean setTest(Test test) throws SQLException, ClassNotFoundException
	{
		try{
		ConnectionManager connectionManager=new ConnectionManager();
		Connection connection=connectionManager.openConnection();
		PreparedStatement pstmt =connection.prepareStatement("insert into Test(Test_id,Test_type,Test_description,Test_numberOfQuestionsPerTopic,Test_topics,Test_createdOn,Test_createdBy,Test_time,Test_complexityLevel ) values (null,?,?,?,?,?,?,?,?)");
		pstmt.setInt(1, test.getTestType());
		pstmt.setString(2, test.getTestDescription());
		pstmt.setString(3, StringParser.Bindint(";",test.getNumberOfQuestionPerTopic()));
		pstmt.setString(4, StringParser.BindLong(";", test.getTestTopics()));
		pstmt.setDate(5, test.getTestCreatedOn());
		pstmt.setLong(6, test.getTestCreatedBy());
		pstmt.setInt(7, test.getTestTime());
		pstmt.setInt(8, test.getTestComplexityLevel());
		pstmt.execute();
		connectionManager.CloseConnection();
		pstmt.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
		throw new SQLException();
	}
	return true;	
	}
}
