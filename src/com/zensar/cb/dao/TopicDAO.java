package com.zensar.cb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zensar.cb.entity.Topic;
import com.zensar.cb.exceptions.DataAccessException;
import com.zensar.cb.utility.ConnectionManager;
/*
 * TODO This class will be completed as soon as class diagram is prepared
 */
public class TopicDAO {
	
	
	public Topic getTopicById(long topicId) throws SQLException, ClassNotFoundException
	{
		ConnectionManager connectionManager=new ConnectionManager();
		Connection connection=connectionManager.openConnection();
		PreparedStatement preparedStatement =connection.prepareStatement("Select Topic_name,Topic_child_of,Topic_category from topic where Topic_id=?");
		preparedStatement.setLong(1, topicId);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			Topic ntopic=new Topic();
			ntopic.setTopicID(topicId);
			ntopic.setTopicName(resultSet.getString("Topic_name"));
			ntopic.setTopicChildOf(resultSet.getLong("Topic_child_of"));
			ntopic.setTopicCategory(resultSet.getString("Topic_category"));
			return ntopic;
		}
		connectionManager.CloseConnection();
		return null;
	}

	
	public boolean setTopic(Topic topic) throws SQLException, DataAccessException
	{
		try {
			ConnectionManager connectionManager=new ConnectionManager();
			Connection connection=connectionManager.openConnection();
			PreparedStatement pstmt =connection.prepareStatement("insert into topic(topic_child_of,topic_name,topic_description,topic_category,version) values(?,?,?,?,?)");
			pstmt.setLong(1, topic.getTopicChildOf());
			pstmt.setString(2, topic.getTopicName());
			pstmt.setString(3, topic.getTopicDescription());
			pstmt.setString(4, topic.getTopicCategory());
			pstmt.setString(5, topic.getTopicVesion());
			pstmt.execute();
			connectionManager.CloseConnection();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("data access failure");
		}
		return true;
		
	}
}
