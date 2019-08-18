package blueLite.com.service;

import java.sql.*;

import blueLite.com.model.Site_MaterialDetails;
import blueLite.com.util.*;

public class Site_MaterialUpdateDao {
	
	public static Connection conn;
	
	public String checkUpdate(Site_MaterialDetails md){
		String materialName = md.getMaterialName();
		double quantity = md.getQuantity();
		int current_id = md.getMaterialID();
		
		conn = DBConnection.createConnection();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("update material set materialName=?,quantity=? where materialID=?");
			
			ps.setString(1, materialName);
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
