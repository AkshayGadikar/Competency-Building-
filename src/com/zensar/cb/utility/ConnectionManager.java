package com.zensar.cb.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author Mohamadali
 *
 */
public class ConnectionManager {
	private Connection connection=null;
	
	private static DatabaseResource databaseResource=new DatabaseResource();
	
	/*
	 * Temp fix until connection is retrieved from datasource
	 */
	private static boolean isDriverLoaded = false;
	
	static {
		try {
			Class.forName(databaseResource.getDataBaseDriver());
			isDriverLoaded = true;
		}
		catch(ClassNotFoundException cnfe) {	
			// do nothing
		}
	}
	
	
	public ConnectionManager() throws SQLException {
		System.out.println(isDriverLoaded);
		if(!isDriverLoaded)
			throw new SQLException("Driver is not loaded!");
	}
	
	/*
	 * end of temp fix
	 */
	
	/**
	 * This method is singleton 
	 * @return Connection object if SQL connection is Properly configured else return null
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	
	public Connection openConnection() throws SQLException 
	{
			connection = DriverManager.getConnection(databaseResource.getDatabaseURL(),databaseResource.getDatabaseUserName(),databaseResource.getDatabasePassword());
			return connection;
	}
	
	public void CloseConnection() throws SQLException{
		connection.close();
	}
}
