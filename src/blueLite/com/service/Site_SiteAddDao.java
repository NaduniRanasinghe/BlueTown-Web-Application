package blueLite.com.service;

import java.sql.*;


import blueLite.com.model.Site_SiteDetails;
import blueLite.com.util.DBConnection;

public class Site_SiteAddDao {
	
	public static Connection conn;
	
	public String checkInsert(Site_SiteDetails sd) {
		String siteName = sd.getSiteName();
		String siteOwnerName = sd.getSiteOwnerName();
		double estimatedCost = sd.getEstimatedCost();
		double receivedAmount = sd.getReceivedAmount();
		String handOverDate = sd.getHandOverDate();
        
        try {
        	
        	conn = DBConnection.createConnection();
        	PreparedStatement pstmt = null;
        	
        	pstmt = conn.prepareStatement("insert into bluelite.sites2(siteName,siteOwnerName,estimatedCost,receivedAmount,handOverDate) values(?,?,?,?,?)");
        	
        	pstmt.setString(1,siteName);
        	pstmt.setString(2,siteOwnerName);
            pstmt.setDouble(3,estimatedCost);
            pstmt.setDouble(4,receivedAmount);
            pstmt.setString(5,handOverDate);
                      
            pstmt.executeUpdate(); 
            
            pstmt.close();   
            conn.close(); 
            
            return "Success";
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return "Unsuccessed";
	}

}
