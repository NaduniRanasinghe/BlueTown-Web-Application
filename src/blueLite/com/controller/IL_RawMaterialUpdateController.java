package blueLite.com.controller;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.IL_RawMaterial;
import blueLite.com.service.IL_RawMaterialUpdateDao;


/**
 * Servlet implementation class RawMaterialUpdateController
 */
@WebServlet("/IL_RawMaterialUpdateController")
public class IL_RawMaterialUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("update") != null) {
			
			 String type = request.getParameter("type");
			 Double quantity = Double.parseDouble(request.getParameter("quantity"));
			 String unit = request.getParameter("unit");
			 Double unitCost = Double.parseDouble(request.getParameter("unitprice"));
			 Double quota = Double.parseDouble(request.getParameter("quota"));
			 int hidden_id = Integer.parseInt(request.getParameter("hidden_id"));
			 Double hidden_total = Double.parseDouble(request.getParameter("hidden_total")); 
			 
			 IL_RawMaterial rmEdit = new IL_RawMaterial();
			 
			 rmEdit.setName(type);
			 rmEdit.setQuantity(quantity);
			 rmEdit.setUnit(unit);
			 rmEdit.setUnitCost(unitCost);
			 rmEdit.setQuota(quota);
			 rmEdit.setId(hidden_id);
			 rmEdit.setTotal(hidden_total);
			 
			 IL_RawMaterialUpdateDao dao = new IL_RawMaterialUpdateDao();
			 Boolean updateValidate = dao.checkUpdate(rmEdit);
			 
			 if(updateValidate.equals(true) ) {
				 request.setAttribute("UpdateSuccessMsg", updateValidate);
				 RequestDispatcher dispatcher = request.getRequestDispatcher("4_IL_raw_material_table.jsp");
				 dispatcher.forward(request, response);
			 }
			 else{
				 request.setAttribute("UpdateSuccessMsg",updateValidate); 
	             RequestDispatcher rd=request.getRequestDispatcher("4_IL_raw_material_update.jsp");
	             rd.include(request, response);
				 
			 }
		}
	}
}
