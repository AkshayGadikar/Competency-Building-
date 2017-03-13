package com.zensar.cb.entity;

public class QuestionPack {
	
	//private long QuestionId;
	//private long[] OptionsId;
	//p/rivate String QuestionDescription;
	//private long SelectedQuestionId;
	//private long[] MarkedOptionsId;
	
	private Questions question;
	private Options[] option;
	private int QuestionType;
	
	public Questions getQuestion() {
		return question;
	}
	public void setQuestion(Questions question) {
		this.question = question;
	}
	public Options[] getOption() {
		return option;
	}
	public void setOption(Options[] option) {
		this.option = option;
	}
	public int getQuestionType() {
		return QuestionType;
	}
	public void setQuestionType(int questionType) {
		QuestionType = questionType;
	}
	
	
}
