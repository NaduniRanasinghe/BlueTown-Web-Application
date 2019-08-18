package blueLite.com.service;

import java.sql.*;

import blueLite.com.model.Site_SiteDetails;
import blueLite.com.util.*;

public class Site_SiteUpdateDao {
	
	public static Connection conn;
	
	public String checkUpdate(Site_SiteDetails sd){
		String siteName = sd.getSiteName();
		String siteOwnerName = sd.getSiteOwnerName();
		double estimatedCost = sd.getEstimatedCost();
		double receivedAmount = sd.getReceivedAmount();
		String handOverDate = sd.getHandOverDate();
		int current_id = sd.getSiteID();
		
		conn = DBConnection.createConnection();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("update sites2 set siteName=?,siteOwnerName=?,estimatedCost=?,receivedAmount=?,handOverDate=? where siteID=?");
			
			ps.setString(1, siteName);
			ps.setString(2, siteOwnerName);
			ps.setDouble(3, estimatedCost);
			ps.setDouble(4, receivedAmount);
			ps.setString(5, handOverDate);
			ps.setInt(6, current_id);
			
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
			return "success";
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
		
	}

}
