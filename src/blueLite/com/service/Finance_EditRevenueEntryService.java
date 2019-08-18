package blueLite.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import blueLite.com.model.Finance_RevenueEntry;
import blueLite.com.util.DBConnection;

public class Finance_EditRevenueEntryService {
	
	public static Connection conn;
	
	public String checkUpdate(Finance_RevenueEntry re) {
		
		int Year = re.getYear();
		String Month = re.getMonth();
		String Review = re.getReview();
		Double Revenue = re.getRevenue();
		int hidden_id = re.getId();
		
		try {
			
			conn = DBConnection.createConnection();
			PreparedStatement pstmt = null;
			
			pstmt = conn.prepareStatement("update bluelite.revenue set Year=?,Month=?,Review=?,Revenue=? where ID=?");
			
			pstmt.setInt(1,Year);
			pstmt.setString(2,Month);
			pstmt.setString(3,Review);
			pstmt.setDouble(4,Revenue);
			pstmt.setInt(5,hidden_id);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close(); 
			
			return "Update Successful";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "Update Failed";
	}

}


