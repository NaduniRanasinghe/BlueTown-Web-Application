package blueLite.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import blueLite.com.model.Finance_AssetEntry;
import blueLite.com.util.DBConnection;

public class Finance_EditAssetEntryService {
	
	public static Connection conn;
	
	public String checkUpdate(Finance_AssetEntry re) {
		
		String name = re.getName();
		String type = re.getType(); 
		String additional = re.getAdditional(); 
		String otherIDs = re.getOtherIDs(); 
		double value = re.getValue();
		int hidden_id = re.getHidden_id();
		
		try {
			
			conn = DBConnection.createConnection();
			PreparedStatement pstmt = null;
			
			pstmt = conn.prepareStatement("update asset set Name=?,Type=?,AdditionalDetails=?,OtherIDs=?,Value=? where ID=?");
			
			pstmt.setString(1,name);
			pstmt.setString(2,type);
			pstmt.setString(3,additional);
			pstmt.setString(4,otherIDs);
			pstmt.setDouble(5,value);
			pstmt.setInt(6,hidden_id);
			
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


