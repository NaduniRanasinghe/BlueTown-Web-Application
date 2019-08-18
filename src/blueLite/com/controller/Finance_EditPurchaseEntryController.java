package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.Finance_PurchaseEntry;
import blueLite.com.service.Finance_EditPurchaseEntryService;

/**
 * Servlet implementation class EditPurchaseEntryController
 */
//@WebServlet("/EditPurchaseEntryController")
public class Finance_EditPurchaseEntryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("edit") != null) {
			
			int invoiceNumber = Integer.parseInt(request.getParameter("invoiceNumber"));
        	String date = request.getParameter("date");
        	int sellerID = Integer.parseInt(request.getParameter("sellerID"));
        	String additional = request.getParameter("additional");
        	double value = Double.parseDouble(request.getParameter("value"));
        	int hidden_id = Integer.parseInt(request.getParameter("hidden_id"));
			
        	
			Finance_PurchaseEntry re = new Finance_PurchaseEntry();
			
			re.setInvoiceNumber(invoiceNumber);
			re.setDate(date);
			re.setSellerID(sellerID);
			re.setAdditional(additional);
			re.setValue(value);
			re.setHidden_id(hidden_id);
			
		
			Finance_EditPurchaseEntryService dao = new Finance_EditPurchaseEntryService();
			String updateValidate = dao.checkUpdate(re);
			
			if(updateValidate.equals("Update Successful")){
				request.setAttribute("UpdateSuccessMsg", updateValidate);
				RequestDispatcher rd = request.getRequestDispatcher("2_finance_purchase-information-portal.jsp");
				rd.forward(request,response);
			}
			else
				request.setAttribute("UpdateSuccessMsg", updateValidate);
			    RequestDispatcher rd = request.getRequestDispatcher("2_finance_purchase-edit.jsp");
			    rd.include(request,response);
		}
	}

}
