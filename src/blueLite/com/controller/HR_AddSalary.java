package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import blueLite.com.model.HR_Salary;
import blueLite.com.service.HR_SalaryDao;


//@WebServlet("/AddSalary")
public class HR_AddSalary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HR_AddSalary() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	    if(request.getParameter("btn_add")!=null) 
        {
            String nic= request.getParameter("nic"); 
            double basic = Double.parseDouble(request.getParameter("basicsal")); 
            double decrement = Double.parseDouble(request.getParameter("decrement")); 
            double othrs = Double.parseDouble(request.getParameter("othours")); 
            double otrate = Double.parseDouble(request.getParameter("otrate")); 
            double bonus = Double.parseDouble(request.getParameter("bonus")); 
            double commission = Double.parseDouble(request.getParameter("commission")); 
          
       
            
           HR_Salary addSal=new HR_Salary(); 
            
            addSal.setBasicSal(basic); 
            addSal.setOtHrs(othrs); 
            addSal.setDecrement(decrement); 
            addSal.setOtRate(otrate);
            addSal.setBonus(bonus);
          addSal.setNic(nic); 
         addSal.setCommission(commission);
         
        
           
           
            
            HR_SalaryDao addDao=new HR_SalaryDao(); 
            
            String insertValidate=addDao.checkInsert(addSal); 
            
            if(insertValidate.equals("INSERT SUCCESS")) 
            {
                request.setAttribute("InsertSuccessMsg",insertValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("/1_HR_SalaryInfoPortal.jsp");
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("InsertErrorMsg",insertValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("/1_HR_salary-form.jsp");
                rd.include(request, response);
            }
        }
    }
		
		
		
	}


