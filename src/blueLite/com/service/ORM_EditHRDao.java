package blueLite.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import blueLite.com.model.*;
import blueLite.com.util.DBConnection;

public class ORM_EditHRDao {


	private static Connection connection;
	
    public String checkUpdate(ORM_AddHRModel hr)
    {	
    	
        
      
        
        try
        {
          
            PreparedStatement pstmt=null; 
            connection = DBConnection.createConnection();
            pstmt=connection.prepareStatement("update bluelite.hrportal set namehr=?,address_line_1=?,address_line_2=?,city=?,email=?,mobile=?  where id=? "); 

            
            pstmt.setString(1,hr.getname());
            pstmt.setString(2,hr.getAddress_line_1());
            pstmt.setString(3,hr.getAddress_line_2());
            pstmt.setString(4, hr.getCity());
            pstmt.setString(5, hr.getEmail());
            pstmt.setString(6, hr.getMobile());
            pstmt.setInt(7,hr.getId());
            
            
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
