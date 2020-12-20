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

import com.ntl.dao.AssigneeDAO;
import com.ntl.dao.FacilityHeadDAO;
import com.ntl.dao.RequestDAO;
import com.ntl.model.Assignee;
import com.ntl.model.Facilities;
import com.ntl.model.Request;

/**
 * Servlet implementation class FacilityHeadHomePage
 */
@WebServlet("/FacilityHeadHomePage")
public class FacilityHeadHomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDAO rDAO;
	FacilityHeadDAO fDAO;
	AssigneeDAO aDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacilityHeadHomePage() {
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
//		PrintWriter pw=response.getWriter();
//		pw.println("<html>");
//		pw.println("<body>");
//		pw.println("<h1>Facility Head Home Page</h1>");
//		pw.println("</body>");
//		pw.println("</html>");
		
		PrintWriter pw=response.getWriter();
		int userId=(int) request.getSession().getAttribute("userid");
		rDAO=new RequestDAO();
		fDAO=new FacilityHeadDAO();
		aDAO=new AssigneeDAO();
		
		String facilityId=fDAO.getFacilityIdForFacilityHead(userId);
		ArrayList<Request> requests=new ArrayList<>();
		requests=rDAO.getRequestByFacId(facilityId);
		Iterator i=requests.iterator();
		
		ArrayList<Assignee> assignees=new ArrayList();
		assignees=aDAO.getAssigneeByFacId(facilityId);
		Iterator assigneeIterator=assignees.iterator();
		
//		String assigneeEmail="";
		pw.println();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Facility Head Home Page</title>");
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
//		pw.println("<a class='nav-link' href='/CampusHelpDesk/LogoutServlet'><span class='navbar-text'>Logout</span></a>");
		pw.println("<a class='nav-link' href='/CampusHelpDesk/LogoutServlet'><span class='navbar-text'>Logout</span></a>");
		
//		pw.println("<div class=\"collapse navbar-collapse align-right\" id=\"navbarText\">");
//		pw.println("<ul class=\"navbar-nav ml-auto\">");
//		pw.println("<li class=\"nav-item\">");
//		pw.println("<a class='nav-link' href='/CampusHelpDesk/MyRequest'>My Request</a>");
//		pw.println("</li>");
//		pw.println("<li class=\"nav-item\">");
//		pw.println("<a class='nav-link' href='/CampusHelpDesk/LogoutServlet'>Logout</a>");
//		pw.println("</li>");
//		pw.println("</ul>");
//		pw.println("</div>");
		
		pw.println("</nav>");
		pw.println("<div class='container'>");

//		pw.println("<a href='/CampusHelpDesk/RequestorHomePage' id='hometag' >Home</a>");
		pw.println("<h1 class='mt-20'>All Requests</h1>");
		pw.println("<table class=\"table table-bordered mt-20\">");
		pw.println("<thead>");
		pw.println("<tr>");
		pw.println("<th scope=\"col\">Request Id</th>");
		pw.println("<th scope=\"col\">Requestor Id</th>");
		pw.println("<th scope=\"col\">Request Description</th>");
		pw.println("<th scope=\"col\">Request Date</th>");
		pw.println("<th scope=\"col\">Response</th>");
		pw.println("<th scope=\"col\">Status</th>");
		pw.println("<th scope=\"col\">Severiety</th>");
		pw.println("<th scope=\"col\">Assignee Id</th>");
		pw.println("<th scope=\"col\">Action</th>");
		pw.println("<th scope=\"col\">Assigned To</th>");
		pw.println("</tr>");
		pw.println("</thead>");
		pw.println("<tbody>");
		while(i.hasNext())
		{
			Request userRequest=(Request) i.next();
			pw.println("<tr>");
			pw.println("<th scope='row'>"+userRequest.getRequestId()+"</th>");
			pw.println("<td>"+userRequest.getRequestorId()+"</td>");
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
//			pw.println("<td>"+userRequest.getAssigneeId()+"</td>");
			if(userRequest.getAssigneeId() !=null && !userRequest.getAssigneeId().isEmpty())
			{
				pw.println("<td>"+userRequest.getAssigneeId()+"</td>");
			}
			else
			{
				pw.println("<td> - </td>");
			}
			pw.println("<td><a href=\"/CampusHelpDesk/DeleteRequest?requestId="+userRequest.getRequestId()+" \">Close Request</a></td>");
			if(userRequest.getStatus().equals("Unassigned"))
			{
				pw.println("<td><form action='/CampusHelpDesk/AssignAssignee'>Assign to:");
				pw.println("<select name='assignee' id=\"assignee\" class=\"form-control\">");
				while(assigneeIterator.hasNext())
				{
					Assignee assignee=(Assignee) assigneeIterator.next();
					System.out.println(assignee);
//					assigneeEmail=assignee.getEmail();
					pw.println("<option class='formControl' value='"+assignee.getAssigneeId()+"'>"+assignee.getAssigneeName()+"</option>");
					System.out.println(assignee.getAssigneeId()+" "+assignee.getAssigneeName());
				}
				pw.println("</select><input type='hidden' name='requestId' value='"+userRequest.getRequestId()+"' />");
//				pw.println("<input type='hidden' name='assigneeEmail' value='"+assigneeEmail+"' />");
				pw.println("<input type='hidden' name='reqDesc' value='"+userRequest.getRequest()+"' />");
				pw.println("<input type='submit' class='btn btn-primary' value='Assign'></form></td>");
			}
			else
			{
				pw.println("<td> - </td>");
			}
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
