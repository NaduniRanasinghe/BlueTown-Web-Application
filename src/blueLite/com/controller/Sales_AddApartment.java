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
public class Sales_AddApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Sales_AddApartment() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 if(request.getParameter("btn_add")!=null) 
	        {
	            String apartmentname=request.getParameter("apartmentname"); 
	            String apartment_id=request.getParameter("apartment_id"); 
	            String site=request.getParameter("site"); 
	            String type =request.getParameter("type");
	            String number=request.getParameter("number");
	           String squreft=request.getParameter("squreft");
	       
	       
	            
	            Sales_Apartment apart = new Sales_Apartment();  
	            
	          apart.setApartmentname(apartmentname);
	          apart.setId(Integer.parseInt(apartment_id));
	          apart.setSite(site);
	          apart.setType(type);
	          apart.setNumber(Integer.parseInt(number));
	          apart.setSqureft(Double.parseDouble(squreft));
	        
	           Sales_AddApartmentDao addApart= new Sales_AddApartmentDao();
	           String insertValidate=addApart.checkInsert(apart); 
	            
	            if(insertValidate.equals("INSERT SUCCESS")) 
	            {
	                request.setAttribute("InsertSuccessMsg",insertValidate); 
	                RequestDispatcher rd=request.getRequestDispatcher("5_Sales_addExtraFeaturesNew.jsp");
	                rd.forward(request, response);
	            }
	            else
	            {
	                request.setAttribute("InsertErrorMsg",insertValidate); 
	                RequestDispatcher rd=request.getRequestDispatcher("5_Sales_addApartmentNew.jsp");
	                rd.include(request, response);
	            }
	            
	        }
	    }
	}



















