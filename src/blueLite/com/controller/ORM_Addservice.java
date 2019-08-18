package blueLite.com.controller;

 import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.ORM_AddServiceModel;
import blueLite.com.service.ORM_serviceDao;



public class ORM_Addservice extends HttpServlet 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getParameter("btn_add")!=null) 
        {
            String name=request.getParameter("name"); 
            String address_line_1=request.getParameter("address1");
            String address_line_2=request.getParameter("address2");           
            String city=request.getParameter("city");
            String Email=request.getParameter("email");
           String mobile=request.getParameter("mobile");
           

           ORM_AddServiceModel   addservice = new ORM_AddServiceModel(); 



   addservice.setname(name);
   addservice.setAddress_line_1(address_line_1);
   addservice.setAddress_line_2(address_line_2);
   addservice.setcity(city);
   addservice.setEmail(Email);
   addservice.setMobile(mobile);
   


   	ORM_serviceDao service = new ORM_serviceDao(); 

   	String insertValidate = service.checkInsert(addservice); 
   		if(insertValidate.equals("INSERT SUCCESS")) 
{
    request.setAttribute("InsertSuccessMsg",insertValidate); 
    RequestDispatcher rd=request.getRequestDispatcher("6_ORM_sevicePortal.jsp");
    rd.forward(request, response);
}
else
{
    request.setAttribute("InsertErrorMsg",insertValidate); 
    RequestDispatcher rd=request.getRequestDispatcher("6_ORM_Material.jsp");
    rd.include(request, response);
}
}
}
}




