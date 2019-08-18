package blueLite.com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.HR_Employee;
import blueLite.com.service.HR_EmployeeDao;




public class HR_AddEmployee extends HttpServlet 
{
   
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getParameter("btn_add")!=null) 
        {
        
            String fname=request.getParameter("fname"); 
            String lname=request.getParameter("lname"); 
            String nic =request.getParameter("nic");
            String department=request.getParameter("department");
           String email=request.getParameter("email");
          String phone=request.getParameter("mobilenum");
           String gender = request.getParameter("gender");
         String position= request.getParameter("position");
         String address1=request.getParameter("address1");
         String address2=request.getParameter("address2");
         String pass=request.getParameter("password");
         String pass1=request.getParameter("password1");
          
         HR_Employee addEmp=new HR_Employee(); 
            
        
        	   
           
            
            addEmp.setFname(fname); 
            addEmp.setLname1(lname); 
            addEmp.setNic(nic);
            addEmp.setDepartment(department);
          addEmp.setEmail(email); 
         addEmp.setContact(phone);
         addEmp.setGender(gender);
        addEmp.setPosition(position);
       addEmp.setAddress1(address1);
       addEmp.setAddress2(address2);
      addEmp.setPassword(pass);
      addEmp.setPassword1(pass1);
           
           
            
            HR_EmployeeDao addDao=new HR_EmployeeDao(); 
            
            String insertValidate=addDao.checkInsert(addEmp); 
            
            if(insertValidate.equals("INSERT SUCCESS")) 
            {
                request.setAttribute("InsertSuccessMsg",insertValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("/1_HR_EmployeeInformationPortal.jsp");
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("InsertErrorMsg",insertValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("/1_HR_EmployeeRegistration.jsp");
                rd.include(request, response);
            }
        }
           
        	
           
        
        
    }
}



