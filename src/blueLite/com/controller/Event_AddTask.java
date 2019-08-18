package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.*;

import blueLite.com.service.Event_addTaskDao;


	public class Event_AddTask extends HttpServlet
	  {
		private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException 
	    {
	        if(request.getParameter("btn_add")!=null) 
	        {
	            String taskName=request.getParameter("taskname"); 
	            String date =request.getParameter("duedate");
	            double Budget=Double.parseDouble(request.getParameter("budget"));
	            String description=request.getParameter("description"); 
	       
	          
	       
	            
	            Event_TaskModel addTask =new Event_TaskModel(); 
	            
	            addTask.setTaskName(taskName); 
	            addTask.setDuedate(date);
	            addTask.setBudget(Budget);
	            addTask.setDescription(description); 
	   
	         
	           
	           
	            
	          Event_addTaskDao addtaskDao=new Event_addTaskDao(); 
	            
	            String insertValidate=addtaskDao.checkInsert(addTask); 
	            
	            if(insertValidate.equals("INSERT SUCCESS")) 
	            {
	                request.setAttribute("InsertSuccessMsg",insertValidate); 
	                RequestDispatcher rd=request.getRequestDispatcher("7_Event_Task_Information_Portal.jsp");
	                rd.forward(request, response);
	            }
	            else
	            {
	                request.setAttribute("InsertErrorMsg",insertValidate); 
	                RequestDispatcher rd=request.getRequestDispatcher("7_Event_add_task.jsp");
	                rd.include(request, response);
	            }
	        }
	    }
	}



