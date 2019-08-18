package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.IL_RawMaterial;
import blueLite.com.service.IL_RawMaterialAddDao;

/**
 * Servlet implementation class RawMaterialAddController
 */
@WebServlet("/IL_RawMaterialAddController")
public class IL_RawMaterialAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 if(request.getParameter("add") != null) {
			 
			 String type = request.getParameter("type");
			 Double quantity = Double.parseDouble(request.getParameter("quantity"));
			 String unit = request.getParameter("unit");
			 Double unitCost = Double.parseDouble(request.getParameter("unitprice"));
			 Double quota = Double.parseDouble(request.getParameter("quota"));
			 Double hidden_total = Double.parseDouble(request.getParameter("hidden_total"));
			 
			 IL_RawMaterial rmAdd = new IL_RawMaterial();
			 
			 rmAdd.setName(type);
			 rmAdd.setQuantity(quantity);
			 rmAdd.setUnitCost(unitCost);
			 rmAdd.setQuota(quota);
			 rmAdd.setUnit(unit);
			 rmAdd.setTotal(hidden_total);
			 
			 IL_RawMaterialAddDao dao = new IL_RawMaterialAddDao();
			 Boolean insertValidate = dao.checkInsert(rmAdd);
			 
			 if(insertValidate.equals(true) ) {
				 request.setAttribute("InsertSuccessMsg",insertValidate);
				 RequestDispatcher dispatcher = request.getRequestDispatcher("raw_material_table.jsp");
				 dispatcher.forward(request, response);
			 }
			 else{
				 request.setAttribute("InsertErrorMsg",insertValidate); 
	             RequestDispatcher rd=request.getRequestDispatcher("raw_material_add.jsp");
	             rd.include(request, response);
				 
			 }
		 }
	}

}
