package com.zensar.cb.entity;

public class AskedQuestion {
	private long askedQuestionUserId, askedQuestionQuestionId;

	public long getAskedQuestionUserId() {
		return askedQuestionUserId;
	}

	public void setAskedQuestionUserId(long askedQuestionUserId) {
		this.askedQuestionUserId = askedQuestionUserId;
	}

	public long getAskedQuestionQuestionId() {
		return askedQuestionQuestionId;
	}

	public void setAskedQuestionQuestionId(long askedQuestionQuestionId) {
		this.askedQuestionQuestionId = askedQuestionQuestionId;
	}

	@Override
	public String toString() {
		return "AskedQuestion [askedQuestionUserId=" + askedQuestionUserId
				+ ", askedQuestionQuestionId=" + askedQuestionQuestionId + "]";
	}



}
