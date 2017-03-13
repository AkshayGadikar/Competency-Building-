package com.zensar.cb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zensar.cb.dao.HistoryDAO;
import com.zensar.cb.dao.TopicDAO;
import com.zensar.cb.entity.History;
import com.zensar.cb.exceptions.InvalidTestType;
import com.zensar.cb.services.EvaluationService;
import com.zensar.cb.services.TMSService;
import com.zensar.cb.utility.ConfigurationResuorce;
import com.zensar.cb.utility.StringParser;

/**
 * Servlet implementation class TestController
 */
@WebServlet("/TestController")
public class TestController {
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void processRequest(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
    	String formName = request.getParameter("formName");
    	System.out.println("formname= "+formName);
    	switch(formName)
    	{
    		case "ShowAvaliableTests":showAvaliableTests(request, response);
    			break;
    		case "TakeTest": takeTest(request, response);
    			break;
    		case "SaveAnswer": saveAnswer(request, response);
    			break;
    		case "FinishTest": finishTest(request,response);	
    			break;
    		case "RemoveTest":removeTest(request,response);
    			break;
    		case "EvaluateTestResult":evaluateTestResult(request,response);
    			break;
    		case "ShowHistory": showHistory(request,response);
    			break;
    		case "ResumeTest": resumeTest(request,response);
    			break;
    		default:showErrorPage(request,response);
    		
    	}      	
    }

	private void resumeTest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String testId =request.getParameter("resumetestId");
		if(testId==null)
		{
			System.out.println("test id is wrong"+testId);
		}
		else{
			System.out.println("resume Test");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/test/TestPage.jsp");
			requestDispatcher.forward(request, response);
			return;
		}
	}

	private void showErrorPage(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void showHistory(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession httpSession=request.getSession();
		long userId=(long) httpSession.getAttribute("userId");
		System.out.println("displaying history");
		HistoryDAO historyDAO=new HistoryDAO();
		try {
			PrintWriter printWriter=response.getWriter();
			History history[]=historyDAO.getHistories(userId);
			for (History history2 : history) {
				printWriter.println(history2);								// modify to html code
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void evaluateTestResult(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession httpSession=request.getSession();
		long userId=(long)httpSession.getAttribute("userId");
		long historyId=Long.parseLong(request.getParameter("historyId"));
		TopicDAO topicDAO= new TopicDAO();
		ConfigurationResuorce configurationResuorce=new ConfigurationResuorce();
		try {
			PrintWriter printWriter=response.getWriter();
			HashMap<Long, Float> results=new EvaluationService().evaluateCommentedResult(userId, historyId);
			Set<Long> keys=results.keySet();
			for (Long long1 : keys) {
				float percentage =results.get(long1)*100;
				printWriter.print("<div id=\"displayResultDivContainer\">");
				if(percentage<=configurationResuorce.getOneStarCutOff())
				{
					printWriter.print("<div id=\"displayResultDivTopicName\">");	
					printWriter.print(topicDAO.getTopicById(long1).getTopicName());
					printWriter.print("</div>");
					printWriter.print("<div id=\"displayResultDivComment\">");
					printWriter.print(configurationResuorce.getOneStarComment());
					printWriter.print("</div>");
				}
				else if(percentage <=configurationResuorce.getTwoStarCutOff())
				{
					
				}
				else if(percentage <=configurationResuorce.getThreeStarCutOff())
				{
					
				}
				else if(percentage <=configurationResuorce.getFourStarCutOff())
				{
					
				}
				else
				{
					
				}
				printWriter.print("</div>");
			}
			printWriter.close();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void removeTest(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void finishTest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession=request.getSession();
		long testId=(long)httpSession.getAttribute("testId");
		long userId=(long)httpSession.getAttribute("userId");
		System.out.println("testId="+testId+"userId="+userId);
		
		try {
			new EvaluationService().evaluateResult(userId, testId);
			response.sendRedirect("/CompetencyBuilding/view/test/TestCompeted.jsp");
			
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			//some thing went wrong
			e.printStackTrace();
		} catch (InvalidTestType e) {
			// TODO Auto-generated catch block
			//show exit page with notification of "result will be displayed later"
			e.printStackTrace();
		}
	}

	private void saveAnswer(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("I am in Save Answer");
		
		
		String testId=request.getParameter("testId");
		String userId=request.getParameter("userId");
		String questionId=request.getParameter("questionId");
		String answerType=request.getParameter("answerType");
		switch(answerType)
		{
			case "1":String markedAnswers=request.getParameter("markedAnswers");
						long array[]=new long[1];
						array[0]=Long.parseLong(markedAnswers);
						try {
							System.out.println("Saving Answer type=1");
							new TMSService().saveAnswersSCQ(Long.parseLong(userId), Long.parseLong(testId),Long.parseLong(questionId),array);
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
			case "2":

					 markedAnswers=request.getParameter("markedAnswers");
					 long array2[]=StringParser.ReleaseintoArrayOfLongs(";",markedAnswers);
					 try {
						 System.out.println("Saving Answer type=2");
						 new TMSService().saveAnswersSCQ(Long.parseLong(userId), Long.parseLong(testId),Long.parseLong(questionId),array2);
					 } catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						 e.printStackTrace();
					 } catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						 e.printStackTrace();
					 } catch (SQLException e) {
						// TODO Auto-generated catch block
						 e.printStackTrace();
					 }
				break;
			case "3":
				markedAnswers=request.getParameter("markedAnswers");
				try {
					System.out.println("Saving Answer type =3");
					new TMSService().saveAnswersSub(Long.parseLong(userId), Long.parseLong(testId),Long.parseLong(questionId),markedAnswers);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
		}
	}

	private void takeTest(HttpServletRequest request,
			
		HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String testId =request.getParameter("taketestId");
		if(testId==null)
		{
			System.out.println("test id is wrong"+testId);
		}
		else{
			System.out.println("new Test");
			HttpSession httpSession=request.getSession();
			httpSession.setAttribute("testId", Long.parseLong(testId));
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/test/TestPage.jsp");
			requestDispatcher.forward(request, response);
			return;
		}
	}

	private void showAvaliableTests(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
}
