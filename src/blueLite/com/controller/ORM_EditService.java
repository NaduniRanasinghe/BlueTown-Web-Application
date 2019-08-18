package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.*;
//import blueLite.com.service.ORM_EditHRDao;
import blueLite.com.service.ORM_EditServiceDao;



public class ORM_EditService extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ORM_EditService() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		

        if(request.getParameter("btn_edit")!=null) 
        {	
        	 String name=request.getParameter("name"); 
	            String address_line_1=request.getParameter("address_line_1"); 
	            String address_line_2=request.getParameter("address_line_2"); 
	            String city =request.getParameter("city");
	            String email=request.getParameter("email");
	           String mobile=request.getParameter("mobile");
             
            int hidden_id=Integer.parseInt(request.getParameter("hidden_id")); 
            
            ORM_AddServiceModel s=new ORM_AddServiceModel();  
            
              s.setname(name);
	          s.setAddress_line_1(address_line_1);
	          s.setAddress_line_2(address_line_2);	          
	          s.setcity(city);
	          s.setEmail(email);
	          s.setMobile(mobile);
	          s.setId(hidden_id);
	       
            
            ORM_EditServiceDao editDao = new ORM_EditServiceDao();
            
            String updateValidate=editDao.checkUpdate(s); 
            
            if(updateValidate.equals("UPDATE SUCCESS")) 
            {
                request.setAttribute("UpdateSuccessMsg",updateValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("6_ORM_SevicePortal.jsp");
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("UpdateErrorMsg",updateValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("6_ORM_HR.jsp");
                rd.include(request, response);
            }
        }
	}

}
