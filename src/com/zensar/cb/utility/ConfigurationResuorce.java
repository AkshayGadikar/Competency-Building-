package com.zensar.cb.utility;

import java.util.ResourceBundle;

public class ConfigurationResuorce {
	private ResourceBundle resourceBundle;
	private float oneStarCutOff,twoStarCutOff,threeStarCutOff,fourStarCutOff;
	private String oneStarComment,twoStarComment,threeStarComment,fourStartComment,fiveStartComment;
	public ConfigurationResuorce() {
		// TODO Auto-generated constructor stub
		resourceBundle=ResourceBundle.getBundle("Configuration");
		oneStarCutOff=Float.parseFloat(resourceBundle.getString("oneStarCutOff"));
		twoStarCutOff=Float.parseFloat(resourceBundle.getString("twoStarCutOff"));
		threeStarCutOff=Float.parseFloat(resourceBundle.getString("threeStarCutOff"));
		fourStarCutOff=Float.parseFloat(resourceBundle.getString("fourStarCutOff"));
		oneStarComment=resourceBundle.getString("oneStarComment");
		twoStarComment=resourceBundle.getString("twoStarComment");
		threeStarComment=resourceBundle.getString("threeStarComment");
		fourStartComment=resourceBundle.getString("fourStartComment");
		fiveStartComment=resourceBundle.getString("fiveStartComment");
	}
	/**
	 * @return the oneStarCutOff
	 */
	public float getOneStarCutOff() {
		return oneStarCutOff;
	}
	/**
	 * @param oneStarCutOff the oneStarCutOff to set
	 */
	public void setOneStarCutOff(float oneStarCutOff) {
		this.oneStarCutOff = oneStarCutOff;
	}
	/**
	 * @return the twoStarCutOff
	 */
	public float getTwoStarCutOff() {
		return twoStarCutOff;
	}
	/**
	 * @param twoStarCutOff the twoStarCutOff to set
	 */
	public void setTwoStarCutOff(float twoStarCutOff) {
		this.twoStarCutOff = twoStarCutOff;
	}
	/**
	 * @return the threeStarCutOff
	 */
	public float getThreeStarCutOff() {
		return threeStarCutOff;
	}
	/**
	 * @param threeStarCutOff the threeStarCutOff to set
	 */
	public void setThreeStarCutOff(float threeStarCutOff) {
		this.threeStarCutOff = threeStarCutOff;
	}
	/**
	 * @return the fourStarCutOff
	 */
	public float getFourStarCutOff() {
		return fourStarCutOff;
	}
	/**
	 * @param fourStarCutOff the fourStarCutOff to set
	 */
	public void setFourStarCutOff(float fourStarCutOff) {
		this.fourStarCutOff = fourStarCutOff;
	}
	/**
	 * @return the oneStarComment
	 */
	public String getOneStarComment() {
		return oneStarComment;
	}
	/**
	 * @param oneStarComment the oneStarComment to set
	 */
	public void setOneStarComment(String oneStarComment) {
		this.oneStarComment = oneStarComment;
	}
	/**
	 * @return the twoStarComment
	 */
	public String getTwoStarComment() {
		return twoStarComment;
	}
	/**
	 * @param twoStarComment the twoStarComment to set
	 */
	public void setTwoStarComment(String twoStarComment) {
		this.twoStarComment = twoStarComment;
	}
	/**
	 * @return the threeStarComment
	 */
	public String getThreeStarComment() {
		return threeStarComment;
	}
	/**
	 * @param threeStarComment the threeStarComment to set
	 */
	public void setThreeStarComment(String threeStarComment) {
		this.threeStarComment = threeStarComment;
	}
	/**
	 * @return the fourStartComment
	 */
	public String getFourStartComment() {
		return fourStartComment;
	}
	/**
	 * @param fourStartComment the fourStartComment to set
	 */
	public void setFourStartComment(String fourStartComment) {
		this.fourStartComment = fourStartComment;
	}
	/**
	 * @return the fiveStartComment
	 */
	public String getFiveStartComment() {
		return fiveStartComment;
	}
	/**
	 * @param fiveStartComment the fiveStartComment to set
	 */
	public void setFiveStartComment(String fiveStartComment) {
		this.fiveStartComment = fiveStartComment;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ConfigurationResuorce [oneStarCutOff=" + oneStarCutOff
				+ ", twoStarCutOff=" + twoStarCutOff + ", threeStarCutOff="
				+ threeStarCutOff + ", fourStarCutOff=" + fourStarCutOff
				+ ", oneStarComment=" + oneStarComment + ", twoStarComment="
				+ twoStarComment + ", threeStarComment=" + threeStarComment
				+ ", fourStartComment=" + fourStartComment
				+ ", fiveStartComment=" + fiveStartComment + "]";
	}
}
