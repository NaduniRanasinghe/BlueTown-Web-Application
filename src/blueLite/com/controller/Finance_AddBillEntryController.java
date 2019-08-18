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
public class Finance_AddBillEntryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Finance_AddBillEntryController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

    
        if(request.getParameter("addEntryBtn")!=null) 
        {
        	int billNumber = Integer.parseInt(request.getParameter("billNumber"));
        	String type = request.getParameter("type");
        	String billDate = request.getParameter("billDate");
        	String dueDate = request.getParameter("dueDate");
        	String additional = request.getParameter("additional");
        	double payment = Double.parseDouble(request.getParameter("payment"));

            Finance_BillEntry /*model*/ f1 = new Finance_BillEntry(); 
            
            f1.setBillNumber(billNumber); 
            f1.setType(type); 
            f1.setBillDate(billDate);
            f1.setDueDate(dueDate);  
            f1.setAdditional(additional); 
            f1.setPayment(payment);
            
            Finance_AddBillEntryService /*service*/ c1 = new Finance_AddBillEntryService(); 
            
            String insertValidate= c1.addEntry(f1); 
            
            if(insertValidate.equals("INSERT SUCCESS")) 
            {
                request.setAttribute("InsertSuccessMsg",insertValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("2_finance_bill-information-portal.jsp");
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
