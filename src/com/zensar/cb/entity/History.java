package com.zensar.cb.entity;

import java.util.Arrays;
import java.sql.Date;

public class History {
	private long historyId;
	private long historyTestId, historyUserId;
	private Date historyDateAndTime;
	private String historyRemark;
	private int resultPerTopics[];
	public long getHistoryId() {
		return historyId;
	}
	public void setHistoryId(long historyId) {
		this.historyId = historyId;
	}
	public long getHistoryTestId() {
		return historyTestId;
	}
	public void setHistoryTestId(long historyTestId) {
		this.historyTestId = historyTestId;
	}
	public long getHistoryUserId() {
		return historyUserId;
	}
	public void setHistoryUserId(long historyUserId) {
		this.historyUserId = historyUserId;
	}
	public Date getHistoryDateAndTime() {
		return historyDateAndTime;
	}
	public void setHistoryDateAndTime(Date historyDateAndTime) {
		this.historyDateAndTime = historyDateAndTime;
	}
	public String getHistoryRemark() {
		return historyRemark;
	}
	public void setHistoryRemark(String historyRemark) {
		this.historyRemark = historyRemark;
	}
	public int[] getResultPerTopics() {
		return resultPerTopics;
	}
	public void setResultPerTopics(int[] resultPerTopics) {
		this.resultPerTopics = resultPerTopics;
	}
	@Override
	public String toString() {
		return "History [historyId=" + historyId + ", historyTestId="
				+ historyTestId + ", historyUserId=" + historyUserId
				+ ", historyDateAndTime=" + historyDateAndTime
				+ ", historyRemark=" + historyRemark + ", resultPerTopics="
				+ Arrays.toString(resultPerTopics) + "]";
	}

}
