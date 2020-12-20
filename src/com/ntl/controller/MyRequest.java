package com.ntl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ntl.dao.RequestDAO;
import com.ntl.model.Facilities;
import com.ntl.model.Request;

/**
 * Servlet implementation class MyRequest
 */
@WebServlet("/MyRequest")
public class MyRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDAO rDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyRequest() {
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
		PrintWriter pw=response.getWriter();
		int userId=(int) request.getSession().getAttribute("userid");
		rDAO=new RequestDAO();
		ArrayList<Request> requests=new ArrayList<>();
		requests=rDAO.getRequestById(userId);
		Iterator i=requests.iterator();
		pw.println();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Requestor Home Page</title>");
		pw.println("<link href=\"lib/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">");
		pw.println("<link href=\"lib/ionicons/css/ionicons.min.css\" rel=\"stylesheet\">");
		pw.println("<link href=\"css/SeeFacilities.css\" rel=\"stylesheet\">");
		pw.println("<script src=\"lib/bootstrap/js/bootstrap.min.js\"></script>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<nav class=\"navbar navbar-dark bg-dark\">");
		pw.println("<a class=\"navbar-brand\" href=\"#\">");
		pw.println("<img src=\"lib/images/iec-logo.png\" id=\"imgNav\" class=\"d-inline-block align-top\" alt=\"\">");
		pw.println("<div class=\"d-inline-block align-top\" style=\"margin-top: 10px\">ABCD College of Engineering And Technology</div>");
		pw.println("</a>");
		pw.println("<a class='nav-link' href='/CampusHelpDesk/LogoutServlet'><span class='navbar-text'>Logout</span></a>");
		pw.println("</nav>");
		pw.println("<div class='container'>");

		pw.println("<a href='/CampusHelpDesk/RequestorHomePage' id='hometag' >Home</a>");
		pw.println("<h1 class='mt-20'>My Requests</h1>");
		pw.println("<table class=\"table table-bordered mt-20\">");
		pw.println("<thead>");
		pw.println("<tr>");
		pw.println("<th scope=\"col\">Request Id</th>");
		pw.println("<th scope=\"col\">Facility Id</th>");
		pw.println("<th scope=\"col\">Request Description</th>");
		pw.println("<th scope=\"col\">Request Date</th>");
		pw.println("<th scope=\"col\">Response</th>");
		pw.println("<th scope=\"col\">Status</th>");
		pw.println("<th scope=\"col\">Severiety</th>");
		pw.println("<th scope=\"col\">Action</th>");
		pw.println("</tr>");
		pw.println("</thead>");
		pw.println("<tbody>");
		while(i.hasNext())
		{
			Request userRequest=(Request) i.next();
			pw.println("<tr>");
			pw.println("<th scope='row'>"+userRequest.getRequestId()+"</th>");
			pw.println("<td>"+userRequest.getFacilityId()+"</td>");
			pw.println("<td>"+userRequest.getRequest()+"</td>");
			pw.println("<td>"+userRequest.getRequestDate()+"</td>");
			if(userRequest.getResponse() !=null && !userRequest.getResponse().isEmpty())
			{
				pw.println("<td>"+userRequest.getResponse()+"</td>");
			}
			else
			{
				pw.println("<td> - </td>");
			}
			pw.println("<td>"+userRequest.getStatus()+"</td>");
			pw.println("<td>"+userRequest.getSeveriety()+"</td>");
			pw.println("<td><a href=\"/CampusHelpDesk/DeleteRequest?requestId="+userRequest.getRequestId()+" \">Close Request</a></td>");
			pw.println("</tr>");
		}
		pw.println("</tbody>");
		pw.println("</table>");
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</html>");
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
