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
public class Finance_AddFinanceEntryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Finance_AddFinanceEntryController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

    
        if(request.getParameter("btn_add")!=null) 
        {
            int year = Integer.parseInt(request.getParameter("year")); 
            String month = request.getParameter("month");
            String review = request.getParameter("review");
            double revenue = Double.parseDouble(request.getParameter("revenue"));

            Finance_FinanceEntry /*model*/ f1 = new Finance_FinanceEntry(); 
            
            f1.setYear(year); 
            f1.setMonth(month); 
            f1.setReview(review);
            f1.setRevenue(revenue);      
            
            Finance_AddFinanceEntryService /*service*/ c1 = new Finance_AddFinanceEntryService(); 
            
            String insertValidate= c1.addEntry(f1); 
            
            if(insertValidate.equals("INSERT SUCCESS")) 
            {
                request.setAttribute("InsertSuccessMsg",insertValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("2_finance_revenue-information-portal.jsp");
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("InsertErrorMsg",insertValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("2_finance_revenue-entry.jsp");
                rd.include(request, response);
            }
        }
    }
}
