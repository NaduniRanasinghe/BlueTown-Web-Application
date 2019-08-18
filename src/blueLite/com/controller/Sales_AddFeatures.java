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
public class Sales_AddFeatures extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Sales_AddFeatures() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 if(request.getParameter("btn_add")!=null) 
	        {
	            
	            String apartmentId=request.getParameter("apartmentId"); 
	            String room=request.getParameter("room"); 
	            String bathroom =request.getParameter("bathroom");
	            String CCTV=request.getParameter("CCTV");
	           String sRoom=request.getParameter("sRoom");
	          
	       
	       
	            
	            Sales_Features features =new Sales_Features();  
	            
	            features.setApartmentId(Integer.parseInt(apartmentId));
	            features.setRoom(room);
	            features.setBathroom(bathroom);
	            features.setCCTV(CCTV);
	            features.setsRoom(sRoom);
	          
	            
	            
	            
	           Sales_AddFeaturesDao addFeatures= new  Sales_AddFeaturesDao();
	           String insertValidate=addFeatures.checkInsert(features); 
	            
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



















