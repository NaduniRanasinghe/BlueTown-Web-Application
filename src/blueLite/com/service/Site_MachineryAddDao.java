package blueLite.com.service;

import java.sql.*;


import blueLite.com.model.Site_MachineryDetails;
import blueLite.com.util.DBConnection;

public class Site_MachineryAddDao {
	
	public static Connection conn;
	
	public String checkInsert(Site_MachineryDetails md) {
		String machineryName = md.getMachineryName();
		double quantity = md.getQuantity();
        
        try {
        	
        	conn = DBConnection.createConnection();
        	PreparedStatement pstmt = null;
        	
        	pstmt = conn.prepareStatement("insert into bluelite.machinery(machineryName,quantity) values(?,?)");
        	
        	pstmt.setString(1,machineryName);
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
