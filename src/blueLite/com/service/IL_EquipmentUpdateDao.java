package blueLite.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import blueLite.com.model.IL_Equipment;
import blueLite.com.util.DBConnection;

public class IL_EquipmentUpdateDao {

public static Connection conn;
	
	public boolean checkUpdate(IL_Equipment eq) {
		String type = eq.getName(); 
        int quantity = eq.getQuantity(); 
        double unitCost = eq.getUnitCost();
        double maintenanceCost = eq.getMaintenanceCost();
        double hidden_total = eq.getTotal();
        int hidden_id = eq.getId();
        
        try {
        	
        	conn = DBConnection.createConnection();
        	PreparedStatement pstmt = null;
        	
        	pstmt = conn.prepareStatement("update equipment set type=?,quantity=?,unit_cost=?,maintenance_cost=?,total=? where id=?");
        	
        	pstmt.setString(1, type);
            pstmt.setInt(2, quantity);
            pstmt.setDouble(3, unitCost);
            pstmt.setDouble(4, maintenanceCost);
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
