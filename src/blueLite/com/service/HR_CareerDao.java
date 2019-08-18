package blueLite.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.util.Date;

import blueLite.com.model.HR_Career;

import blueLite.com.util.DBConnection;

public class HR_CareerDao {

	
private static Connection connection;
	
    public String checkInsert(HR_Career addJob)
    {
      try
        {
          
        	connection = DBConnection.createConnection();
            PreparedStatement pstmt=null; 
            
            pstmt=connection.prepareStatement("insert into bluelite.career (department,post,exdate,supervisor,empStatus,jobdDescription) values (?,?,?,?,?,?)"); 
            
          
            
            pstmt.setString(1, addJob.getDepartment());
            pstmt.setString(2, addJob.getPost());
            pstmt.setString(3, addJob.getDate());
            pstmt.setString(4, addJob.getSupervisor());
            pstmt.setString(5, addJob.getStatus());
            pstmt.setString(6, addJob.getDescription());
          
          
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
    
    public String checkUpdate(HR_Career editJob)
    {	
    	  
        try
        {
          
            PreparedStatement pstmt=null; 
            connection = DBConnection.createConnection();
            pstmt=connection.prepareStatement("update bluelite.career set department = ?, post = ?, exdate = ?, supervisor = ?, empStatus = ?, jobdDescription = ? where id = ?"); 

            
            pstmt.setString(1, editJob.getDepartment());
            pstmt.setString(2, editJob.getPost());
            pstmt.setString(3, editJob.getDate());
            pstmt.setString(4, editJob.getSupervisor());
            pstmt.setString(5, editJob.getStatus());
            pstmt.setString(6, editJob.getDescription());
            
            pstmt.setInt(7, editJob.getId());
            
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
