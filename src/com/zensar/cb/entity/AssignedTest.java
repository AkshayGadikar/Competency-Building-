package com.zensar.cb.entity;

public class AssignedTest {
	private long testId,userId;

	public long getTestId() {
		return testId;
	}

	public void setTestId(long testId) {
		this.testId = testId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "AssignedTest [testId=" + testId + ", userId=" + userId + "]";
	}
	
}
