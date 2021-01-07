package com.ntl.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ntl.dao.FacilityHeadDAO;
import com.ntl.dao.RequestDAO;
import com.ntl.dao.RequstorDAO;
import com.ntl.services.SendEmailClass;

/**
 * Servlet implementation class AddResponse
 */
@WebServlet("/AddResponse")
public class AddResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDAO requestDao;
	RequstorDAO requestorDAO;
	FacilityHeadDAO facilityDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddResponse() {
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
		int requestorId=Integer.parseInt(request.getParameter("requestorId"));
		String facilityId=request.getParameter("facilityId");
		String res=request.getParameter("response");
		requestDao=new RequestDAO();
		requestorDAO=new RequstorDAO();
		facilityDAO=new FacilityHeadDAO();
		String requestorEmail=requestorDAO.getEmailFromRequestorId(requestorId);
		String facilityEmail=facilityDAO.getEmailFromFacilityId(facilityId);
		if(!requestDao.addResponseToRequest(requestId,res))
		{
			request.setAttribute("errorMessage","Some error occured while adding response");
			RequestDispatcher rd=request.getRequestDispatcher("/ErrorPage");
			rd.forward(request, response);
		}
		else
		{
			SendEmailClass.sendEmail(requestorEmail,"Response for your request Id:"+requestId,res);
			SendEmailClass.sendEmail(facilityEmail,"Response has been added against request Id:"+requestId,res);
			RequestDispatcher rd=request.getRequestDispatcher("/AssigneeHomePage");
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
