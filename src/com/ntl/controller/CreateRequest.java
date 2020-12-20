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

/**
 * Servlet implementation class CreateRequest
 */
@WebServlet("/CreateRequest")
public class CreateRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDAO rDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateRequest() {
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
		rDAO=new RequestDAO();
		ArrayList<Facilities> facilities=new ArrayList<>();
		facilities=rDAO.getFacilities();
		Iterator i=facilities.iterator();
//		String userId=(String) request.getSession().getAttribute("userid");
//		int userIdInt=Integer.parseInt(userId);
		int userId=(int) request.getSession().getAttribute("userid");
		PrintWriter pw=response.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset=\"utf-8\">");
		pw.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		pw.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		pw.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">");
		pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
		pw.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>");
		pw.println("<link href=\"css/createpass.css\" rel=\"stylesheet\">");
		pw.println("</head>");
		pw.println("<body>");
//		pw.println("<h1>"+userId+"</h1>");
//		pw.println("<form method='get' action='http://localhost:8585/CampusHelpDesk/SubmitRequest'>");
//		pw.println("<select name='facility'>");
//		while(i.hasNext())
//		{
//			Facilities facility=(Facilities) i.next();
//			pw.println("<option value='"+facility.getFacilityId()+"'>"+facility.getFacilityname()+"</option>");
//		}
//		pw.println("</select>");
//		pw.println("<input type='text' name='requestdesc' />");
//		pw.println("<select name='severiety'>");
//		pw.println("<option value='Low'>Low</option>");
//		pw.println("<option value='Medium'>Medium</option>");
//		pw.println("<option value='High'>High</option>");
//		pw.println("</select>");
//		pw.println("<input type='submit' value='Submit Request' />");
		
		pw.println("<nav class=\"navbar navbar-dark bg-dark\">");
		pw.println("<a class=\"navbar-brand\" href=\"#\">");
		pw.println("<img src=\"lib/images/iec-logo.png\" id=\"imgNav\" class=\"d-inline-block align-top\" alt=\"\">");
		pw.println("<div class=\"d-inline-block align-top\" style=\"margin-top: 10px;margin-left: 5px\">IEC College of Engineering And Technology</div>");
		pw.println("</a>");
		pw.println("</nav>");
		pw.println("<div class=\"container mb-lg-20\">");
		pw.println("<section>");
		pw.println("<div class=\"card mx-auto\">");
		pw.println("<div class=\"card-header text-center\">");
		pw.println("<h3>Create Request</h3>");
		pw.println("</div>");
		pw.println("<div class=\"card-body align-center\"><br><br>");
		pw.println("<form method='get' action='http://localhost:8585/CampusHelpDesk/SubmitRequest' data-toggle=\"validator\">");
		pw.println("<div class=\"form-group row justify-content-center\">");
		pw.println("<label for=\"RequestorId\" class=\"col-sm-3 control-label\">Requestor Id:</label>");
		pw.println("<div class=\"col-sm-5\">");
		pw.println("<input type=\"text\" name=\"RequestorId\" class=\"form-control\" id=\"RequestorId\" value='"+userId+"' required/>");
		pw.println("</div></div>");
		pw.println("<div class=\"form-group row justify-content-center\">");
		pw.println("<label for=\"facility\" class=\"col-sm-3 control-label\">Facility:</label>");
		pw.println("<div class=\"col-sm-5\">");
		pw.println("<select name='facility' id=\"facility\" class=\"form-control\">");
		while(i.hasNext())
		{
			Facilities facility=(Facilities) i.next();
			pw.println("<option value='"+facility.getFacilityId()+"'>"+facility.getFacilityname()+"</option>");
		}
		pw.println("</select>");
		pw.println("</div></div>");
		pw.println("<div class=\"form-group row justify-content-center\">");
		pw.println("<label for=\"severiety\" class=\"col-sm-3 control-label\">Severity:</label>");
		pw.println("<div class=\"col-sm-5\">");
		pw.println("<select name=\"severiety\" id=\"severiety\" class=\"form-control\">");
		pw.println("<option value='Low'>Low</option>");
		pw.println("<option value='Medium'>Medium</option>");
		pw.println("<option value='High'>High</option>");
		pw.println("</select>");
		pw.println("</div></div>");
		pw.println("<div class=\"form-group row justify-content-center\">");
		pw.println("<label for=\"requestdesc\" class=\"col-sm-3 control-label\">Description:</label>");
		pw.println("<div class=\"col-sm-5\">");
		pw.println("<textarea name=\"requestdesc\" class=\"form-control\" id=\"requestdesc\" ></textarea>");
		pw.println("</div></div>");
		pw.println("<div class=\"row form-group justify-content-center\">");
		pw.println("<div class=\"col-sm-5 \">");
		pw.println("</div>");
		pw.println("<div class=\"col-sm-5 \">");
		pw.println("<button type=\"submit\" class=\"btn btn-primary\">Submit</button>");
		pw.println("</div></div>");
		pw.println("</form>");
		pw.println("</div></div>");
		pw.println("</section>");
		pw.println("</div>");
		pw.println("</body></html>");
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
