package blueLite.com.service;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import blueLite.com.model.*;
import blueLite.com.util.*;

public class Finance_AddFinanceEntryService {

	private static Connection connection;

	public String addEntry(Finance_FinanceEntry f1) {
		int year = f1.getYear();
		String month = f1.getMonth();
		String review = f1.getReview(); 
		double revenue = f1.getRevenue();

		try {
			
			connection = DBConnection.createConnection();
			
				PreparedStatement psRev = null;
				
				psRev = connection.prepareStatement("insert into bluelite.revenue(Year,Month,Review,Revenue) values(?,?,?,?)");
				
				psRev.setInt(1, year);
				psRev.setString(2, month);
				psRev.setString(3, review);
				psRev.setDouble(4, revenue); 
				
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