package com.zensar.cb.entity;

public class SubjectiveAnswers {
      private long questionId;
      private long answerId;
      private String answer;
      
	public long getAnswerId() {
		return answerId;
	}
	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "SubjectiveAnswers [questionId=" + questionId + ", answerId="
				+ answerId + ", answer=" + answer + "]";
	}
	      
}
