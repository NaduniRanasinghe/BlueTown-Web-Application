package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.IL_Logistics;
import blueLite.com.service.IL_LogisticsUpdateDao;

/**
 * Servlet implementation class LogisticsUpdateController
 */
@WebServlet("/IL_LogisticsUpdateController")
public class IL_LogisticsUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("update") != null) {
			
			 String type = request.getParameter("type");
			 Double cost = Double.parseDouble(request.getParameter("cost"));
			 Double maintenanceCost = Double.parseDouble(request.getParameter("maintenance_cost"));
			 Double fuelCost = Double.parseDouble(request.getParameter("fuel_cost"));
			 int hidden_id = Integer.parseInt(request.getParameter("hidden_id"));
			 Double hidden_total = Double.parseDouble(request.getParameter("hidden_total")); 
			 
			 IL_Logistics lgEdit = new IL_Logistics();
			 
			 lgEdit.setName(type);
			 lgEdit.setCost(cost);
			 lgEdit.setMaintenanceCost(maintenanceCost);
			 lgEdit.setFuelCost(fuelCost);
			 lgEdit.setId(hidden_id);
			 lgEdit.setTotal(hidden_total);
			 
			 IL_LogisticsUpdateDao dao = new IL_LogisticsUpdateDao();
			 Boolean updateValidate = dao.checkUpdate(lgEdit);
			 
			 if(updateValidate.equals(true) ) {
				 request.setAttribute("UpdateSuccessMsg", updateValidate);
				 RequestDispatcher dispatcher = request.getRequestDispatcher("logistics_table.jsp");
				 dispatcher.forward(request, response);
			 }
			 else{
				 request.setAttribute("UpdateSuccessMsg",updateValidate); 
	             RequestDispatcher rd=request.getRequestDispatcher("logistics_update.jsp");
	             rd.include(request, response);
				 
			 }
		}
	}

}
