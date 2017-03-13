package com.zensar.cb.exceptions;

public class DataAccessException extends Exception {

private String message;

public DataAccessException(String message) {
	super();
	this.message = message;
}

@Override
public String toString() {
	return "DataAccessException [message=" + message + "]";
}
	
	
	
}
