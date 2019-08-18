package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.IL_Equipment;
import blueLite.com.service.IL_EquipmentUpdateDao;

/**
 * Servlet implementation class EquipmentUpdateController
 */
@WebServlet("/EquipmentUpdateController")
public class IL_EquipmentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   if(request.getParameter("update") != null) {
		   
		   String type = request.getParameter("type");
		   int quantity = Integer.parseInt(request.getParameter("quantity"));
		   Double unitCost = Double.parseDouble(request.getParameter("unitprice"));
		   Double maintenanceCost = Double.parseDouble(request.getParameter("maintenance_cost"));
		   Double hidden_total = Double.parseDouble(request.getParameter("hidden_total"));
		   int hidden_id = Integer.parseInt(request.getParameter("hidden_id"));
		   
		   IL_Equipment eqEdit = new IL_Equipment();
		   
		   eqEdit.setName(type);
		   eqEdit.setQuantity(quantity);
		   eqEdit.setUnitCost(unitCost);
		   eqEdit.setMaintenanceCost(maintenanceCost);
		   eqEdit.setTotal(hidden_total);
		   eqEdit.setId(hidden_id);
		   
		   IL_EquipmentUpdateDao dao = new IL_EquipmentUpdateDao();
		   Boolean updateValidate = dao.checkUpdate(eqEdit);
		   
		   if(updateValidate.equals(true)) {
			   request.setAttribute("UpdateSuccessMsg", updateValidate);
			   RequestDispatcher dispatcher = request.getRequestDispatcher("equipment_table.jsp");
			   dispatcher.forward(request,response);
		   }
		   else{
			   request.setAttribute("UpdateSuccessMsg", updateValidate);
			   RequestDispatcher rd = request.getRequestDispatcher("equipment_update.jsp");
			   rd.include(request,response);
		   }
	   }
	}

}
