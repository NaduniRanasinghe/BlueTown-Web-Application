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



//@WebServlet("/AddSales")
public class Sales_EditSales extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

    public Sales_EditSales() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		
		 if(request.getParameter("btn_edit")!=null) 
	        {
	            String saleId=request.getParameter("saleId"); 
	            String totPay=request.getParameter("totPay"); 
	            String intPay=request.getParameter("intPay"); 
	            String instlCount =request.getParameter("instlCount");
	            String cusId=request.getParameter("cusId");
	            int hidden_id=Integer.parseInt(request.getParameter("hidden_id"));
	          
	           
	       
	       
	            
	            Sales_Sales sale=new Sales_Sales();  
	            
	          sale.setSaleId(Integer.parseInt(saleId));
	          sale.setTotPay(Double.parseDouble(totPay));
	          sale.setIntPay(Double.parseDouble(intPay));
	          sale.setInstlCount(Integer.parseInt(instlCount));
	          sale.setCusId(Integer.parseInt(cusId));
	          sale.setId(hidden_id);
	          
	        
	           Sales_EditSalesDao addSale= new Sales_EditSalesDao();
	           String insertValidate=addSale.checkInsert(sale); 
	            
	            if(insertValidate.equals("INSERT SUCCESS")) 
	            {
	                request.setAttribute("InsertSuccessMsg",insertValidate); 
	                RequestDispatcher rd=request.getRequestDispatcher("5_Sales_salesInformationPortal.jsp");
	                rd.forward(request, response);
	            }
	            else
	            {
	                request.setAttribute("InsertErrorMsg",insertValidate); 
	                RequestDispatcher rd=request.getRequestDispatcher("5_Sales_addSalesNew.jsp");
	                rd.include(request, response);
	            }
	            
	        }
	    }
	}



















