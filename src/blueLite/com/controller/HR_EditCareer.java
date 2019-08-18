package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.HR_Career;
import blueLite.com.service.HR_CareerDao;


//@WebServlet("/EditCareer")
public class HR_EditCareer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HR_EditCareer() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		 if(request.getParameter("editEntryBtn")!=null) 
	        {
	            String department=request.getParameter("department"); 
	            String position=request.getParameter("position"); 
	            String supervisor =request.getParameter("supervisor");
	            String date=request.getParameter("date");
	           String description =request.getParameter("description");
	          String status =request.getParameter("status");

	          int hidden_id=Integer.parseInt(request.getParameter("hidden_id")); 
	       
	            
	           HR_Career editJob=new HR_Career(); 
	            
	            editJob.setDepartment(department); 
	            editJob.setPost(position); 
	            editJob.setSupervisor(supervisor);
	            editJob.setDate(date);
	          editJob.setDescription(description); 
	         editJob.setStatus(status);
	         editJob.setId(hidden_id);
	         
	         HR_CareerDao editDao=new HR_CareerDao(); 
	            
	            String insertValidate= editDao.checkUpdate(editJob); 
	            
	            if(insertValidate.equals("UPDATE SUCCESS")) 
	            {
	                request.setAttribute("UpdateSuccessMsg",insertValidate); 
	                RequestDispatcher rd=request.getRequestDispatcher("/1_HR_RecruitmentInfoPortal.jsp");
	                rd.forward(request, response);
	            }
	            else
	            {
	                request.setAttribute("UpdateErrorMsg",insertValidate); 
	                RequestDispatcher rd=request.getRequestDispatcher("/1_HR_EditRecruitment.jsp");
	                rd.include(request, response);
	            }
	        }
		
	}

}
