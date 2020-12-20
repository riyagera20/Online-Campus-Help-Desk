package com.ntl.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ntl.dao.AssigneeDAO;
import com.ntl.dao.FacilityHeadDAO;
import com.ntl.dao.RequstorDAO;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequstorDAO rDAO;
	FacilityHeadDAO fDAO;
	AssigneeDAO aDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
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
//		String userId=(String) request.getSession().getAttribute("userid");
//		int userIdInt=Integer.parseInt(userId);
		int userId=(int) request.getSession().getAttribute("userid");
		String newPassword=(String) request.getParameter("newPassword");
		String reNewPassword=(String) request.getParameter("reNewPassword");
		String userType=(String) request.getSession().getAttribute("UserType");
		
		
		if(newPassword.equals(reNewPassword))
		{
			switch(userType)
			{
			case "Requestor":
			{
			if(rDAO.changeRequestorPassword(userId,newPassword))
			{
				System.out.println("Password Changed");
				RequestDispatcher rd = request.getRequestDispatcher("/RequestorHomePage");
		        rd.forward(request, response);
			}
			else
			{
				request.setAttribute("errorMessage","Some error occured password cann't be changed");
				RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage");
		        rd.forward(request, response);
			}
			break;
			}
			case "Assignee":
			{
				if(aDAO.changeAssigneePassword(userId,newPassword))
				{
					System.out.println("Password Changed");
					RequestDispatcher rd = request.getRequestDispatcher("/AssigneeHomePage");
			        rd.forward(request, response);
				}
				else
				{
					request.setAttribute("errorMessage","Some error occured password cann't be changed");
					RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage");
			        rd.forward(request, response);
				}
				break;
			}
			case "FacilityHead":
			{	
				if(fDAO.changeFacilityHeadPassword(userId,newPassword))
				{
					System.out.println("Password Changed");
					RequestDispatcher rd = request.getRequestDispatcher("/FacilityHeadHomePage");
			        rd.forward(request, response);
				}
				else
				{
					request.setAttribute("errorMessage","Some error occured password cann't be changed");
					RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage");
			        rd.forward(request, response);
				}
				break;
			}
			}
		}
		else
		{
			request.setAttribute("errorMessage","Password didn't match");
			RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage");
	        rd.forward(request, response);
		}
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
