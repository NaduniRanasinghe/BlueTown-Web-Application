package blueLite.com.service;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import blueLite.com.model.*;
import blueLite.com.util.*;

public class Finance_AddBillEntryService {

	private static Connection connection;

	public String addEntry(Finance_BillEntry f1) {
		
		int billNumber = f1.getBillNumber();
		String type = f1.getType(); 
		String billDate = f1.getBillDate();
		String dueDate = f1.getDueDate();
		String additional = f1.getAdditional();  
		double payment = f1.getPayment();

		try {
			
			connection = DBConnection.createConnection();
			
				PreparedStatement psRev = null;
				
				psRev = connection.prepareStatement("insert into bluelite.bill(BillNumber,Type,BillDate,DueDate,AdditionalDetails,Payment) values(?,?,?,?,?,?)");
				
				psRev.setInt(1, billNumber);
				psRev.setString(2, type);
				psRev.setString(3, billDate);
				psRev.setString(4, dueDate);
				psRev.setString(5, additional);
				psRev.setDouble(6, payment);
				
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