package blueLite.com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.HR_Career;
import blueLite.com.service.HR_CareerDao;





public class HR_AddCareer extends HttpServlet 
{
   
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getParameter("addEntryBtn")!=null) 
        {
            String department=request.getParameter("department"); 
            String position=request.getParameter("position"); 
            String supervisor =request.getParameter("supervisor");
            String date=request.getParameter("date");
           String description =request.getParameter("description");
          String status =request.getParameter("status");

          
       
            
           HR_Career addJob=new HR_Career(); 
            
            addJob.setDepartment(department); 
            addJob.setPost(position); 
            addJob.setSupervisor(supervisor);
            addJob.setDate(date);
          addJob.setDescription(description); 
         addJob.setStatus(status);
        
           
           
            
            HR_CareerDao addDao=new HR_CareerDao(); 
            
            String insertValidate=addDao.checkInsert(addJob); 
            
            if(insertValidate.equals("INSERT SUCCESS")) 
            {
                request.setAttribute("InsertSuccessMsg",insertValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("/1_HR_RecruitmentInfoPortal.jsp");
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("InsertErrorMsg",insertValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("/1_HR_recruitment-entry.jsp");
                rd.include(request, response);
            }
        }
    }
}



