package com.zensar.cb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PerConnectionLRUFactory;
import com.zensar.cb.entity.History;
import com.zensar.cb.utility.ConnectionManager;
import com.zensar.cb.utility.StringParser;

/*
 * TODO This class will be completed as soon as class diagram is prepared
 */
public class HistoryDAO {

	public History[] getHistories(long userId) throws SQLException, ClassNotFoundException {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();
		System.out.println("USER ID IS "+userId);
		PreparedStatement preparedStatement = connection.prepareStatement("Select * from History where History_user_id=?");
		preparedStatement.setLong(1, userId);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.last();
		int resultSetLength = resultSet.getRow();
		resultSet.beforeFirst();
		History[] histories=new History[resultSetLength];
		int index = -1;
		while (resultSet.next()) {
			index++;
			histories[index]=new History();
			histories[index].setHistoryId(resultSet.getLong("History_id"));
			histories[index].setHistoryTestId(resultSet.getLong("History_test_id"));
			histories[index].setHistoryUserId(resultSet.getLong("History_user_id"));
			histories[index].setHistoryDateAndTime(resultSet.getDate("History_dateAndTime"));
			histories[index].setHistoryRemark(resultSet.getString("History_remark"));
			histories[index].setResultPerTopics(StringParser.ReleaseintoArrayOfint(";", resultSet.getString("History_resultsPerTopics")));
		}
		connectionManager.CloseConnection();
		return histories;
	
	}
	
	/**
	 *
	 * @param userId
	 * @param testId
	 * @return if -1 then maximum history dose not exist
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public long getMaxHistoryId(long userId,long testId) throws SQLException, ClassNotFoundException {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("Select max(History_id) from History where History_user_id=? and History_test_id=?");
		preparedStatement.setLong(1, userId);
		preparedStatement.setLong(2, testId);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
			return resultSet.getLong("History_id");
		return -1;
	}

	public History getHistory(long historyId) throws ClassNotFoundException, SQLException {
		
		ConnectionManager connectionManager=new ConnectionManager();
		Connection connection=connectionManager.openConnection();
		PreparedStatement preparedStatement =connection.prepareStatement("Select History_test_id,History_user_id,History_dateAndTime,History_resultsPerTopics,History_remark from History where History_id=?");
		preparedStatement.setLong(1, historyId);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			History history=new History();
			history.setHistoryId(historyId);
			history.setHistoryDateAndTime(resultSet.getDate("History_dateAndTime"));
			history.setHistoryRemark(resultSet.getString("History_dateAndTime"));
			history.setHistoryUserId(resultSet.getLong("History_user_id"));
			history.setHistoryTestId(resultSet.getLong("History_test_id"));
			history.setResultPerTopics(StringParser.ReleaseintoArrayOfint(";", resultSet.getString("History_resultsPerTopics")));
			return history;
		}
		connectionManager.CloseConnection();
		return null;
		
	}

	public void addHistory(History history) throws ClassNotFoundException, SQLException {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into History(History_id, History_test_id, History_user_id, History_dateAndTime, History_remark, History_resultsPerTopics) values (null,?,?,now(),?,?) ");
		preparedStatement.setLong(1, history.getHistoryTestId());
		preparedStatement.setLong(2, history.getHistoryUserId());
		preparedStatement.setString(3, history.getHistoryRemark());
		preparedStatement.setString(4, StringParser.Bindint(";",history.getResultPerTopics()));
		preparedStatement.execute();
		connectionManager.CloseConnection();
	}
}
