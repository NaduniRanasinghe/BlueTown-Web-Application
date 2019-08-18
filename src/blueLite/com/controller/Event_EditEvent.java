package blueLite.com.controller;


	

	import java.io.IOException;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	//import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import blueLite.com.model.Event_EventModel;
	import blueLite.com.service.Event_EditEventDao;


	//@WebServlet("/EditApartment")
	public class Event_EditEvent extends HttpServlet {
		private static final long serialVersionUID = 1L;
	   
	    public Event_EditEvent() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//doGet(request, response);
			

	        if(request.getParameter("btn_edit")!=null) 
	        {	
	            String eventName=request.getParameter("eventname"); 
	            String description=request.getParameter("description"); 
	            String date =request.getParameter("date");
	            String EventType=request.getParameter("type");
	            double estimateBudget=Double.parseDouble(request.getParameter("estimatedbudget"));
	            String location=request.getParameter("location");
	       
	            int hidden_id=Integer.parseInt(request.getParameter("hidden_id")); 
	            
	            Event_EventModel editEvent=new Event_EventModel();  
	            
	            editEvent.setEventName(eventName); 
	            editEvent.setDescription(description); 
	            editEvent.setDate(date);
	            editEvent.setEventType(EventType);
	            editEvent.setEstimateBudget(estimateBudget);
	            editEvent.setLocation(location);
	            editEvent.setId(hidden_id);
	            
	            Event_EditEventDao editDao=new Event_EditEventDao();
	            
	            String updateValidate= editDao.checkUpdate(editEvent); 
	            
	            if(updateValidate.equals("UPDATE SUCCESS")) 
	            {
	                request.setAttribute("UpdateSuccessMsg",updateValidate); 
	                RequestDispatcher rd=request.getRequestDispatcher("7_Event_add_event.jsp");
	                rd.forward(request, response);
	            }
	            else
	            {
	                request.setAttribute("UpdateErrorMsg",updateValidate); 
	                RequestDispatcher rd=request.getRequestDispatcher("7_Event_Event_InformationPortal.jsp");
	                rd.include(request, response);
	            }
	        }
		}

	}
	
	
	
	