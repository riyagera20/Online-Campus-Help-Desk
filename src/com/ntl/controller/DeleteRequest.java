package com.ntl.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ntl.dao.RequestDAO;

/**
 * Servlet implementation class DeleteRequest
 */
@WebServlet("/DeleteRequest")
public class DeleteRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDAO requestDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRequest() {
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
		String userType=(String) request.getSession().getAttribute("UserType");
		requestDao=new RequestDAO();
		if(!requestDao.deleteRequest(requestId))
		{
			request.setAttribute("errorMessage","Some error occured while closing request");
			RequestDispatcher rd=request.getRequestDispatcher("/ErrorPage");
			rd.forward(request, response);
		}
		else
		{
			switch(userType)
			{
			case "Requestor":
			{
				RequestDispatcher rd=request.getRequestDispatcher("/MyRequest");
				rd.forward(request, response);
				break;
			}
			case "Assignee":
			{
				break;
			}
			case "FacilityHead":
			{
				RequestDispatcher rd=request.getRequestDispatcher("/FacilityHeadHomePage");
				rd.forward(request, response);
				break;
			}
			}
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
