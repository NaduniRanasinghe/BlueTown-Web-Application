package blueLite.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import blueLite.com.model.IL_RawMaterial;
import blueLite.com.util.DBConnection;

public class IL_RawMaterialUpdateDao {

public static Connection conn;
	
	public boolean checkUpdate(IL_RawMaterial rm) {
		String type = rm.getName(); 
        double quantity = rm.getQuantity(); 
        String unit = rm.getUnit();
        double unitCost= rm.getUnitCost();
        double quota = rm.getQuota();
        int hidden_id = rm.getId();
        double hidden_total = rm.getTotal();
        
        try {
        	
        	conn = DBConnection.createConnection();
        	PreparedStatement pstmt = null;
        	
        	pstmt = conn.prepareStatement("update bluelite.raw_material set type=?,quantity=?,unit=?,unit_cost=?,quota=?,total=? where id=?");
        	
        	pstmt.setString(1,type);
            pstmt.setDouble(2,quantity);
            pstmt.setString(3, unit);
            pstmt.setDouble(4, unitCost);
            pstmt.setDouble(5, quota);
            pstmt.setInt(6, hidden_id);
            pstmt.setDouble(7, hidden_total);
                      
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
