package blueLite.com.controller;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.Site_MachineryDetails;
import blueLite.com.service.Site_MachineryUpdateDao;

/**
 * Servlet implementation class RawMaterialUpdateController
 */
@WebServlet("/Site_MachineryUpdateController")
public class Site_MachineryUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("update") != null) {
			
			 String machineryName = request.getParameter("machineryName");
			 Double quantity = Double.parseDouble(request.getParameter("quantity"));
			 int hidden_id = Integer.parseInt(request.getParameter("hidden_id")); 
			 
			 Site_MachineryDetails mdEdit = new Site_MachineryDetails();
			 
			 mdEdit.setMachineryName(machineryName);
			 mdEdit.setQuantity(quantity);
			 mdEdit.setMachinaryID(hidden_id);
			 
			 Site_MachineryUpdateDao dao = new Site_MachineryUpdateDao();
			 String updateValidate = dao.checkUpdate(mdEdit);
			 
			 if(updateValidate.equals("success") ) {
				 request.setAttribute("UpdateSuccessMsg", updateValidate);
				 RequestDispatcher dispatcher = request.getRequestDispatcher("8_Site_machinery_table.jsp");
				 dispatcher.forward(request, response);
			 }
			 else{
				 request.setAttribute("UpdateSuccessMsg",updateValidate); 
	             RequestDispatcher rd=request.getRequestDispatcher("8_Site_machinery_update.jsp");
	             rd.include(request, response);
				 
			 }
		}
	}
}
