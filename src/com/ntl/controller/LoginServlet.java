package com.ntl.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ntl.dao.AssigneeDAO;
import com.ntl.dao.FacilityHeadDAO;
import com.ntl.dao.RequstorDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    RequstorDAO rDAO; 
    FacilityHeadDAO fDAO;
    AssigneeDAO aDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		rDAO=new RequstorDAO();
		fDAO=new FacilityHeadDAO();
		aDAO=new AssigneeDAO();
		int userId=Integer.parseInt(request.getParameter("userId"));
		String password=(String) request.getParameter("password");
		String userType=(String) request.getSession().getAttribute("UserType");
		
		switch(userType)
		{
		case "Requestor":
		{
			if(rDAO.checkRequestorCredentials(userId,password))
			{
				HttpSession session=request.getSession();
				session.setAttribute("userid",userId);
			String status=rDAO.checkPasswordChangeStatus(userId);
			
			if(status.equals("YES"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("/RequestorHomePage");
		        rd.forward(request, response);
			}
			else if(status.equals("NO"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("ChangePassword.html");
		        rd.forward(request, response);
			}
			}
			else
			{
				request.setAttribute("errorMessage","Invalid Credentials");
				RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage");
		        rd.forward(request, response);
			}
			break;
		}
		case "Assignee":
		{
			if(aDAO.checkAssigneeCredentials(userId,password))
			{
				HttpSession session=request.getSession();
				session.setAttribute("userid",userId);
			String status=aDAO.checkPasswordChangeStatus(userId);
			
			if(status.equals("YES"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("/AssigneeHomePage");
		        rd.forward(request, response);
			}
			else if(status.equals("NO"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("ChangePassword.html");
		        rd.forward(request, response);
			}
			}
			else
			{
				request.setAttribute("errorMessage","Invalid Credentials");
				RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage");
		        rd.forward(request, response);
			}
			break;
		}
		case "FacilityHead":
		{	
			if(fDAO.checkFacilityHeadCredentials(userId,password))
		{
			HttpSession session=request.getSession();
			session.setAttribute("userid",userId);
		String status=fDAO.checkPasswordChangeStatus(userId);
		
		if(status.equals("YES"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("/FacilityHeadHomePage");
	        rd.forward(request, response);
		}
		else if(status.equals("NO"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("ChangePassword.html");
	        rd.forward(request, response);
		}
		}
		else
		{
			request.setAttribute("errorMessage","Invalid Credentials");
			RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage");
	        rd.forward(request, response);
		}
			break;
		}
		}
//		if(rDAO.checkRequestorCredentials(userId,password))
//		{
//			HttpSession session=request.getSession();
//			session.setAttribute("userid",userId);
//		String status=rDAO.checkPasswordChangeStatus(userId);
//		
//		if(status.equals("YES"))
//		{
//			RequestDispatcher rd = request.getRequestDispatcher("/RequestorHomePage");
//	        rd.forward(request, response);
//		}
//		else if(status.equals("NO"))
//		{
//			RequestDispatcher rd = request.getRequestDispatcher("ChangePassword.html");
//	        rd.forward(request, response);
//		}
//		}
//		else
//		{
//			RequestDispatcher rd = request.getRequestDispatcher("errorPage.html");
//	        rd.forward(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
