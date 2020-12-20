package com.ntl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ntl.dao.FacilityHeadDAO;
import com.ntl.dao.RequestDAO;
import com.ntl.model.Request;
import com.ntl.services.SendEmailClass;

/**
 * Servlet implementation class SubmitRequest
 */
@WebServlet("/SubmitRequest")
public class SubmitRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDAO rDAO;
	FacilityHeadDAO fDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitRequest() {
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
		
		try {
//			String userId=(String) request.getSession().getAttribute("userid");
//			int userIdInt=Integer.parseInt(userId);
			fDAO=new FacilityHeadDAO();
			int userId=(int) request.getSession().getAttribute("userid");
			String facId=request.getParameter("facility");
			String reqDesc=request.getParameter("requestdesc");
			String severiety=request.getParameter("severiety");
			String dateString=java.time.LocalDate.now().toString();
			String[] dateStrings=dateString.split("-");
			String year=dateStrings[0];
			String month=dateStrings[1];
			String day=dateStrings[2];
			String convertedStringDte=day+"/"+month+"/"+year;
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			Date date=sdf.parse(convertedStringDte);
			java.sql.Date sqlDate=new java.sql.Date(date.getTime());
			Request userRequest=new Request(userId,facId,reqDesc,date,severiety);
			PrintWriter pw=response.getWriter();
//			pw.println("<html><body>");
//			pw.println(userId+" "+facId+" "+reqDesc+" "+severiety+" "+date+" "+sqlDate);
//			String facHeadEmail=fDAO.getEmailFromFacilityId(facId);
//			pw.println(facHeadEmail);
			rDAO=new RequestDAO();
			if(rDAO.createRequest(userRequest))
			{
				pw.println("Request Created");
				String facHeadEmail=fDAO.getEmailFromFacilityId(facId);
				SendEmailClass.sendEmail("ayushchaturvedi220@gmail.com","Request Created",reqDesc);

				SendEmailClass.sendEmail(facHeadEmail,reqDesc,"A Request has been created for your facility: "+reqDesc);
				RequestDispatcher rd = request.getRequestDispatcher("/MyRequest");
		        rd.forward(request, response);
			}
			else
			{
				request.setAttribute("errorMessage","Some error occured while creating request");
				RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage");
		        rd.forward(request, response);
			}
			
//			pw.println("</body></html>");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
