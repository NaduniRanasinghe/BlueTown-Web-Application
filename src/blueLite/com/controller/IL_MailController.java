package blueLite.com.controller;

import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.service.HR_SendMail;

/**
 * Servlet implementation class MailController
 */
@WebServlet("/IL_MailController")
public class IL_MailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String to = request.getParameter("To");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		String from = "gunanandaroshan@gmail.com";
		String username = "gunanandaroshan";
		String password = "roshan123";
		
		HR_SendMail.send(from, username, password, to, subject, message);
		HR_SendMail sendMail = new HR_SendMail();
		Boolean sending = sendMail.send(from, username, password, to, subject, message); 
		
		if(sending.equals(true)) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("raw_material_table.jsp");
		dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("email.jsp");
            rd.include(request, response);
		}
	}

}
