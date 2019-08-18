package blueLite.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import blueLite.com.model.IL_Logistics;
import blueLite.com.util.DBConnection;

public class IL_LogisticsUpdateDao {

public static Connection conn;
	
	public boolean checkUpdate(IL_Logistics lg) {
		String type = lg.getName(); 
        double cost = lg.getCost(); 
        double maintenanceCost = lg.getMaintenanceCost();
        double fuelCost= lg.getFuelCost();
        int hidden_id = lg.getId();
        double hidden_total = lg.getTotal();
        
        try {
        	
        	conn = DBConnection.createConnection();
        	PreparedStatement pstmt = null;
        	
        	pstmt = conn.prepareStatement("update bluelite.logistics set type=?,cost=?,maintenance_cost=?,fuel_cost=?,total=? where id=?");
        	
        	pstmt.setString(1, type);
            pstmt.setDouble(2, cost);
            pstmt.setDouble(3, maintenanceCost);
            pstmt.setDouble(4, fuelCost);
            pstmt.setDouble(5, hidden_total);
            pstmt.setInt(6, hidden_id);
                      
            pstmt.executeUpdate(); 
            
            pstmt.close(); 
            conn.close(); 
                  
            return true;
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return false;
	}
}
