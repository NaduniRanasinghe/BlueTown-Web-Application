package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import blueLite.com.model.Employee;
import blueLite.com.model.HR_Salary;
//import blueLite.com.service.EditEmployeeDao;

import blueLite.com.service.HR_SalaryDao;


@WebServlet("/HR_EditSalaryInfo")
public class HR_EditSalaryInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HR_EditSalaryInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		
		if(request.getParameter("btn_editsal")!=null) 
        {
			
            double basic = Double.parseDouble(request.getParameter("basicsal")); 
            double decrement = Double.parseDouble(request.getParameter("decrement")); 
            double othrs = Double.parseDouble(request.getParameter("othours")); 
            double otrate = Double.parseDouble(request.getParameter("otrate")); 
            double bonus = Double.parseDouble(request.getParameter("bonus")); 
            double commission = Double.parseDouble(request.getParameter("commission")); 
          
            String hidden_id=request.getParameter("hidden_id"); 
            
  HR_Salary editSal=new HR_Salary(); 
            
            editSal.setBasicSal(basic); 
            editSal.setOtHrs(othrs); 
            editSal.setDecrement(decrement); 
            editSal.setOtRate(otrate);
            editSal.setBonus(bonus);
          editSal.setNic(hidden_id); 
         editSal.setCommission(commission);
         
        
        
       HR_SalaryDao editDao=new HR_SalaryDao();
       
       String updateValidate=editDao.checkUpdate(editSal); 
       
       if(updateValidate.equals("UPDATE SUCCESS")) 
       {
           request.setAttribute("UpdateSuccessMsg",updateValidate); 
           RequestDispatcher rd=request.getRequestDispatcher("1_HR_SalaryInfoPortal.jsp");
           rd.forward(request, response);
       }
       else
       {
           request.setAttribute("UpdateErrorMsg",updateValidate); 
           RequestDispatcher rd=request.getRequestDispatcher("1_HR_EditSalaryInfo.jsp");
           rd.include(request, response);
		
	}

}
	}
	}
