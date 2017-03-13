package com.zensar.cb.exceptions;

@SuppressWarnings("serial")
public class throwInvalidQuestionType extends Exception{
	private int questionType;

	public throwInvalidQuestionType(int questionType) {
		this.questionType = questionType;
	}

	public String toString()
	{
		return "Invalid Question type :"+questionType;
	}
}
