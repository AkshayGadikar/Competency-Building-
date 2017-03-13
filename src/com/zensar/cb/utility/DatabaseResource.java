package com.zensar.cb.utility;

import java.util.ResourceBundle;

public class DatabaseResource {
	private ResourceBundle resourceBundle;
	private String dataBaseDriver, databaseURL, databaseUserName, databasePassword;
	
	public DatabaseResource() {
		// TODO Auto-generated constructor stub
		resourceBundle= ResourceBundle.getBundle("DataBaseResource");
		dataBaseDriver=resourceBundle.getString("driver");
		databaseURL=resourceBundle.getString("databaseURL");
		databaseUserName=resourceBundle.getString("databaseUserName");
		databasePassword=resourceBundle.getString("databasePassword");
	}

	public String getDataBaseDriver() {
		return dataBaseDriver;
	}

	public void setDataBaseDriver(String dataBaseDriver) {
		this.dataBaseDriver = dataBaseDriver;
	}

	public String getDatabaseURL() {
		return databaseURL;
	}

	public void setDatabaseURL(String databaseURL) {
		this.databaseURL = databaseURL;
	}

	public String getDatabaseUserName() {
		return databaseUserName;
	}

	public void setDatabaseUserName(String databaseUserName) {
		this.databaseUserName = databaseUserName;
	}

	public String getDatabasePassword() {
		return databasePassword;
	}

	public void setDatabasePassword(String databasePassword) {
		this.databasePassword = databasePassword;
	}
}
