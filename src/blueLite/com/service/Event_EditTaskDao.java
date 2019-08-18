package blueLite.com.service;
	


	import java.sql.Connection;
	import java.sql.PreparedStatement;

	import blueLite.com.model.Event_TaskModel;
	import blueLite.com.util.DBConnection;


	public class Event_EditTaskDao {

		private static Connection connection;
		
	    public String checkUpdate(Event_TaskModel editTask)
	    {	
	    
	      
	        
	        try
	        {
	          
	            PreparedStatement pstmt=null; 
	            connection = DBConnection.createConnection();
	            pstmt=connection.prepareStatement("update bluelite.task set taskname=?,date=?,description=?,Budget=?  where id = ? "); 

	            pstmt.setString(1,editTask.getTaskName());
	            pstmt.setString(2,editTask.getDuedate());
	            pstmt.setString(3,editTask.getDescription());
	            pstmt.setDouble(4,editTask.getBudget());
	       
	            pstmt.setInt(5,editTask.getId());
	            
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

	


