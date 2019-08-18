package blueLite.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import blueLite.com.model.Finance_BillEntry;
import blueLite.com.util.DBConnection;

public class Finance_EditBillEntryService {
	
	public static Connection conn;
	
	public String checkUpdate(Finance_BillEntry re) {
		
		int billNumber = re.getBillNumber();
		String type = re.getType(); 
		String billDate = re.getBillDate();
		String dueDate = re.getDueDate();
		String additional = re.getAdditional();  
		double payment = re.getPayment();
		int hidden_id = re.getHidden_id();
		
		try {
			
			conn = DBConnection.createConnection();
			PreparedStatement pstmt = null;
			
			pstmt = conn.prepareStatement("update bill set BillNumber=?,Type=?,BillDate=?,DueDate=?,AdditionalDetails=?,Payment=? where BillNumber=?");
			
			pstmt.setInt (1, billNumber);
			pstmt.setString(2,type);
			pstmt.setString(3, billDate);
			pstmt.setString(4, dueDate);
			pstmt.setString(5,additional);
			pstmt.setDouble(6,payment);
			pstmt.setInt(7,hidden_id);
			
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


