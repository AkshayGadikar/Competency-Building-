package com.zensar.cb.entity;

import java.util.Arrays;
import java.sql.Date;

public class Test {
	private long testId, testCreatedBy,testTopics[];
	private int testType, numberOfQuestionPerTopic[], testTime,
			testComplexityLevel;
	private String testDescription;
	private Date testCreatedOn;

	
	
	
	

	/**
	 * @return the testId
	 */
	public long getTestId() {
		return testId;
	}






	/**
	 * @param testId the testId to set
	 */
	public void setTestId(long testId) {
		this.testId = testId;
	}






	/**
	 * @return the testCreatedBy
	 */
	public long getTestCreatedBy() {
		return testCreatedBy;
	}






	/**
	 * @param testCreatedBy the testCreatedBy to set
	 */
	public void setTestCreatedBy(long testCreatedBy) {
		this.testCreatedBy = testCreatedBy;
	}






	/**
	 * Please note topics are stored in Ascending order
	 * @return the testTopics
	 */
	public long[] getTestTopics() {
		return testTopics;
	}






	/**
	 * @param testTopics the testTopics to set
	 */
	public void setTestTopics(long[] testTopics) {
		this.testTopics = testTopics;
	}






	/**
	 * @return the testType
	 */
	public int getTestType() {
		return testType;
	}






	/**
	 * @param testType the testType to set
	 */
	public void setTestType(int testType) {
		this.testType = testType;
	}






	/**
	 * @return the numberOfQuestionPerTopic
	 */
	public int[] getNumberOfQuestionPerTopic() {
		return numberOfQuestionPerTopic;
	}






	/**
	 * @param numberOfQuestionPerTopic the numberOfQuestionPerTopic to set
	 */
	public void setNumberOfQuestionPerTopic(int[] numberOfQuestionPerTopic) {
		this.numberOfQuestionPerTopic = numberOfQuestionPerTopic;
	}






	/**
	 * @return the testTime
	 */
	public int getTestTime() {
		return testTime;
	}






	/**
	 * @param testTime the testTime to set
	 */
	public void setTestTime(int testTime) {
		this.testTime = testTime;
	}






	/**
	 * @return the testComplexityLevel
	 */
	public int getTestComplexityLevel() {
		return testComplexityLevel;
	}






	/**
	 * @param testComplexityLevel the testComplexityLevel to set
	 */
	public void setTestComplexityLevel(int testComplexityLevel) {
		this.testComplexityLevel = testComplexityLevel;
	}






	/**
	 * @return the testDescription
	 */
	public String getTestDescription() {
		return testDescription;
	}






	/**
	 * @param testDescription the testDescription to set
	 */
	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}






	/**
	 * @return the testCreatedOn
	 */
	public Date getTestCreatedOn() {
		return testCreatedOn;
	}






	/**
	 * @param testCreatedOn the testCreatedOn to set
	 */
	public void setTestCreatedOn(Date testCreatedOn) {
		this.testCreatedOn = testCreatedOn;
	}






	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testCreatedBy=" + testCreatedBy
				+ ", testTopics=" + Arrays.toString(testTopics) + ", testType="
				+ testType + ", numberOfQuestionPerTopic="
				+ Arrays.toString(numberOfQuestionPerTopic) + ", testTime="
				+ testTime + ", testComplexityLevel=" + testComplexityLevel
				+ ", testDescription=" + testDescription + ", testCreatedOn="
				+ testCreatedOn + "]";
	}

	
}
