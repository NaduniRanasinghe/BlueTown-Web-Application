package blueLite.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import blueLite.com.model.Finance_PurchaseEntry;
import blueLite.com.util.DBConnection;

public class Finance_EditPurchaseEntryService {
	
	public static Connection conn;
	
	public String checkUpdate(Finance_PurchaseEntry re) {
		
		int invoiceNumber = re.getInvoiceNumber();
		String date = re.getDate();
		int sellerID = re.getSellerID();
		String additional = re.getAdditional();  
		double value = re.getValue();
		int hidden_id = re.getHidden_id();
		
		try {
			
			conn = DBConnection.createConnection();
			PreparedStatement pstmt = null;
			
			pstmt = conn.prepareStatement("update purchase set InvoiceNumber=?,Date=?,SellerID=?,AdditionalDetails=?,Value=? where InvoiceNumber=?");
			
			pstmt.setInt (1, invoiceNumber);
			pstmt.setString(2,date);
			pstmt.setInt(3, sellerID);
			pstmt.setString(4,additional);
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


