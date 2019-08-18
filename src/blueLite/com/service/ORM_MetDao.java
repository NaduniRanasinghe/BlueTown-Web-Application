package blueLite.com.service;

	import java.sql.Connection;
import java.sql.PreparedStatement;

import blueLite.com.model.ORM_AddMetModel;
import blueLite.com.util.DBConnection;

	public class ORM_MetDao
	{
		private static Connection connection;
		
	    public String checkInsert(ORM_AddMetModel addmet)
	    {
	    
	        String company_name=addmet.getCompany_name(); 	       
	        String address_line_1 = addmet.getAddress_line_1();
	        String address_line_2 = addmet.getAddress_line_2();
	        String city=addmet.getCity(); 	        
	        String email = addmet.getEmail();
	        String mobile = addmet.getMobile();
	        String item_name = addmet.getItem_name();
	        double Unit_Price=addmet.getUnit_Price();
	        
	    
	        
	        try
	        {
	          
	        	connection = DBConnection.createConnection();
	            PreparedStatement pstmt=null; 
	            
	            pstmt=connection.prepareStatement("insert into bluelite.metportal(company_name,address_line_1,address_line_2,city,email,mobile,item_name,unit_price) values(?,?,?,?,?,?,?,?)"); 
	           
	            
	            
	            pstmt.setString(1,company_name);
	            pstmt.setString(2,address_line_1);
	            pstmt.setString(3,address_line_2);
	            pstmt.setString(4, city);
	            pstmt.setString(5, email);
	            pstmt.setString(6, mobile);
	            pstmt.setString(7, item_name);
	            pstmt.setDouble(8, Unit_Price);
		               
	           	            
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








