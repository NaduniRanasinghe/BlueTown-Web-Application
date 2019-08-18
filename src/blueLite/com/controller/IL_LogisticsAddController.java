package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.IL_Logistics;
import blueLite.com.service.IL_LogisticsAddDao;

/**
 * Servlet implementation class LogisticsAddController
 */
@WebServlet("/IL_LogisticsAddController")
public class IL_LogisticsAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		if(request.getParameter("add") != null) {
			 
			 String type = request.getParameter("type");
			 Double cost = Double.parseDouble(request.getParameter("cost"));
			 Double maintenanceCost = Double.parseDouble(request.getParameter("maintenance_cost"));
			 Double fuelCost = Double.parseDouble(request.getParameter("fuel_cost"));
			 Double hidden_total = Double.parseDouble(request.getParameter("hidden_total"));
			 
			 IL_Logistics lgAdd = new IL_Logistics();
			 
			 lgAdd.setName(type);
			 lgAdd.setCost(cost);
			 lgAdd.setMaintenanceCost(maintenanceCost);
			 lgAdd.setFuelCost(fuelCost);
			 lgAdd.setTotal(hidden_total);
			 
			 IL_LogisticsAddDao dao = new IL_LogisticsAddDao();
			 Boolean insertValidate = dao.checkInsert(lgAdd);
			 
			 if(insertValidate.equals(true) ) {
				 request.setAttribute("InsertSuccessMsg",insertValidate);
				 RequestDispatcher dispatcher = request.getRequestDispatcher("logistics_table.jsp");
				 dispatcher.forward(request, response);
			 }
			 else{
				 request.setAttribute("InsertErrorMsg",insertValidate); 
	             RequestDispatcher rd=request.getRequestDispatcher("logistics_add.jsp");
	             rd.include(request, response);
				 
			 }
		 }
	}

}
