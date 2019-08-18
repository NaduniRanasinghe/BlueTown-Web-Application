package blueLite.com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.service.*;
import blueLite.com.model.*;

//@WebServlet("/AddFinanceEntry")
public class Finance_AddAssetEntryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Finance_AddAssetEntryController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

    
        if(request.getParameter("addEntryBtn")!=null) 
        {
        	String name = request.getParameter("name");
        	String type = request.getParameter("type");
        	String additional = request.getParameter("additional");
        	String otherIDs = request.getParameter("otherIDs");
        	double value = Double.parseDouble(request.getParameter("value"));

            Finance_AssetEntry /*model*/ f1 = new Finance_AssetEntry(); 
            
            f1.setName(name); 
            f1.setType(type); 
            f1.setAdditional(additional);
            f1.setOtherIDs(otherIDs);  
            f1.setValue(value); 
            
            Finance_AddAssetEntryService /*service*/ c1 = new Finance_AddAssetEntryService(); 
            
            String insertValidate= c1.addEntry(f1); 
            
            if(insertValidate.equals("INSERT SUCCESS")) 
            {
                request.setAttribute("InsertSuccessMsg",insertValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("2_finance_asset-information-portal.jsp");
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("InsertErrorMsg",insertValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("2_finance_asset-entry.jsp");
                rd.include(request, response);
            }
        }
    }
}
