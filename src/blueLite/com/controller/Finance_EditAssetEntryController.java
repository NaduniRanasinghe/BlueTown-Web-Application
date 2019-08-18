package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.Finance_AssetEntry;
import blueLite.com.service.Finance_EditAssetEntryService;

/**
 * Servlet implementation class EditAssetEntryController
 */
//@WebServlet("/EditAssetEntryController")
public class Finance_EditAssetEntryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("edit") != null) {
			
			String name = request.getParameter("name");
        	String type = request.getParameter("type");
        	String additional = request.getParameter("additional");
        	String otherIDs = request.getParameter("otherIDs");
        	double value = Double.parseDouble(request.getParameter("value"));
			int hidden_id = Integer.parseInt(request.getParameter("hidden_id"));
			
			Finance_AssetEntry re = new Finance_AssetEntry();
			
			re.setName(name); 
            re.setType(type); 
            re.setAdditional(additional);
            re.setOtherIDs(otherIDs);  
            re.setValue(value);
			re.setHidden_id(hidden_id);
			
			Finance_EditAssetEntryService dao = new Finance_EditAssetEntryService();
			String updateValidate = dao.checkUpdate(re);
			
			if(updateValidate.equals("Update Successful")){
				request.setAttribute("UpdateSuccessMsg", updateValidate);
				RequestDispatcher rd = request.getRequestDispatcher("2_finance_asset-information-portal.jsp");
				rd.forward(request,response);
			}
			else
				request.setAttribute("UpdateSuccessMsg", updateValidate);
			    RequestDispatcher rd = request.getRequestDispatcher("2_finance_asset-edit.jsp");
			    rd.include(request,response);
		}
	}

}
