package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.Finance_RevenueEntry;
import blueLite.com.service.Finance_EditRevenueEntryService;

/**
 * Servlet implementation class EditFinanceEntryController
 */
//@WebServlet("/EditFinanceEntryController")
public class Finance_EditFinanceEntryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("edit") != null) {
			
			int Year = Integer.parseInt(request.getParameter("year"));
			String Month = request.getParameter("month");
			String Review = request.getParameter("review");
			Double Revenue = Double.parseDouble(request.getParameter("revenue"));
			int hidden_id = Integer.parseInt(request.getParameter("hidden_id"));
			
			Finance_RevenueEntry re = new Finance_RevenueEntry();
			
			re.setYear(Year);
			re.setMonth(Month);
			re.setReview(Review);
			re.setRevenue(Revenue);
			re.setId(hidden_id);
			
			Finance_EditRevenueEntryService dao = new Finance_EditRevenueEntryService();
			String updateValidate = dao.checkUpdate(re);
			
			if(updateValidate.equals("Update Successful")){
				request.setAttribute("UpdateSuccessMsg", updateValidate);
				RequestDispatcher rd = request.getRequestDispatcher("2_finance_revenue-information-portal.jsp");
				rd.forward(request,response);
			}
			else
				request.setAttribute("UpdateSuccessMsg", updateValidate);
			    RequestDispatcher rd = request.getRequestDispatcher("2_finance_revenue-edit.jsp");
			    rd.include(request,response);
		}
	}

}
