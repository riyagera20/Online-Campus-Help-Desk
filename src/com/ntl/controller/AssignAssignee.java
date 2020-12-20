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
import com.ntl.dao.RequestDAO;
import com.ntl.services.SendEmailClass;

/**
 * Servlet implementation class AssignAssignee
 */
@WebServlet("/AssignAssignee")
public class AssignAssignee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDAO requestDao;
	AssigneeDAO assigneeDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignAssignee() {
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
		int requestId=Integer.parseInt(request.getParameter("requestId"));
		int assigneeId=Integer.parseInt(request.getParameter("assignee"));
//		String assigneeEmail=request.getParameter("assigneeEmail");
		assigneeDao=new AssigneeDAO();
		String assigneeEmail=assigneeDao.getEmailFromAssigneeId(assigneeId);
		String reqDesc=request.getParameter("reqDesc");
		requestDao=new RequestDAO();
		if(!requestDao.addAssigneeToRequest(requestId,assigneeId))
		{
			request.setAttribute("errorMessage","Some error occured while assigning");
			RequestDispatcher rd=request.getRequestDispatcher("/ErrorPage");
			rd.forward(request, response);
		}
		else
		{
			SendEmailClass.sendEmail(assigneeEmail,"You hava been assigned a request",reqDesc);
				RequestDispatcher rd=request.getRequestDispatcher("/FacilityHeadHomePage");
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
