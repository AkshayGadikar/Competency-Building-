package com.zensar.cb.exceptions;

@SuppressWarnings("serial")
public class LessQuestionFoundExceptions extends Exception {
	
	private long topicId;
	
	public LessQuestionFoundExceptions(long topicId) {
		this.topicId = topicId;
	}

	public String toString()
	{
		return "Less Questions Found, for topic Id "+ topicId;
	}
}
