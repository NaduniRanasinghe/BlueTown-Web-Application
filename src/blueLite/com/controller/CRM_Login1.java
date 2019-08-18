package blueLite.com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blueLite.com.model.CRM_login;
//import blueLite.com.model.Employee;
import blueLite.com.service.CRM_loginService;


//import java.io.IOException;




/**
 * Servlet implementation class Login1
 */
//@WebServlet("/Login1")
public class CRM_Login1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRM_Login1() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
			String nic =  request.getParameter("nic");
			String pass = request.getParameter("pass");
			
			System.out.println(nic);
			CRM_login obj2 = new CRM_login();
			
			//Employee emp = new Employee();
			
			obj2.setNic(nic);
			obj2.setPassword(pass);
			
		/*	emp.setNic(nic);
			emp.setPassword(pass); */
			
			try {
			CRM_loginService ls = new CRM_loginService();
			String result;
			
			result = ls.loginUserService(obj2);
			
			// System.out.println(result);
			if(result.equals("SUCCESS") )
			{
		
				HttpSession session = request.getSession(true);       
		        session.setAttribute("currentSessionUser",obj2); 
		        System.out.println(result);
		        RequestDispatcher rd=request.getRequestDispatcher("3_CRM_welcomeCus.jsp");
	            rd.include(request, response);    
			}
			
			else if(result.equals("HRManager"))
			{
				
				HttpSession session = request.getSession(true);       
		        session.setAttribute("currentSessionUser",obj2); 
		        System.out.println(result);
		        RequestDispatcher rd=request.getRequestDispatcher("1_HR_HR.jsp");
	            rd.include(request, response);    
			}
			else if(result.equals("SiteManager"))
			{
				
				HttpSession session = request.getSession(true);       
		        session.setAttribute("currentSessionUser",obj2); 
		        System.out.println(result);
		        RequestDispatcher rd=request.getRequestDispatcher("8_Site_site-manager-profile.jsp");
	            rd.include(request, response);    
			}
			
			else if(result.equals("ORManager"))
			{
				
				HttpSession session = request.getSession(true);       
		        session.setAttribute("currentSessionUser",obj2); 
		        System.out.println(result);
		        RequestDispatcher rd=request.getRequestDispatcher("6_ORM_Managerprofile.jsp");
	            rd.include(request, response);    
			}
			
			else if(result.equals("FinanceManager"))
			{
				
				HttpSession session = request.getSession(true);       
		        session.setAttribute("currentSessionUser",obj2); 
		        System.out.println(result);
		        RequestDispatcher rd=request.getRequestDispatcher("2_finance_finance-manager-profile.jsp");
	            rd.include(request, response);    
			}
			
			else if(result.equals("SalesManager"))
			{
				
				HttpSession session = request.getSession(true);       
		        session.setAttribute("currentSessionUser",obj2); 
		        System.out.println(result);
		        RequestDispatcher rd=request.getRequestDispatcher("5_Sales_saleManagerUI.jsp");
	            rd.include(request, response);    
			}
			
			else if(result.equals("MarketingManager"))
			{
				
				HttpSession session = request.getSession(true);       
		        session.setAttribute("currentSessionUser",obj2); 
		        System.out.println(result);
		        RequestDispatcher rd=request.getRequestDispatcher("7_Event_eventProfile.jsp");
	            rd.include(request, response);    
			}
			else if(result.equals("InventoryManager"))
			{
				
				HttpSession session = request.getSession(true);       
		        session.setAttribute("currentSessionUser",obj2); 
		        System.out.println(result);
		        RequestDispatcher rd=request.getRequestDispatcher("4_IL_inventory_logistics_profile.jsp");
	            rd.include(request, response);    
			}
			
			else if(result.equals("HRExecutive"))
			{
				
				HttpSession session = request.getSession(true);       
		        session.setAttribute("currentSessionUser",obj2); 
		        System.out.println(result);
		        RequestDispatcher rd=request.getRequestDispatcher("1_HR_EmpUI.jsp");
	            rd.include(request, response);    
			}
			
			
			else 
			{
				RequestDispatcher rd=request.getRequestDispatcher("3_CRM_login.jsp");
	            rd.include(request, response);
			}
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}

}
