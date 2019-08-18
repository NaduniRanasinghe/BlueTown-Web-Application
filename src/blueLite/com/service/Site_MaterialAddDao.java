package blueLite.com.service;

import java.sql.*;


import blueLite.com.model.Site_MaterialDetails;
import blueLite.com.util.DBConnection;

public class Site_MaterialAddDao {
	
	public static Connection conn;
	
	public String checkInsert(Site_MaterialDetails md) {
		String materialName = md.getMaterialName();
		double quantity = md.getQuantity();
        
        try {
        	
        	conn = DBConnection.createConnection();
        	PreparedStatement pstmt = null;
        	
        	pstmt = conn.prepareStatement("insert into bluelite.material(materialName,quantity) values(?,?)");
        	
        	pstmt.setString(1,materialName);
            pstmt.setDouble(2,quantity);
                      
            pstmt.executeUpdate(); 
            
            pstmt.close();   
            conn.close(); 
            
            return "Success";
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return "Fail";
	}

}
