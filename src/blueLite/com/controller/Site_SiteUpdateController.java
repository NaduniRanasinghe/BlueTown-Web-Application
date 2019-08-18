package blueLite.com.controller;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.Site_SiteDetails;
import blueLite.com.service.Site_SiteUpdateDao;



/**
 * Servlet implementation class RawMaterialUpdateController
 */
@WebServlet("/Site_SiteUpdateController")
public class Site_SiteUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("update") != null) {
			
			 String siteName = request.getParameter("siteName");
			 String siteOwnerName = request.getParameter("siteOwnerName");
			 Double estimatedCost = Double.parseDouble(request.getParameter("estimatedCost"));
			 Double receivedAmount = Double.parseDouble(request.getParameter("receivedAmount"));
			 String handOverDate = request.getParameter("handOverDate");
			 int hidden_id = Integer.parseInt(request.getParameter("hidden_id")); 
			 
			 Site_SiteDetails sdEdit = new Site_SiteDetails();
			 
			 sdEdit.setSiteName(siteName);
			 sdEdit.setSiteOwnerName(siteOwnerName);
			 sdEdit.setEstimatedCost(estimatedCost);
			 sdEdit.setReceivedAmount(receivedAmount);
			 sdEdit.setHandOverDate(handOverDate);
			 sdEdit.setSiteID(hidden_id);
			 
			 Site_SiteUpdateDao dao = new Site_SiteUpdateDao();
			 String updateValidate = dao.checkUpdate(sdEdit);
			 
			 if(updateValidate.equals("success") ) {
				 request.setAttribute("UpdateSuccessMsg", updateValidate);
				 RequestDispatcher dispatcher = request.getRequestDispatcher("8_Site_site_table.jsp");
				 dispatcher.forward(request, response);
			 }
			 else{
				 request.setAttribute("UpdateSuccessMsg",updateValidate); 
	             RequestDispatcher rd=request.getRequestDispatcher("8_Site_site_update.jsp");
	             rd.include(request, response);
				 
			 }
		}
	}
}
