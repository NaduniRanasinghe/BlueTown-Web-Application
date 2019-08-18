package blueLite.com.controller;

	import java.io.IOException;
	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.ORM_AddMetModel;
//import com.BlueLite.model.AddSupp;
	import blueLite.com.service.ORM_MetDao;


	public class ORM_AddMet extends HttpServlet 
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
	        	 String company_name=request.getParameter("CompanyName");
		            String address_line_1 =request.getParameter("address1"); 
		            String address_line_2=request.getParameter("address2"); 
		            String city=request.getParameter("city");
		            String email=request.getParameter("email");
		            String mobile=request.getParameter("mobile");
		            String item_name = request.getParameter("itemName");
	           double unit_Price=Double.parseDouble(request.getParameter("unitPrice"));
	          	       

    	
	ORM_AddMetModel addmet=new ORM_AddMetModel(); 
    
    addmet.setCompany_name(company_name); 
    addmet.setAddress_line_1(address_line_1); 
    addmet.setAddress_line_2(address_line_2); 
    addmet.setCity(city);
    addmet.setEmail(email);
    addmet.setMobile(mobile);
    addmet.setItem_name(item_name);
    addmet.setUnit_Price(unit_Price);
    
    ORM_MetDao met=new ORM_MetDao(); 
    
    String insertValidate=met.checkInsert(addmet); 
    
    if(insertValidate.equals("INSERT SUCCESS")) 
    {
        request.setAttribute("InsertSuccessMsg",insertValidate); 
        RequestDispatcher rd=request.getRequestDispatcher("6_ORM_MetPortal.jsp");
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



