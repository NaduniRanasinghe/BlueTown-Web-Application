package blueLite.com.service;

import java.sql.Connection; 
import java.sql.PreparedStatement;

import blueLite.com.model.IL_RawMaterial;
import blueLite.com.util.DBConnection;

public class IL_RawMaterialAddDao {
	
	public static Connection conn;
	
	public boolean checkInsert(IL_RawMaterial rm) {
		String type = rm.getName(); 
        double quantity = rm.getQuantity();
        String unit = rm.getUnit();
        double unitCost= rm.getUnitCost();
        double quota = rm.getQuota();
        double hidden_total = rm.getTotal();
        
        try {
        	
        	conn = DBConnection.createConnection();
        	PreparedStatement pstmt = null;
        	
        	pstmt = conn.prepareStatement("insert into bluelite.raw_material(type,quantity,unit,unit_cost,quota,total) values(?,?,?,?,?,?)");
        	
        	pstmt.setString(1, type);
            pstmt.setDouble(2, quantity);
            pstmt.setString(3, unit);
            pstmt.setDouble(4, unitCost);
            pstmt.setDouble(5, quota);
            pstmt.setDouble(6, hidden_total);
                      
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
