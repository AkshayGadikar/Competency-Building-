package com.zensar.cb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zensar.cb.entity.AssignedTest;
import com.zensar.cb.utility.ConnectionManager;

public class AssignedTestDAO {

	public AssignedTest[] getAssignedTest(long userId,long testType) throws SQLException, ClassNotFoundException
	{
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();
		PreparedStatement preparedStatement;
		if(testType==1)
		{
			preparedStatement = connection.prepareStatement("Select * from assignedTest,Test where "
																				+ "(Test.Test_id=assignedTest.Test_Id)"
																				+ " and (assignedTest.User_id=? and Test_type=1)");
			preparedStatement.setLong(1, userId);
		}
		else{
			preparedStatement = connection.prepareStatement("Select * from assignedTest,Test where "
																				+ "(Test.Test_id=assignedTest.Test_Id)"
																				+ " and (assignedTest.User_id=? and Test_type=2)");
			preparedStatement.setLong(1, userId);
		}
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.last();
		int resultSetLength = resultSet.getRow();
		resultSet.beforeFirst();
		AssignedTest[] assignedTests=new AssignedTest[resultSetLength];
		int index = -1;
		while (resultSet.next()) {
			index++;
			assignedTests[index]=new AssignedTest();
			assignedTests[index].setTestId(resultSet.getLong("assignedTest.Test_id"));
			assignedTests[index].setUserId(resultSet.getLong("assignedTest.User_id"));
		}
		connectionManager.CloseConnection();
		return assignedTests;
	}
}
