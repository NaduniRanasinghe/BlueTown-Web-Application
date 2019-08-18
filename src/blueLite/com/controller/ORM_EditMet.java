package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.*;
import blueLite.com.service.ORM_EditMetDao;


//@WebServlet("/EditApartment")
public class ORM_EditMet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ORM_EditMet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		

        if(request.getParameter("btn_edit")!=null) 
        {	
        	 String company_name=request.getParameter("Name"); 
	            String address_line_1=request.getParameter("address1"); 
	            String address_line_2=request.getParameter("address2"); 
	            String city =request.getParameter("city");
	            String email=request.getParameter("email");
	           String mobile=request.getParameter("mobile");
	           String item_name=request.getParameter("itemname");
	           
	           double unit_Price=Double.parseDouble(request.getParameter("unitprice"));
      	       
            int hidden_id=Integer.parseInt(request.getParameter("hidden_id")); 
            
            ORM_AddMetModel m=new ORM_AddMetModel();  
            
              m.setCompany_name(company_name);
	          m.setAddress_line_1(address_line_1);
	          m.setAddress_line_2(address_line_2);	          
	          m.setCity(city);
	          m.setEmail(email);
	          m.setMobile(mobile);
	          m.setItem_name(item_name);
	          m.setUnit_Price(unit_Price);
	          m.setId(hidden_id);
	       
            
            ORM_EditMetDao editDao=new ORM_EditMetDao();
            
            String updateValidate=editDao.checkUpdate(m); 
            
            if(updateValidate.equals("UPDATE SUCCESS")) 
            {
                request.setAttribute("UpdateSuccessMsg",updateValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("6_ORM_MetPortal.jsp");
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("UpdateErrorMsg",updateValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("6_ORM_Material.jsp");
                rd.include(request, response);
            }
        }
	}

}
