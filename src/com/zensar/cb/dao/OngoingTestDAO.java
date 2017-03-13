package com.zensar.cb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zensar.cb.utility.ConnectionManager;
import com.zensar.cb.utility.StringParser;

/*
 * TODO This class will be completed as soon as class diagram is prepared
 */
public class OngoingTestDAO {
	
	public long[] getOngoingTest(long userId) throws ClassNotFoundException, SQLException
	{
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();
		//TODO change query to select distinct TestId
		PreparedStatement preparedStatement = connection.prepareStatement("Select DISTINCT(OngoingTest_test_id) from OngoingTest where OngoingTest_user_id=?");
		preparedStatement.setLong(1, userId);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.last();
		int resultSetLength = resultSet.getRow();
		resultSet.beforeFirst();
		long[] ongoingTests=new long[resultSetLength];
		int index = -1;
		while (resultSet.next()) {
			index++;
			ongoingTests[index]=resultSet.getLong("OngoingTest_test_id");
		}
		connectionManager.CloseConnection();
		return ongoingTests;
	}
	
	public long[] getOngoingTestQuestionsId(long userId,long testID) throws ClassNotFoundException, SQLException
	{
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();
		//TODO change query to select distinct TestId
		PreparedStatement preparedStatement = connection.prepareStatement("Select OngoingTest_questionId from OngoingTest where (OngoingTest_test_id=? and OngoingTest_user_id=?)");
		preparedStatement.setLong(1, testID);
		preparedStatement.setLong(2, userId);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.last();
		int resultSetLength = resultSet.getRow();
		resultSet.beforeFirst();
		long[] ongoingTests=new long[resultSetLength];
		int index = -1;
		while (resultSet.next()) {
			index++;
			ongoingTests[index]=resultSet.getLong("OngoingTest_questionId");
		}
		connectionManager.CloseConnection();
		return ongoingTests;
	}
	
	public void updateAnswersTest(long ongoingTestUserId, long ongoingTestTestId, long ongoingTestQuestionId,long ongoingTestMarkedAnswers[]) throws SQLException, ClassNotFoundException
	{
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("update OngoingTest set OngoingTest_MarkedAnswers=?  where (OngoingTest_user_id=? and OngoingTest_test_id=? and OngoingTest_questionId=?)");
		preparedStatement.setString(1, StringParser.BindLong(";", ongoingTestMarkedAnswers));
		preparedStatement.setLong(2, ongoingTestUserId);
		preparedStatement.setLong(3, ongoingTestTestId);
		preparedStatement.setLong(4, ongoingTestQuestionId);
		preparedStatement.execute();
		connectionManager.CloseConnection();
	}
	public void updateAnswersTestSub(long ongoingTestUserId, long ongoingTestTestId, long ongoingTestQuestionId,String ongoingTestMarkedAnswers) throws SQLException, ClassNotFoundException
	{
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("update OngoingTest set OngoingTest_MarkedAnswers=?  where (OngoingTest_user_id=? and OngoingTest_test_id=? and OngoingTest_questionId=?)");
		preparedStatement.setString(1,ongoingTestMarkedAnswers);
		preparedStatement.setLong(2, ongoingTestUserId);
		preparedStatement.setLong(3, ongoingTestTestId);
		preparedStatement.setLong(4, ongoingTestQuestionId);
		preparedStatement.execute();
		connectionManager.CloseConnection();
	}
	public void removeOngoingTest(long userId,long testId) throws ClassNotFoundException, SQLException
	{
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("delete from OngoingTest where OngoingTest_user_id=? and OngoingTest_test_id=?");
		preparedStatement.setLong(1, userId);
		preparedStatement.setLong(2, testId);
		preparedStatement.execute();
		connectionManager.CloseConnection();
	}
	public void addquestionsinTest(long userId, long testId, long questionIdlist[]) throws ClassNotFoundException, SQLException
	{
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();
		for(int i=0; i<questionIdlist.length;i++)
		{
			PreparedStatement preparedStatement = connection.prepareStatement("insert into OngoingTest(OngoingTest_user_id,OngoingTest_test_id,OngoingTest_questionId,OngoingTest_TimeStamp) values(?,?,?,Now())");
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, testId);
			preparedStatement.setLong(3, questionIdlist[i]);
			preparedStatement.execute();
		}
		connectionManager.CloseConnection();
	}
	public long[] getMarkedAnswer(long userId,long testId,long questionId) throws SQLException
	{
		ConnectionManager connectionManager=new ConnectionManager();
		Connection connection=connectionManager.openConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("select OngoingTest_MarkedAnswers from OngoingTest where OngoingTest_user_id=? and OngoingTest_test_id=? and OngoingTest_questionId=?");
		preparedStatement.setLong(1, userId);
		preparedStatement.setLong(2, testId);
		preparedStatement.setLong(3, questionId);
		ResultSet resultSet=preparedStatement.executeQuery();
		long[] markedAnswers=null;
		if(resultSet.next())
		{
			if(resultSet.getString("OngoingTest_MarkedAnswers") != null)
			markedAnswers=StringParser.ReleaseintoArrayOfLongs(";",resultSet.getString("OngoingTest_MarkedAnswers"));	
		}
		connectionManager.CloseConnection();
		return markedAnswers;
	}
}
