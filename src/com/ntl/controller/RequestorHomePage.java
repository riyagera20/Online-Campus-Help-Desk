package com.ntl.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ntl.dao.RequestDAO;
import com.ntl.model.Facilities;

/**
 * Servlet implementation class RequestorHomePage
 */
@WebServlet("/RequestorHomePage")
public class RequestorHomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDAO requestDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestorHomePage() {
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
		requestDAO=new RequestDAO();
		ArrayList<Facilities> facilities=new ArrayList<>();
		facilities=requestDAO.getFacilities();
		Iterator i=facilities.iterator();
		PrintWriter pw=response.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Requestor Home Page</title>");
		pw.println("<link href=\"lib/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">");
		pw.println("<link href=\"lib/ionicons/css/ionicons.min.css\" rel=\"stylesheet\">");
		pw.println("<link href=\"css/SeeFacilities.css\" rel=\"stylesheet\">");
//		pw.println("<link rel=\"stylesheet\" href=\"css/loginForm.css\">");
		pw.println("<link rel=\"stylesheet\" href=\"css/styleP.css\">");
		pw.println("<link href='css/userHomePage.css' rel='stylesheet' />");
		pw.println("<script src=\"js/styleP.js\"></script>");
		pw.println("<script src=\"https://kit.fontawesome.com/a076d05399.js\"></script>");
		pw.println("<script src=\"lib/bootstrap/js/bootstrap.min.js\"></script>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">");
		pw.println("<a class=\"navbar-brand\" href=\"#\">");
		pw.println("<img src=\"lib/images/iec-logo.png\" id=\"imgNav\" class=\"d-inline-block align-top\" alt=\"\">");
		pw.println("<div class=\"d-inline-block align-top\" style=\"margin-top: 10px\">ABCD College of Engineering And Technology</div>");
		pw.println("</a>");
//		pw.println("<a class='nav-link' href='#services'><span class='navbar-text'>Facilities</span></a>");
//		pw.println("<a class='nav-link' href='#form'><span class='navbar-text'>Contact-us</span></a>");
//		pw.println("<a class='nav-link' href='/CampusHelpDesk/MyRequest'><span class='navbar-text'>My Request</span></a>");
//		pw.println("<a class='nav-link' href='/CampusHelpDesk/MyRequest'><span class='navbar-text'>Logout</span></a>");
//		pw.println("<span class=\"navbar-text\">");
		pw.println("<div class=\"collapse navbar-collapse align-right\" id=\"navbarText\">");
		pw.println("<ul class=\"navbar-nav ml-auto\">");
		pw.println("<li class=\"nav-item\">");
		pw.println("<a class='nav-link' href='#services'>Facilities</a>");
		pw.println("</li>");
		pw.println("<li class=\"nav-item\">");
		pw.println("<a class='nav-link' href='#contact'>Contact-us</a>");
		pw.println("</li>");
		pw.println("<li class=\"nav-item\">");
		pw.println("<a class='nav-link' href='/CampusHelpDesk/MyRequest'>My Request</a>");
		pw.println("</li>");
		pw.println("<li class=\"nav-item\">");
		pw.println("<a class='nav-link' href='/CampusHelpDesk/LogoutServlet'>Logout</a>");
		pw.println("</li>");
		pw.println("</ul>");
		pw.println("</div>");
//		pw.println("</span>");
		pw.println("</nav>");
//		pw.println("<h1>Requestor Home Page</h1>");
//		pw.println("<form method='get' action='http://localhost:8585/CampusHelpDesk/CreateRequest'>");
//		pw.println("<input type='submit' value='Create Request' />");
//		pw.println("</form>");
		pw.println("<div class=\"container-fluid\" id=\"createRequest\">");
		pw.println("<div class=\"row\">");
		pw.println("<div class=\"col-lg-6 justify-content-center \">");
		pw.println("<h1 id=\"h1text1\">Campus HelpDesk</h1>");
		pw.println("<h2 class=\"h2text\" style=\"margin-top: 100px\">Stuck somewhere,</h2>");
		pw.println("<h2 class=\"h2text\">We Are here to help you.</h2>");
		pw.println("<form method='get' action='http://localhost:8585/CampusHelpDesk/CreateRequest'>");
		pw.println("<button id=\"createRequestButton\" class=\"btn btn-primary btn-lg\" type=\"submit\">Create Request</button>");
		pw.println("</form>");
		pw.println("</div>");
		pw.println("<div class=\"col-lg-6 justify-content-center\">");
		pw.println("<img src=\"lib/images/clip-hardworking-man.png\" id=\"imgCreateRequest\"  align=\"center\" alt=\"help-desk-picture\">");
		pw.println("</div>");
		pw.println("</div>");
		pw.println("</div>");
		pw.println("<section id=\"services\" class=\"section-bg justify-content-center\">");
		pw.println("<div class=\"container justify-content-center\">");
		pw.println("<h3><center>Facilities</center></h3>");
		pw.println("<p><center>Facilities Available in our Campus</center></p>");
		pw.println("</header>");
		pw.println("<div class=\"row justify-content-center\">");
		
		//BufferedImage img=ImageIO.read(new File("lib/images/class.png"));
		
		while(i.hasNext())
		{
			Facilities facility=(Facilities) i.next();
		pw.println("<div class=\"col-md-6 col-lg-5  wow bounceInUp\" data-wow-duration=\"1.4s\">");
		pw.println("<div class=\"box\">");
//		pw.println("<div class=\"icon\"><img src=\"ion-ios-clock-outline\" style=\"color: #ff689b;\"></div>");
		pw.println("<h4 class=\"title\"><a href=\"\">"+facility.getFacilityname()+"</a></h4>");
		pw.println("<p class=\"description\">"+facility.getFacilityDescription()+"</p>");
		pw.println("</div>");
		pw.println("</div>");
		}
		pw.println("</div>");
		pw.println("</div>");
		pw.println("</section>");
		pw.println("<section id='contact'>");
		pw.println("<div id=\"form\">");
		pw.println("<h1>Contact us</h1>");
		pw.println("<div class=\"fish\" id=\"fish\"></div>");
		pw.println("<div class=\"fish\" id=\"fish2\"></div>");
		pw.println("<form id=\"waterform\" method=\"post\" action='/CampusHelpDesk/ContactUsServlet'>");
		pw.println("<div class=\"formgroup\" id=\"name-form\">");
		pw.println("<label for=\"name\">Your name*</label>");
		pw.println("<input type=\"text\" id=\"name\" name=\"name\" />");
		pw.println("</div>");
		pw.println("<div class=\"formgroup\" id=\"email-form\">");
		pw.println("<label for=\"email\">Your e-mail*</label>");
		pw.println("<input type=\"email\" id=\"email\" name=\"email\" />");
		pw.println("</div>");
		pw.println("<div class=\"formgroup\" id=\"message-form\">");
		pw.println("<label for=\"message\">Your message</label>");
		pw.println("<textarea id=\"message\" name=\"message\"></textarea>");
		pw.println("</div>");
		pw.println("<input type=\"submit\" value=\"Send your message!\" />");
		pw.println("</form>");
		pw.println("</div>");
		pw.println("</section>");
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
