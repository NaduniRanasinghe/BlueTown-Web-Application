package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.Finance_BillEntry;
import blueLite.com.service.Finance_EditBillEntryService;

/**
 * Servlet implementation class EditBillEntryController
 */
//@WebServlet("/EditBillEntryController")
public class Finance_EditBillEntryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("edit") != null) {
			
			int billNumber = Integer.parseInt(request.getParameter("billNumber"));
        	String type = request.getParameter("type");
        	String billDate = request.getParameter("billDate");
        	String dueDate = request.getParameter("dueDate");
        	String additional = request.getParameter("additional");
        	double payment = Double.parseDouble(request.getParameter("payment"));
        	int hidden_id = Integer.parseInt(request.getParameter("hidden_id"));
			
			Finance_BillEntry re = new Finance_BillEntry();
			
			re.setBillNumber(billNumber);
            re.setType(type); 
            re.setBillDate(billDate);
            re.setDueDate(dueDate);  
            re.setAdditional(additional); 
            re.setPayment(payment);
            re.setHidden_id(hidden_id);
			
			Finance_EditBillEntryService dao = new Finance_EditBillEntryService();
			String updateValidate = dao.checkUpdate(re);
			
			if(updateValidate.equals("Update Successful")){
				request.setAttribute("UpdateSuccessMsg", updateValidate);
				RequestDispatcher rd = request.getRequestDispatcher("2_finance_bill-information-portal.jsp");
				rd.forward(request,response);
			}
			else
				request.setAttribute("UpdateSuccessMsg", updateValidate);
			    RequestDispatcher rd = request.getRequestDispatcher("2_finance_bill-edit.jsp");
			    rd.include(request,response);
		}
	}

}
