package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import blueLite.com.model.*;
import blueLite.com.service.*;



//@WebServlet("/AddApartment")
public class Sales_AddCost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Sales_AddCost() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 if(request.getParameter("btn_add")!=null) 
	        {
	            
	            String apartmentId=request.getParameter("id"); 
	            String type=request.getParameter("type"); 
	            String cost=request.getParameter("cost");
	       
	            
	            Sales_cost fcost=new Sales_cost();  
	            
	            fcost.setId(Integer.parseInt(apartmentId));
	            fcost.setCost(Double.parseDouble(cost));
	            fcost.setType(type);
	            
	            
	            
	            
	           Sales_AddCostDao addcost= new  Sales_AddCostDao();
	           String insertValidate=addcost.checkInsert(fcost); 
	            
	            if(insertValidate.equals("INSERT SUCCESS")) 
	            {
	                request.setAttribute("InsertSuccessMsg",insertValidate); 
	                RequestDispatcher rd=request.getRequestDispatcher("5_Sales_addSalesNew.jsp");
	                rd.forward(request, response);
	            }
	            else
	            {
	                request.setAttribute("InsertErrorMsg",insertValidate); 
	                RequestDispatcher rd=request.getRequestDispatcher("5_Sales_addExtraFeaturesNew.jsp");
	                rd.include(request, response);
	            }
	            
	        }
	    }
	}



















