package com.zensar.cb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zensar.cb.entity.Users;
import com.zensar.cb.utility.ConnectionManager;

/*
 * TODO This class will be completed as soon as class diagram is prepared
 */
public class UsersDAO {
	public Users getUserById(long userId) throws ClassNotFoundException, SQLException
	{
		ConnectionManager connectionManager=new ConnectionManager();
		Connection connection=connectionManager.openConnection();
		PreparedStatement preparedStatement =connection.prepareStatement("Select Users_id,User_name from User where Users_id=?");
		preparedStatement.setLong(1, userId);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			Users nuser=new Users();
			nuser.setUserId(resultSet.getLong("Users_id"));
			nuser.setUserName(resultSet.getString("User_name"));
			return nuser;
		}
		connectionManager.CloseConnection();
		return null;
	}
}