package blueLite.com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.service.*;
import blueLite.com.model.*;

//@WebServlet("/AddFinanceEntry")
public class Finance_AddPurchaseEntryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Finance_AddPurchaseEntryController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

    
        if(request.getParameter("addEntryBtn")!=null) 
        {
        	int invoiceNumber = Integer.parseInt(request.getParameter("invoiceNumber"));
        	String date = request.getParameter("date");
        	int sellerID = Integer.parseInt(request.getParameter("sellerID"));
        	String additional = request.getParameter("additional");
        	double value = Double.parseDouble(request.getParameter("value"));

            Finance_PurchaseEntry /*model*/ f1 = new Finance_PurchaseEntry(); 
            
            f1.setInvoiceNumber(invoiceNumber); 
            f1.setDate(date); 
            f1.setSellerID(sellerID);
            f1.setAdditional(additional);  
            f1.setValue(value); 
            
            Finance_AddPurchaseEntryService /*service*/ c1 = new Finance_AddPurchaseEntryService(); 
            
            String insertValidate= c1.addEntry(f1); 
            
            if(insertValidate.equals("INSERT SUCCESS")) 
            {
                request.setAttribute("InsertSuccessMsg",insertValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("2_finance_purchase-entry.jsp");
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("InsertErrorMsg",insertValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("2_finance_bill-entry.jsp");
                rd.include(request, response);
            }
        }
    }
}
