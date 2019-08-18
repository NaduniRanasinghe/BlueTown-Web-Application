package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.service.CRM_mailService;

/**
 * Servlet implementation class email
 */
@WebServlet("/email")
public class CRM_email extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html;charset=UTF-8");
		
		String to = request.getParameter("To");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		String from = "gunanandaroshan@gmail.com";
		String username = "gunanandaroshan";
		String password = "roshan123";
		
		CRM_mailService.send(from, username, password, to, subject, message);
		CRM_mailService sendMail = new CRM_mailService();
		Boolean sending = sendMail.send(from, username, password, to, subject, message); 
		
		if(sending.equals(true)) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("mailscuss.jsp");
		dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("email.jsp");
            rd.include(request, response);
		}
	}

}