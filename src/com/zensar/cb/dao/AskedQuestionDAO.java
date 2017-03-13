package com.zensar.cb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zensar.cb.utility.ConnectionManager;

public class AskedQuestionDAO {
	/**
	 * 
	 * @param userId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public long[] getAskedQuestionIds(long userId) throws ClassNotFoundException, SQLException
	{
		ConnectionManager connectionManager=new ConnectionManager();
		Connection connection=connectionManager.openConnection();
		PreparedStatement preparedStatement =connection.prepareStatement("Select * from AskedQuestion where AskedQuestion_users_id=?");
		preparedStatement.setLong(1, userId);
		ResultSet resultSet=preparedStatement.executeQuery();
		resultSet.last();
		int resultSetLength=resultSet.getRow();
		resultSet.beforeFirst();
		long[] askedQuestionIds=new long[resultSetLength];
		int index=-1;
		while(resultSet.next())
		{
			index++;
			askedQuestionIds[index]=resultSet.getLong("AskedQuestion_users_id");
			askedQuestionIds[index]=resultSet.getLong("AskedQuestion_question_id");
		}
		connectionManager.CloseConnection();
		return askedQuestionIds;
	}
	/**
	 * 
	 * @param askedQuestionId
	 * @param userId
	 * @param historyId
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void addQuestions(long askedQuestionId,long userId) throws SQLException, ClassNotFoundException
	{
		ConnectionManager connectionManager=new ConnectionManager();
		Connection connection=connectionManager.openConnection();
		PreparedStatement preparedStatement =connection.prepareStatement("Insert into AskedQuestion( AskedQuestion_users_id , AskedQuestion_question_id ) values(?,?)");
		preparedStatement.setLong(1, userId);
		preparedStatement.setLong(2, askedQuestionId);
		preparedStatement.execute();
		connection.close();
	}
}