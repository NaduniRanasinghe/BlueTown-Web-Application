package blueLite.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import blueLite.com.model.Sales_Apartment;
import blueLite.com.util.DBConnection;

public class Sales_EditApartmentDao {


	private static Connection connection;
	
    public String checkUpdate(Sales_Apartment editApart)
    {	
    	
        
      
        
        try
        {
          
            PreparedStatement pstmt=null; 
            connection = DBConnection.createConnection();
            pstmt=connection.prepareStatement("update bluelite.apartment set apartmentName=?,apartmentId=?,site=?,type=?,room=?,squrft=?  where id=? "); 

            
            pstmt.setString(1,editApart.getApartmentname());
            pstmt.setInt(2,editApart.getApartmentId());
            pstmt.setString(3,editApart.getSite());
            pstmt.setString(4, editApart.getType());
            pstmt.setInt(5, editApart.getNumber());
            pstmt.setDouble(6, editApart.getSqureft());
            pstmt.setInt(7, editApart.getId());
            
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
