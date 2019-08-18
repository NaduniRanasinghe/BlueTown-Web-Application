package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.Site_SiteDetails;
import blueLite.com.service.Site_SiteAddDao;

/**
 * Servlet implementation class RawMaterialAddController
 */
@WebServlet("/Site_SiteAddController")
public class Site_SiteAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 if(request.getParameter("add") != null) {
			 
			 String siteName = request.getParameter("siteName");
			 String siteOwnerName = request.getParameter("siteOwnerName");
			 Double estimatedCost = Double.parseDouble(request.getParameter("estimatedCost"));
			 Double receivedAmount = Double.parseDouble(request.getParameter("receivedAmount"));
			 String handOverDate = request.getParameter("handOverDate");
			 
			 Site_SiteDetails sdAdd = new Site_SiteDetails();
			 
			 sdAdd.setSiteName(siteName);
			 sdAdd.setSiteOwnerName(siteOwnerName);
			 sdAdd.setEstimatedCost(estimatedCost);
			 sdAdd.setReceivedAmount(receivedAmount);
			 sdAdd.setHandOverDate(handOverDate);
			 
			 Site_SiteAddDao dao = new Site_SiteAddDao();
			 String insertValidate = dao.checkInsert(sdAdd);
			 
			 if(insertValidate.equals("Success") ) {
				 request.setAttribute("InsertSuccessMsg", insertValidate);
				 RequestDispatcher dispatcher = request.getRequestDispatcher("8_Site_site_table.jsp");
				 dispatcher.forward(request, response);
			 }
			 else{
				 request.setAttribute("InsertErrorMsg",insertValidate); 
	             RequestDispatcher rd=request.getRequestDispatcher("8_Site_site_add.jsp");
	             rd.include(request, response);
				 
			 }
		 }
	}

}
