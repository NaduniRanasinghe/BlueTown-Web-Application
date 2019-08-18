package blueLite.com.service;

import java.sql.*;

import blueLite.com.model.Site_MachineryDetails;
import blueLite.com.util.*;

public class Site_MachineryUpdateDao {
	
	public static Connection conn;
	
	public String checkUpdate(Site_MachineryDetails md){
		String machineryName = md.getMachineryName();
		double quantity = md.getQuantity();
		int current_id = md.getMachinaryID();
		
		conn = DBConnection.createConnection();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("update machinery set machineryName=?,quantity=? where machineryID=?");
			
			ps.setString(1, machineryName);
			ps.setDouble(2, quantity);
			ps.setInt(3, current_id);
			
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
