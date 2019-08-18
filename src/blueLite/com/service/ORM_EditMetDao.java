package blueLite.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import blueLite.com.model.*;
import blueLite.com.util.DBConnection;

public class ORM_EditMetDao {


	private static Connection connection;
	
    public String checkUpdate(ORM_AddMetModel m)
    {	
    	
        
      
        
        try
        {
          
            PreparedStatement pstmt=null; 
            connection = DBConnection.createConnection();
            pstmt=connection.prepareStatement("update bluelite.metportal set company_name=?, address_line_1=? ,address_line_2=?,city=?,email=?,mobile=?, item_name=?,unit_price=? where id=? "); 

            
            pstmt.setString(1,m.getCompany_name());
            pstmt.setString(2,m.getAddress_line_1());
            pstmt.setString(3,m.getAddress_line_2());
            pstmt.setString(4, m.getCity());
            pstmt.setString(5, m.getEmail());
            pstmt.setString(6, m.getMobile());
            pstmt.setString(7, m.getItem_name());
            pstmt.setDouble(8, m.getUnit_Price());           
            pstmt.setInt(9,m.getId());
            
            
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
