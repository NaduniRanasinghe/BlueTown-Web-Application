

package blueLite.com.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import blueLite.com.model.CRM_register;
import blueLite.com.service.CRM_editServices;



    /**
	 * 
	 */public class CRM_editCus extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getParameter("btn_edit")!=null) 

        {

    	
   		 String nic = request.getParameter("nic");
   		 String firstName = request.getParameter("fname");
   		 String lastName = request.getParameter("lname");
   		 String email = request.getParameter("email");
   		 String mobile = request.getParameter("mobile");
   		 String address1 = request.getParameter("address1");
   		 String address2 = request.getParameter("address2");
   		 String city = request.getParameter("city"); 
   		 String gender = request.getParameter("radio");
   		 String apartmenttype =request.getParameter("apartmenttype");
   		 String site = request.getParameter("site");
   		 String password = request.getParameter("password");
   		
   	
   		 
            int hidden_id=Integer.parseInt(request.getParameter("hidden_id")); 
            
           
         CRM_register register = new CRM_register();

   	
   		 register.setNic(nic);
   		 register.setFname(firstName);
   		 register.setLname(lastName);
   		 register.setEmail(email);
   		 register.setMobile(mobile);
   		 register.setAddress1(address1);
   		 register.setAddress2(address2);
   		 register.setCity(city);
   		 register.setGender(gender);
   		 register.setApartmenttype(apartmenttype);
   		 register.setSite(site);
   		 register.setPassword(password);
   		 register.setCid(hidden_id);
   		 
            
            CRM_editServices editDao=new CRM_editServices();
            
            String updateValidate=editDao.checkUpdate(register); 
            
            if(updateValidate.equals("UPDATE SUCCESS")) 
            {
                request.setAttribute("UpdateSuccessMsg",updateValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("3_CRM_cusinp.jsp");
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("UpdateErrorMsg",updateValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("3_CRM_editCus.jsp");
                rd.include(request, response);
            }
        }
    }
}
