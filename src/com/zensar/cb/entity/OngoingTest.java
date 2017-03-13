package com.zensar.cb.entity;

import java.sql.Date;
import java.util.Arrays;

public class OngoingTest {
	private long ongoingTestUserId, ongoingTestTestId, ongoingTestQuestionId;
	private long ongoingTestMarkedAnswers[];
	private Date ongoingTestTimeStamp;
	public long getOngoingTestUserId() {
		return ongoingTestUserId;
	}
	public void setOngoingTestUserId(long ongoingTestUserId) {
		this.ongoingTestUserId = ongoingTestUserId;
	}
	public long getOngoingTestTestId() {
		return ongoingTestTestId;
	}
	public void setOngoingTestTestId(long ongoingTestTestId) {
		this.ongoingTestTestId = ongoingTestTestId;
	}
	public long getOngoingTestQuestionId() {
		return ongoingTestQuestionId;
	}
	public void setOngoingTestQuestionId(long ongoingTestQuestionId) {
		this.ongoingTestQuestionId = ongoingTestQuestionId;
	}
	public long[] getOngoingTestMarkedAnswers() {
		return ongoingTestMarkedAnswers;
	}
	public void setOngoingTestMarkedAnswers(long[] ongoingTestMarkedAnswers) {
		this.ongoingTestMarkedAnswers = ongoingTestMarkedAnswers;
	}
	public Date getOngoingTestTimeStamp() {
		return ongoingTestTimeStamp;
	}
	public void setOngoingTestTimeStamp(Date ongoingTestTimeStamp) {
		this.ongoingTestTimeStamp = ongoingTestTimeStamp;
	}
	@Override
	public String toString() {
		return "OngoingTest [ongoingTestUserId=" + ongoingTestUserId
				+ ", ongoingTestTestId=" + ongoingTestTestId
				+ ", ongoingTestQuestionId=" + ongoingTestQuestionId
				+ ", ongoingTestMarkedAnswers="
				+ Arrays.toString(ongoingTestMarkedAnswers)
				+ ", ongoingTestTimeStamp=" + ongoingTestTimeStamp + "]";
	}
}
