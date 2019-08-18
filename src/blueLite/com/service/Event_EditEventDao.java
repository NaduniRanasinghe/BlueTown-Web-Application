package blueLite.com.service;
	


	import java.sql.Connection;
	import java.sql.PreparedStatement;
    import blueLite.com.model.Event_EventModel;
    import blueLite.com.util.DBConnection;


	public class Event_EditEventDao {

		private static Connection connection;
		
	    public String checkUpdate(Event_EventModel editEvent)
	    {	
	    
	      
	        
	        try
	        {
	          
	            PreparedStatement pstmt=null; 
	            connection = DBConnection.createConnection();
	            pstmt=connection.prepareStatement("update bluelite.event set eventname=?,description=?,date=?,EventType=?,estimateBudget=?,location=? where id = ? "); 

	            pstmt.setString(1,editEvent.getEventName());
	            pstmt.setString(2,editEvent.getDescription());
	            pstmt.setString(3,editEvent.getDate());
	            pstmt.setString(4,editEvent.getEventType());
	            pstmt.setDouble(5,editEvent.getEstimateBudget());
	            pstmt.setString(6,editEvent.getLocation());
	            pstmt.setInt(7,editEvent.getId());
	            
	            pstmt.executeUpdate(); 
	            
	            pstmt.close(); 
	            
	            connection.close();
	            
	            return "UPDATE SUCCESS"; 
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        
	        return "FAIL UPDATE"; 
	    }

		
	}

	


