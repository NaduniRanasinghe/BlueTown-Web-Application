package blueLite.com.service;


	import java.sql.Connection;
	//import java.sql.DriverManager;
	import java.sql.PreparedStatement;

	import blueLite.com.model.ORM_AddHRModel;
	
	import blueLite.com.util.*;


	public class ORM_HRDao 
	{
		private static Connection connection;
		
	    public String checkInsert(ORM_AddHRModel addhr)
	    {
	    
	        String name=addhr.getname(); 
	        String address_line_1 = addhr.getAddress_line_1();
	        String address_line_2 = addhr.getAddress_line_2();
	        String city=addhr.getCity();    
	        String email = addhr.getEmail();
	        String mobile = addhr.getMobile();
	        
	    
	        
	        try
	        {
	          
	        	connection = DBConnection.createConnection();
	            PreparedStatement pstmt=null; 
	            
	            pstmt=connection.prepareStatement("insert into blueLite.hrportal(namehr,address_line_1,address_line_2,city,email,mobile) values(?,?,?,?,?,?)"); 
	            
	            
	        
	            
	            pstmt.setString(1,name);
	            pstmt.setString(2,address_line_1);
	            pstmt.setString(3,address_line_2);
	            pstmt.setString(4,city);
	            pstmt.setString(5, email);
	            pstmt.setString(6, mobile);
	           	            
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





