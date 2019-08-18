package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.IL_Equipment;
import blueLite.com.service.IL_EquipmentAddDao;

/**
 * Servlet implementation class RawMaterialAddController
 */
@WebServlet("/IL_EquipmentAddController")
public class IL_EquipmentAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 if(request.getParameter("add") != null) {
			 
			 String type = request.getParameter("type");
			 int quantity = Integer.parseInt(request.getParameter("quantity"));
			 Double unitCost = Double.parseDouble(request.getParameter("unitprice"));
			 Double maintenanceCost = Double.parseDouble(request.getParameter("maintenance_cost"));
			 Double hidden_total = Double.parseDouble(request.getParameter("hidden_total"));
			 
			 IL_Equipment eqAdd = new IL_Equipment();
			 
			 eqAdd.setName(type);
			 eqAdd.setQuantity(quantity);
			 eqAdd.setUnitCost(unitCost);
			 eqAdd.setMaintenanceCost(maintenanceCost);
			 eqAdd.setTotal(hidden_total);
			 
			 IL_EquipmentAddDao dao = new IL_EquipmentAddDao();
			 Boolean insertValidate = dao.checkInsert(eqAdd);
			 
			 if(insertValidate.equals(true) ) {
				 request.setAttribute("InsertSuccessMsg", insertValidate);
				 RequestDispatcher dispatcher = request.getRequestDispatcher("4_IL_equipment_table.jsp");
				 dispatcher.forward(request, response);
			 }
			 else{
				 request.setAttribute("InsertErrorMsg",insertValidate); 
	             RequestDispatcher rd=request.getRequestDispatcher("4_IL_equipment_add.jsp");
	             rd.include(request, response);
				 
			 }
		 }
	}

}
