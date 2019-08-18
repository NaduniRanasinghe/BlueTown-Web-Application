package blueLite.com.controller;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.Site_MaterialDetails;
import blueLite.com.service.Site_MaterialUpdateDao;

/**
 * Servlet implementation class RawMaterialUpdateController
 */
@WebServlet("/Site_MaterialUpdateController")
public class Site_MaterialUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("update") != null) {
			
			 String materialName = request.getParameter("materialName");
			 Double quantity = Double.parseDouble(request.getParameter("quantity"));
			 int hidden_id = Integer.parseInt(request.getParameter("hidden_id")); 
			 
			 Site_MaterialDetails mdEdit = new Site_MaterialDetails();
			 
			 mdEdit.setMaterialName(materialName);
			 mdEdit.setQuantity(quantity);
			 mdEdit.setMaterialID(hidden_id);
			 
			 Site_MaterialUpdateDao dao = new Site_MaterialUpdateDao();
			 String updateValidate = dao.checkUpdate(mdEdit);
			 
			 if(updateValidate.equals("success") ) {
				 request.setAttribute("UpdateSuccessMsg", updateValidate);
				 RequestDispatcher dispatcher = request.getRequestDispatcher("8_Site_material_table.jsp");
				 dispatcher.forward(request, response);
			 }
			 else{
				 request.setAttribute("UpdateSuccessMsg",updateValidate); 
	             RequestDispatcher rd=request.getRequestDispatcher("8_Site_material_update.jsp");
	             rd.include(request, response);
				 
			 }
		}
	}
}
