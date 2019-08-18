package blueLite.com.controller;
import java.io.IOException;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	//import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import blueLite.com.model.Event_TaskModel;

import blueLite.com.service.Event_EditTaskDao;


	//@WebServlet("/EditApartment")
	public class Event_EditTask extends HttpServlet {
		private static final long serialVersionUID = 1L;
	   
	    public Event_EditTask() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//doGet(request, response);
			

	        if(request.getParameter("btn_edit")!=null) 
	        {	
	            String taskName=request.getParameter("taskname");  
	            String date =request.getParameter("date");
	            String description=request.getParameter("description"); 
	            double Budget=Double.parseDouble(request.getParameter("budget"));
	        
	       
	            int hidden_id=Integer.parseInt(request.getParameter("hidden_id")); 
	            
	            Event_TaskModel editTask=new Event_TaskModel();  
	            
	            editTask.setTaskName(taskName);  
	            editTask.setDuedate(date);
	            editTask.setDescription(description); 
	            editTask.setBudget(Budget);
	          
	            editTask.setId(hidden_id);
	            
	            Event_EditTaskDao editDao=new Event_EditTaskDao();
	            
	            String updateValidate= editDao.checkUpdate(editTask); 
	            
	            if(updateValidate.equals("UPDATE SUCCESS")) 
	            {
	                request.setAttribute("UpdateSuccessMsg",updateValidate); 
	                RequestDispatcher rd=request.getRequestDispatcher("Event_add_task.jsp");
	                rd.forward(request, response);
	            }
	            else
	            {
	                request.setAttribute("UpdateErrorMsg",updateValidate); 
	                RequestDispatcher rd=request.getRequestDispatcher("Event_Task_Information_Portal.jsp");
	                rd.include(request, response);
	            }
	        }
		}

	}
	