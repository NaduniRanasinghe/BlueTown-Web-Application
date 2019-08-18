package blueLite.com.service;
import java.sql.Connection;
import java.sql.PreparedStatement;

import blueLite.com.model.Event_EventModel;
import blueLite.com.util.DBConnection;


public class Event_addEventDao 
{
	private static Connection connection;
	
  public String checkInsert(Event_EventModel event)
  {
  	  String eventName = event.getEventName();
      String description=event.getDescription(); 
      String date=event.getDate(); 
      String EventType= event.getEventType();
      double estimateBudget= event.getEstimateBudget();
      String location = event.getLocation();
     
      
      
  
      
      try
      {
        
      	connection = DBConnection.createConnection();
          PreparedStatement pstmt=null; 
          
          pstmt=connection.prepareStatement("insert into bluelite.event(eventname,description,date,EventType,estimateBudget,location) values(?,?,?,?,?,?)"); 
         
          
          pstmt.setString(1,eventName);
          pstmt.setString(2,description);
          pstmt.setString(3,date);
          pstmt.setString(4,EventType);
          pstmt.setDouble(5,estimateBudget);
          pstmt.setString(6, location);
       
         
         
         
          
          pstmt.executeUpdate(); 
          
          pstmt.close(); 
          
          connection.close(); 
          
          return "INSERT SUCCESS"; 
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
      
      return "FAIL INSERT";
  }
  
}