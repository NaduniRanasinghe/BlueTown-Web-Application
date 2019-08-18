package blueLite.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;


import blueLite.com.model.Event_TaskModel;
import blueLite.com.util.DBConnection;

public class Event_addTaskDao {


			private static Connection connection;
			
		  public String checkInsert(Event_TaskModel task)
		  {
		  	  String taskName = task.getTaskName();
		      String date=task.getDuedate(); 
		      double Budget= task.getBudget();
		      String description=task.getDescription(); 
		   
		     
		      
		      
		  
		      
		      try
		      {
		        
		      	connection = DBConnection.createConnection();
		          PreparedStatement pstmt=null; 
		          
		          pstmt=connection.prepareStatement("insert into blueLite.task(taskname,date,Budget,description) values(?,?,?,?)"); 
		         
		          
		          pstmt.setString(1,taskName);
		          pstmt.setString(2,date);
		          pstmt.setDouble(3,Budget);
		          pstmt.setString(4,description);
		      
		       
		         
		         
		         
		          
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


