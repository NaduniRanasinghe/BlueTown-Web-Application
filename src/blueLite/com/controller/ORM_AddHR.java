package blueLite.com.controller;


	import java.io.IOException;
	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;


	import blueLite.com.model.ORM_AddHRModel;
	import blueLite.com.service.ORM_HRDao;


	public class ORM_AddHR extends HttpServlet 
	{
	    
		private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException 
	    {
	        if(request.getParameter("btn_add")!=null) 
	        {
	            String name=request.getParameter("Name"); 
	            String address_line_1 =request.getParameter("address1"); 
	            String address_line_2 =request.getParameter("address2"); 
	           String city =request.getParameter("city");
	            String Email =request.getParameter("email");
	           String mobile =request.getParameter("mobile");
	         
	
	ORM_AddHRModel addhr=new ORM_AddHRModel();
    
    addhr.setname(name);
    addhr.setAddress_line_1(address_line_1);
    addhr.setAddress_line_2(address_line_2);
    addhr.setCity(city);
    addhr.setEmail(Email);
    addhr.setMobile(mobile);
 
   
    ORM_HRDao hr=new ORM_HRDao(); 
    
    String insertValidate=hr.checkInsert(addhr); 
    
    if(insertValidate.equals("INSERT SUCCESS")) 
    {
        request.setAttribute("InsertSuccessMsg",insertValidate); 
        RequestDispatcher rd=request.getRequestDispatcher("6_ORM_HRPortal.jsp");
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
