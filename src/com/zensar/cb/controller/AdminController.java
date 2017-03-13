package com.zensar.cb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.cb.entity.Options;
import com.zensar.cb.entity.Questions;
import com.zensar.cb.entity.SubjectiveAnswers;
import com.zensar.cb.entity.Test;
import com.zensar.cb.entity.Topic;
import com.zensar.cb.entity.Users;
import com.zensar.cb.exceptions.DataAccessException;
import com.zensar.cb.services.AdminService;

public class AdminController {

	public void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, SQLException,
			ClassNotFoundException, Exception {

		String formName = request.getParameter("formName");
		if ("CreateTest".equals(formName)) {
			createTest(request, response);

		} else if ("CreateQuestion".equals(formName)) {
			createQuestion(request, response);
		} else if ("CreateTopic".equals(formName)) { // also called as question
														// bank
			createTopic(request, response);
		}
	}

	private void createTopic(HttpServletRequest request,
			HttpServletResponse response) throws IOException, SQLException,
			DataAccessException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("parenttopic"));
		Topic topic = new Topic(Long.valueOf(request
				.getParameter("parenttopic")), request.getParameter("topic"),
				request.getParameter("desc"), request.getParameter("category"),
				request.getParameter("ver"));/*
												 * test object
												 */

		try {
			boolean reply = new AdminService().createTopic(topic);
			if (reply == true) {
				PrintWriter out = response.getWriter();
				String recordInserted = request.getParameter("recordIserted");
				out.print("<font color='cyan' size=45>question bank created</font>");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}

	private void createQuestion(HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			ClassNotFoundException, IOException {
		SubjectiveAnswers answer = new SubjectiveAnswers();
		Options option=null;
		Questions question = new Questions(Long.valueOf(request
				.getParameter("topic")), Integer.valueOf(request
				.getParameter("type")), Integer.valueOf(request.getParameter("complexity")),request.getParameter("question"));
		Users user = new Users(1, "ASd");/* user info ??? */
		System.out.println(request.getParameter("topic"));
		if(Integer.valueOf(request.getParameter("type"))==1){
		answer.setAnswer(request.getParameter("answer"));
		}
		boolean reply = new AdminService().createQuestion(question, user,
				option, answer);/*
								 * user id user name
								 */
		if (reply == true) {
			PrintWriter out = response.getWriter();
			String recordInserted = request.getParameter("recordIserted");
			out.print("<font color='cyan' size=45>question bank created</font>");
		}

	}

	private void createTest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		long[] a = null;
		Test test=new Test(a,"Java", 1, 2, 3, 4, 5, "aaa");
		
		try{
			boolean reply=new AdminService().createTest(test);
			
			if(reply==true) {  
		         PrintWriter out=response.getWriter();
				String recordInserted=request.getParameter("recordIserted");
				out.print("<font color='cyan' size=45>Test Created</font>");
		  	}
			else{
				PrintWriter out=response.getWriter();
				String recordInserted=request.getParameter("Record  Inserted");
				out.print("<font color='cyan' size=45>test not created</font>");
			}
		}
			catch (IOException e) {}
		
		
	}

}
