package com.ntl.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForgetPassword
 */
@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPassword() {
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
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset=\"utf-8\">");
		pw.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		pw.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		pw.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">");
		pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
		pw.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>");
		pw.println("<link href=\"css/forgetpassword.css\" rel=\"stylesheet\">");
		pw.println("</head>");
		pw.println("<body>");
//		pw.println("<form method='get' action='/CampusHelpDesk/ForgetPasswordOTP'>");
//		pw.println("<input type='text' name='email' />");
//		pw.println("<input type='submit' value='Send OTP' />");
//		pw.println("</form>");
		
		pw.println("<nav class=\"navbar navbar-dark bg-dark\">");
		pw.println("<a class=\"navbar-brand\" href=\"#\">");
		pw.println("<img src=\"iec-logo.png\" id=\"imgNav\" class=\"d-inline-block align-top\" alt=\"\">");
		pw.println("<div class=\"d-inline-block align-top\" style=\"margin-top: 10px;margin-left: 5px\">IEC College of Engineering And Technology</div>");
		pw.println("</a>");
		pw.println("</nav>");
		pw.println("<div class=\"container h-100\">");
		pw.println("<section>");
		pw.println("<div class=\"card offset-md-2 mx-auto my-auto\">");
		pw.println("<div class=\"card-header text-center\">");
		pw.println("<h3>Forget  Password</h3>");
		pw.println("</div>");
		pw.println("<div class=\"card-body align-center\">");
		pw.println("<br><br>");
		pw.println("<form method='get' action='/CampusHelpDesk/ForgetPasswordOTP' data-toggle=\"validator\">");
		pw.println("<div class=\"form-group row justify-content-center\">");
		pw.println("<label for=\"email\" class=\"col-sm-3 col-form-label\">Enter Email:</label>");
		pw.println("<div class=\"col-sm-4\">");
		pw.println("<input type=\"Email\" name=\"email\" class=\"form-control\" id=\"email\" required/>");
		pw.println("</div></div>");
		pw.println("<div class=\"row form-group justify-content-left\">");
		pw.println("<div class=\"col-sm-5 \">");
		pw.println("</div>");
		pw.println("<div class=\"col-sm-5 \">");
		pw.println("<button type=\"submit\" class=\"btn btn-primary\">Send OTP</button>");
		pw.println("</div></div>");
		pw.println("</form>");
		pw.println("</div></div>");
		pw.println("</section>");
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
