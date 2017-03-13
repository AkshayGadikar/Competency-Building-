package com.zensar.cb.entity;

public class Topic {
	private long topicID, topicChildOf;
	private String topicName, topicDescription, topicCategory,topicVesion;/* added field version*/
	
	
	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Topic(long topicChildOf, String topicName, String topicDescription,
			String topicCategory, String topicVesion) {
		super();
		this.topicChildOf = topicChildOf;
		this.topicName = topicName;
		this.topicDescription = topicDescription;
		this.topicCategory = topicCategory;
		this.topicVesion = topicVesion;
	}

	public String getTopicVesion() {
		return topicVesion;
	}

	public void setTopicVesion(String topicVesion) {
		this.topicVesion = topicVesion;
	}

	public long getTopicID() {
		return topicID;
	}

	public void setTopicID(long topicID) {
		this.topicID = topicID;
	}

	public long getTopicChildOf() {
		return topicChildOf;
	}

	public void setTopicChildOf(long topicChildOf) {
		this.topicChildOf = topicChildOf;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTopicDescription() {
		return topicDescription;
	}

	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}

	public String getTopicCategory() {
		return topicCategory;
	}

	public void setTopicCategory(String topicCategory) {
		this.topicCategory = topicCategory;
	}

	@Override
	public String toString() {
		return "Topic [topicID=" + topicID + ", topicChildOf=" + topicChildOf
				+ ", topicName=" + topicName + ", topicDescription="
				+ topicDescription + ", topicCategory=" + topicCategory
				+ ", topicVesion=" + topicVesion + "]";
	}

	

}
