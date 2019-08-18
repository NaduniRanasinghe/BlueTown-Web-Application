package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.CRM_register;
import blueLite.com.service.CRM_registerServices;


//@WebServlet("/registration")
public class CRM_registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CRM_registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	
		 String nic = request.getParameter("nic");
		 String firstName = request.getParameter("fname");
		 String lastName = request.getParameter("lname");
		 String email = request.getParameter("email");
		 String mobile = request.getParameter("mobile");
		 String address1 = request.getParameter("address1");
		 String address2 = request.getParameter("address2");
		 String city = request.getParameter("city"); 
		 String gender = request.getParameter("radio");
		 String apartmenttype =request.getParameter("apartmenttype");
		 String site = request.getParameter("site");
		 String password = request.getParameter("password");
		 
		
		 CRM_register register1 = new CRM_register();

		
		 register1.setNic(nic);
		 register1.setFname(firstName);
		 register1.setLname(lastName);
		 register1.setEmail(email);
		 register1.setMobile(mobile);
		 register1.setAddress1(address1);
		 register1.setAddress2(address2);
		 register1.setCity(city);
		 register1.setGender(gender);
		 register1.setApartmenttype(apartmenttype);
		 register1.setSite(site);
		 register1.setPassword(password);
		 
		 
		
		 System.out.println(firstName);
		 System.out.println(register1.getEmail());
		 
		 
		CRM_registerServices rdao = new CRM_registerServices();
		rdao.registerUser(register1);
		
		 
	 
		 
		 try {
		RequestDispatcher rs = request.getRequestDispatcher("3_CRM_succuss.jsp");  
		rs.forward(request, response);  
		
		} catch (Exception e) {  
		e.printStackTrace();  


		 
		}

	}
}
