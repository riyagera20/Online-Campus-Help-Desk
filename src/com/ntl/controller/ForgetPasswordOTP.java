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
import com.ntl.services.SendEmailClass;

/**
 * Servlet implementation class ForgetPasswordOTP
 */
@WebServlet("/ForgetPasswordOTP")
public class ForgetPasswordOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequstorDAO rDAO;
	FacilityHeadDAO fDAO;
	AssigneeDAO aDAO;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPasswordOTP() {
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
		String email=(String) request.getParameter("email");
		String userType=(String) request.getSession().getAttribute("UserType");
		
		
		switch(userType)
		{
		case "Requestor":
		{
			int userid=rDAO.checkRequestorEmail(email);
			if(userid>0)
			{
				int min=100000;
				int max=999999;
				int otp=(int)(Math.random()*(max-min+1)+min);
				SendEmailClass.sendEmail(email,"OTP to change Password","Your OTP to change Password: "+otp);
				HttpSession session=request.getSession();
				session.setAttribute("OTP",otp);
				session.setAttribute("userid",userid);
				RequestDispatcher rd = request.getRequestDispatcher("EnterOTPForgetPassword.html");
		        rd.forward(request, response);
			}
			else
			{
				request.setAttribute("errorMessage","Email ID not registered");
				RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage");
		        rd.forward(request, response);
			}
			break;
		}
		case "Assignee":
		{   int userid=aDAO.checkAssigneeEmail(email);
			if(userid>0)
			{
				int min=100000;
				int max=999999;
				int otp=(int)(Math.random()*(max-min+1)+min);
				SendEmailClass.sendEmail(email,"OTP to change Password","Your OTP to change Password: "+otp);
				HttpSession session=request.getSession();
				session.setAttribute("OTP",otp);
				session.setAttribute("userid",userid);
				RequestDispatcher rd = request.getRequestDispatcher("EnterOTPForgetPassword.html");
		        rd.forward(request, response);
			}
			else
			{
				request.setAttribute("errorMessage","Email ID not registered");
				RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage");
		        rd.forward(request, response);
			}
			break;
		}
		case "FacilityHead":
		{
			int userid=fDAO.checkFacilityHeadEmail(email);
			if(userid>0)
			{
				int min=100000;
				int max=999999;
				int otp=(int)(Math.random()*(max-min+1)+min);
				SendEmailClass.sendEmail(email,"OTP to change Password","Your OTP to change Password: "+otp);
				HttpSession session=request.getSession();
				session.setAttribute("OTP",otp);
				session.setAttribute("userid",userid);
				RequestDispatcher rd = request.getRequestDispatcher("EnterOTPForgetPassword.html");
		        rd.forward(request, response);
			}
			else
			{
				request.setAttribute("errorMessage","Email ID not registered");
				RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage");
		        rd.forward(request, response);
			}
			break;
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
