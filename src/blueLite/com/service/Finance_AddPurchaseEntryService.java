package blueLite.com.service;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import blueLite.com.model.*;
import blueLite.com.util.*;

public class Finance_AddPurchaseEntryService {

	private static Connection connection;

	public String addEntry(Finance_PurchaseEntry f1) {
		
		int invoiceNumber = f1.getInvoiceNumber();
		String date = f1.getDate();
		int sellerID = f1.getSellerID(); 
		String additional = f1.getAdditional(); 
		double value = f1.getValue();

		try {
			
			connection = DBConnection.createConnection();
			
				PreparedStatement psRev = null;
				
				psRev = connection.prepareStatement("insert into bluelite.purchase(InvoiceNumber, Date, SellerID, AdditionalDetails, Value) values(?,?,?,?,?)");
				
				psRev.setInt(1, invoiceNumber);
				psRev.setString(2, date);
				psRev.setInt(3, sellerID);
				psRev.setString(4, additional);
				psRev.setDouble(5, value); 
				
				psRev.executeUpdate();
				psRev.close();
				
				connection.close();

			return "INSERT SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "FAIL INSERT";
	}

}