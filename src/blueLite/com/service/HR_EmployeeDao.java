package blueLite.com.service;

import java.sql.Connection; 
//import java.sql.DriverManager;
import java.sql.PreparedStatement;

import blueLite.com.model.HR_Employee;
import blueLite.com.util.*;


public class HR_EmployeeDao
{
	private static Connection connection;
	
    public String checkInsert(HR_Employee addEmp)
    {
    	
    	 
      try
        {
        
        	  

        	connection = DBConnection.createConnection();
            PreparedStatement pstmt=null; 
            
            pstmt=connection.prepareStatement("insert into bluelite.employee(empnic,fname,lname,email,contact,gender,department,post,address1,address2,emppassword) values(?,?,?,?,?,?,?,?,?,?,?)"); 
            
            pstmt.setString(1, addEmp.getNic());
            pstmt.setString(2, addEmp.getFname());
            pstmt.setString(3, addEmp.getLname1());
            pstmt.setString(4, addEmp.getEmail());
            pstmt.setString(5, addEmp.getContact());
            pstmt.setString(6, addEmp.getGender());
            pstmt.setString(7, addEmp.getDepartment());
            pstmt.setString(8, addEmp.getPosition());
            pstmt.setString(9, addEmp.getAddress1());
            pstmt.setString(10, addEmp.getAddress2());
            pstmt.setString(11, addEmp.getPassword1());
           
           
           
          
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
    public String checkUpdate(HR_Employee editEmp)
    {	
    	  
        try
        {
          
            PreparedStatement pstmt=null; 
            connection = DBConnection.createConnection();
            pstmt=connection.prepareStatement("update bluelite.employee set empnic = ?, fname = ?, lname = ?, address1 = ?, address2 = ?, department = ?, post = ?, email = ?, contact = ?, gender = ? where id = ?"); 

            
            pstmt.setString(1, editEmp.getNic());
            pstmt.setString(2, editEmp.getFname());
            pstmt.setString(3, editEmp.getLname1());
            pstmt.setString(4, editEmp.getAddress1());
            pstmt.setString(5, editEmp.getAddress2());
            
            pstmt.setString(6, editEmp.getDepartment());
            pstmt.setString(7, editEmp.getPosition());
            pstmt.setString(8, editEmp.getEmail());
            pstmt.setString(9, editEmp.getContact());
            pstmt.setString(10, editEmp.getGender());
            pstmt.setInt(11, editEmp.getId());
           
           /* 
           /* 
             */
            
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