package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.Site_MachineryDetails;
import blueLite.com.service.Site_MachineryAddDao;

/**
 * Servlet implementation class RawMaterialAddController
 */
@WebServlet("/Site_MachineryAddController")
public class Site_MachineryAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 if(request.getParameter("add") != null) {
			 
			 String machineryName = request.getParameter("machineryName");
			 Double quantity = Double.parseDouble(request.getParameter("quantity"));
			 
			 Site_MachineryDetails mdAdd = new Site_MachineryDetails();
			 
			 mdAdd.setMachineryName(machineryName);
			 mdAdd.setQuantity(quantity);
			 
			 Site_MachineryAddDao dao = new Site_MachineryAddDao();
			 String insertValidate = dao.checkInsert(mdAdd);
			 
			 if(insertValidate.equals("Success") ) {
				 request.setAttribute("InsertSuccessMsg", insertValidate);
				 RequestDispatcher dispatcher = request.getRequestDispatcher("8_Site_machinery_table.jsp");
				 dispatcher.forward(request, response);
			 }
			 else{
				 request.setAttribute("InsertErrorMsg",insertValidate); 
	             RequestDispatcher rd=request.getRequestDispatcher("8_Site_machinery_add.jsp");
	             rd.include(request, response);
				 
			 }
		 }
	}

}
