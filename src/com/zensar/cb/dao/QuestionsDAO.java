package com.zensar.cb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zensar.cb.entity.Options;
import com.zensar.cb.entity.Questions;
import com.zensar.cb.entity.SubjectiveAnswers;
import com.zensar.cb.entity.Users;
import com.zensar.cb.utility.ConnectionManager;

/*
 * TODO This class will be completed as soon as class diagram is prepared
 */

public class QuestionsDAO {
	private ResultSet rs;

	public Questions getQuestionById(long questionId) throws SQLException,
			ClassNotFoundException {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("Select * from questions where Question_id=?");
		preparedStatement.setLong(1, questionId);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Questions question = new Questions();

			/*
			 Question_id,question_type,question_statement,topic_id,complexity_level,ccreated_by,created_on 
			 */
			
			
			question.setQuestionId(resultSet.getLong("Question_id"));
			question.setQuestionType(resultSet.getInt("question_type"));
			question.setQuestionStatement(resultSet.getString("question_statement"));
			question.setQuestionTopicId(resultSet.getLong("topic_id"));
			question.setQuestionCreatedBy(resultSet.getLong("ccreated_by"));
			question.setQuestionCreatedOn(resultSet.getDate("created_on"));
			question.setQuestionComplexityLevel(resultSet.getInt("complexity_level"));
			return question;
		}
		return null;
	}

	public long[] getNonAskedQuestionsIdObjective(long userId, long topicId, int complexityLevel) throws ClassNotFoundException, SQLException {
		ConnectionManager connectionManager=new ConnectionManager();
		Connection connection=connectionManager.openConnection();
		String string="select Question_id from questions where "
				  + "( (Question_id not in(select AskedQuestion_question_id from AskedQuestion where AskedQuestion_users_id=?))"
				  + " and (complexity_level <= ?)"
				  + " and (topic_id=?)"
				  + " and ((question_type=1) or(question_type=2)))"
				  + " order by complexity_level desc";
				  System.out.println(string);
		PreparedStatement preparedStatement=connection.prepareStatement(string);
		preparedStatement.setLong(1, userId);
		preparedStatement.setLong(2, complexityLevel);
		preparedStatement.setLong(3, topicId);
		ResultSet resultSet=preparedStatement.executeQuery();
		
		resultSet.last();
		int resultSetLength=resultSet.getRow();
		resultSet.beforeFirst();
		long[] questionIds=new long[resultSetLength];
		int index=-1;
		while(resultSet.next())
		{
			index++;
			questionIds[index]=resultSet.getLong("Question_id");
		}
		return questionIds;
	}
	public long[] getNonAskedQuestionsIdSubjective(long userId, long topicId, int complexityLevel) throws ClassNotFoundException, SQLException {
		ConnectionManager connectionManager=new ConnectionManager();
		Connection connection=connectionManager.openConnection();
		String string="select Question_id from questions where "
				  + "( (Question_id not in(select AskedQuestion_question_id from AskedQuestion where AskedQuestion_users_id=?))"
				  + " and (complexity_level <= ?)"
				  + " and (topic_id=?)"
				  + " and (question_type=3) )"
				  + " order by complexity_level desc";
				  System.out.println(string);
		PreparedStatement preparedStatement=connection.prepareStatement(string);
		preparedStatement.setLong(1, userId);
		preparedStatement.setLong(2, complexityLevel);
		preparedStatement.setLong(3, topicId);
		ResultSet resultSet=preparedStatement.executeQuery();
		
		resultSet.last();
		int resultSetLength=resultSet.getRow();
		resultSet.beforeFirst();
		long[] questionIds=new long[resultSetLength];
		int index=-1;
		while(resultSet.next())
		{
			index++;
			questionIds[index]=resultSet.getLong("Question_id");
		}
		return questionIds;
	}
	
	
	public boolean setQuestion(Questions question, Users user, Options option,SubjectiveAnswers answer)
			throws SQLException, ClassNotFoundException {
		 Date date = new Date();
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();
		long qid=0;
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("insert into questions(question_type,question_statement,topic_id,complexity_level) values(?,?,?,?)");
					pstmt.setInt(1, question.getQuestionType());
					pstmt.setString(2, question.getQuestionStatement());
					pstmt.setLong(3, question.getQuestionTopicId());
					pstmt.setInt(4, question.getQuestionComplexityLevel());
//					pstmt.setLong(5, user.getUserId());
 //					pstmt.setDate(6, dateFormat.format(date)); /* ---check date function--- */
					pstmt.execute();
					pstmt=connection.prepareStatement("select max(Question_id) from questions");
					rs=pstmt.executeQuery();
					
					if(rs.next()){
						qid=rs.getInt(1);
					}
					
					if(question.getQuestionType()==0)new OptionsDAO().setOption(option, question,qid);/*assuming 0 for objective 1 for subjective*/
					   else if (question.getQuestionType()==1)new SubjectiveAnswerDAO().setAnswer( question,answer,qid); 
					   connectionManager.CloseConnection();
						pstmt.close();
			} catch (SQLException e) {
						throw e;
								  }
					return true;
					
							
							
							
					
		
		
	}


	
}
