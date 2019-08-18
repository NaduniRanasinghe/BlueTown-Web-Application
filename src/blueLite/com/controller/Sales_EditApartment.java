package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.Sales_Apartment;
import blueLite.com.service.Sales_EditApartmentDao;


//@WebServlet("/EditApartment")
public class Sales_EditApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Sales_EditApartment() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		

        if(request.getParameter("btn_edit")!=null) 
        {	
        	 	String apartmentname=request.getParameter("apartmentname"); 
	            String apartment_id=request.getParameter("apartment_id"); 
	            String site=request.getParameter("site"); 
	            String type =request.getParameter("type");
	            String number=request.getParameter("number");
	            String squreft=request.getParameter("squreft");
	            int hidden_id=Integer.parseInt(request.getParameter("hidden_id")); 
            
            Sales_Apartment apart=new Sales_Apartment();  
            
	          apart.setApartmentname(apartmentname);
	          apart.setApartmentId(Integer.parseInt(apartment_id));
	          apart.setSite(site);
	          apart.setType(type);
	          apart.setNumber(Integer.parseInt(number));
	          apart.setSqureft(Double.parseDouble(squreft));
	          apart.setId(hidden_id);
            
            Sales_EditApartmentDao editDao=new Sales_EditApartmentDao();
            
            String updateValidate=editDao.checkUpdate(apart); 
            
            if(updateValidate.equals("UPDATE SUCCESS")) 
            {
                request.setAttribute("UpdateSuccessMsg",updateValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("5_Sales_ApartmentInformationPortal.jsp");
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("UpdateErrorMsg",updateValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("5_Sales_addApartmentNew.jsp");
                rd.include(request, response);
            }
        }
	}

}
