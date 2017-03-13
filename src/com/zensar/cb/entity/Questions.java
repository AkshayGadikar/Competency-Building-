package com.zensar.cb.entity;

import java.util.Date;
/*
 	`Question_id` ,`topic_id` `ccreated_by`
 	`question_type` `complexity_level` 
	`description` 	`question_statement` 
	 `created_on`
 */

public class Questions {
	private long questionId, questionTopicId, questionCreatedBy;
	private int questionType, questionComplexityLevel;
	private String questionDescription, questionStatement;
	private Date questionCreatedOn;
	
	
	
	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Questions(long questionTopicId, int questionType,
			int questionComplexityLevel, String questionStatement) {
		super();
		this.questionTopicId = questionTopicId;
		this.questionType = questionType;
		this.questionComplexityLevel = questionComplexityLevel;
		this.questionStatement = questionStatement;
	}

	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public long getQuestionTopicId() {
		return questionTopicId;
	}
	public void setQuestionTopicId(long questionTopicId) {
		this.questionTopicId = questionTopicId;
	}
	public long getQuestionCreatedBy() {
		return questionCreatedBy;
	}
	public void setQuestionCreatedBy(long questionCreatedBy) {
		this.questionCreatedBy = questionCreatedBy;
	}
	public int getQuestionType() {
		return questionType;
	}
	//1,2=objective 3=subjective
	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}
	public int getQuestionComplexityLevel() {
		return questionComplexityLevel;
	}
	public void setQuestionComplexityLevel(int questionComplexityLevel) {
		this.questionComplexityLevel = questionComplexityLevel;
	}
	public String getQuestionDescription() {
		return questionDescription;
	}
	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}
	public String getQuestionStatement() {
		return questionStatement;
	}
	public void setQuestionStatement(String questionStatement) {
		this.questionStatement = questionStatement;
	}
	public Date getQuestionCreatedOn() {
		return questionCreatedOn;
	}
	public void setQuestionCreatedOn(Date questionCreatedOn) {
		this.questionCreatedOn = questionCreatedOn;
	}
	@Override
	public String toString() {
		return "Questions [questionId=" + questionId + ", questionTopicId="
				+ questionTopicId + ", questionCreatedBy=" + questionCreatedBy
				+ ", questionType=" + questionType
				+ ", questionComplexityLevel=" + questionComplexityLevel
				+ ", questionDescription=" + questionDescription
				+ ", questionStatement=" + questionStatement
				+ ", questionCreatedOn=" + questionCreatedOn + "]";
	}	
}
