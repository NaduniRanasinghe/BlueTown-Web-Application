package blueLite.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import blueLite.com.model.*;
import blueLite.com.util.DBConnection;

public class ORM_EditServiceDao {


	private static Connection connection;
	
    public String checkUpdate(ORM_AddServiceModel s)
    {	
    	
        
      
        
        try
        {
          
            PreparedStatement pstmt=null; 
            connection = DBConnection.createConnection();
            pstmt=connection.prepareStatement("update bluelite.seviceportal set name=?,address_line_1=?,address_line_2=?,city=?,email=?,mobile=?  where id=? "); 

            
            pstmt.setString(1,s.getname());
            pstmt.setString(2,s.getAddress_line_1());
            pstmt.setString(3,s.getAddress_line_2());
            pstmt.setString(4, s.getcity());
            pstmt.setString(5, s.getEmail());
            pstmt.setString(6, s.getMobile());
            pstmt.setInt(7,s.getId());
            
            
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
