package blueLite.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueLite.com.model.*;
import blueLite.com.service.Event_addEventDao;

  public class Event_AddEvent extends HttpServlet
  {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getParameter("btn_add")!=null) 
        {
            String eventName=request.getParameter("eventname"); 
            String description=request.getParameter("description"); 
            String date =request.getParameter("date");
            String EventType=request.getParameter("type");
            double estimateBudget=Double.parseDouble(request.getParameter("estimatedbudget"));
            String location=request.getParameter("location");
          
       
            
            Event_EventModel addEvent=new Event_EventModel(); 
            
            addEvent.setEventName(eventName); 
            addEvent.setDescription(description); 
            addEvent.setDate(date);
            addEvent.setEventType(EventType);
            addEvent.setEstimateBudget(estimateBudget);
            addEvent.setLocation(location);
         
           
           
            
          Event_addEventDao addEventDao=new Event_addEventDao(); 
            
            String insertValidate=addEventDao.checkInsert(addEvent); 
            
            if(insertValidate.equals("INSERT SUCCESS")) 
            {
                request.setAttribute("InsertSuccessMsg",insertValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("7_Event_Event_InformationPortal.jsp");
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("InsertErrorMsg",insertValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("7_Event_add_event.jsp");
                rd.include(request, response);
            }
        }
    }
}
