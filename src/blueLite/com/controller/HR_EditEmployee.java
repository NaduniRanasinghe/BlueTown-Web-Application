package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.HR_Employee;
//import blueLite.com.service.EditEmployeeDao;
import blueLite.com.service.HR_EmployeeDao;


//@WebServlet("/EditEmployee")
public class HR_EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public HR_EditEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		if(request.getParameter("btn_editemp")!=null) 
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
         String city=request.getParameter("city");
          
         int hidden_id=Integer.parseInt(request.getParameter("hidden_id")); 
            
           HR_Employee editEmp=new HR_Employee(); 
            
            editEmp.setFname(fname); 
            editEmp.setLname1(lname); 
            editEmp.setNic(nic);
            editEmp.setDepartment(department);
          editEmp.setEmail(email); 
         editEmp.setContact(phone);
         editEmp.setGender(gender);
        editEmp.setPosition(position);
       editEmp.setAddress1(address1);
       editEmp.setAddress2(address2);
       editEmp.setCity(city);
       editEmp.setId(hidden_id);
        
       HR_EmployeeDao editDao=new HR_EmployeeDao();
       
       String updateValidate=editDao.checkUpdate(editEmp); 
       
       if(updateValidate.equals("UPDATE SUCCESS")) 
       {
           request.setAttribute("UpdateSuccessMsg",updateValidate); 
           RequestDispatcher rd=request.getRequestDispatcher("1_HR_EmployeeInformationPortal.jsp");
           rd.forward(request, response);
       }
       else
       {
           request.setAttribute("UpdateErrorMsg",updateValidate); 
           RequestDispatcher rd=request.getRequestDispatcher("1_HR_EmployeeInformationPortal.jsp");
           rd.include(request, response);
		
       }
        }
	}

}
