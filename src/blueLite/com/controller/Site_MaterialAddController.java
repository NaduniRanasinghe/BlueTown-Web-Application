package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.Site_MaterialDetails;
import blueLite.com.service.Site_MaterialAddDao;

/**
 * Servlet implementation class RawMaterialAddController
 */
@WebServlet("/Site_MaterialAddController")
public class Site_MaterialAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 if(request.getParameter("add") != null) {
			 
			 String materialName = request.getParameter("materialName");
			 Double quantity = Double.parseDouble(request.getParameter("quantity"));
			 
			 Site_MaterialDetails mdAdd = new Site_MaterialDetails();
			 
			 mdAdd.setMaterialName(materialName);
			 mdAdd.setQuantity(quantity);
			 
			 Site_MaterialAddDao dao = new Site_MaterialAddDao();
			 String insertValidate = dao.checkInsert(mdAdd);
			 
			 if(insertValidate.equals("Success") ) {
				 request.setAttribute("InsertSuccessMsg", insertValidate);
				 RequestDispatcher dispatcher = request.getRequestDispatcher("8_Site_material_table.jsp");
				 dispatcher.forward(request, response);
			 }
			 else{
				 request.setAttribute("InsertErrorMsg",insertValidate); 
	             RequestDispatcher rd=request.getRequestDispatcher("8_Site_material_add.jsp");
	             rd.include(request, response);
				 
			 }
		 }
	}

}
