package com.zensar.cb.entity;

public class Options {
	private long optionId,questionId;
	private String optionDescription;
	private boolean optionIsCorrect;
	
	public Options() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Options(String optionDescription, boolean optionIsCorrect) {
		super();
		this.optionDescription = optionDescription;
		this.optionIsCorrect = optionIsCorrect;
	}
	public long getOptionId() {
		return optionId;
	}
	public void setOptionId(long optionId) {
		this.optionId = optionId;
	}
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public String getOptionDescription() {
		return optionDescription;
	}
	public void setOptionDescription(String optionDescription) {
		this.optionDescription = optionDescription;
	}
	public boolean getIsOptionIsCorrect() {
		return optionIsCorrect;
	}
	public void setOptionIsCorrect(boolean optionIsCorrect) {
		this.optionIsCorrect = optionIsCorrect;
	}
	@Override
	public String toString() {
		return "Options [optionId=" + optionId + ", questionId=" + questionId
				+ ", optionDescription=" + optionDescription
				+ ", optionIsCorrect=" + optionIsCorrect + "]";
	}
	
	}
