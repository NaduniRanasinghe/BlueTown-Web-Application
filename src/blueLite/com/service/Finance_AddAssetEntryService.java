package blueLite.com.service;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import blueLite.com.model.*;
import blueLite.com.util.*;

public class Finance_AddAssetEntryService {

	private static Connection connection;

	public String addEntry(Finance_AssetEntry f1) {
		
		String name = f1.getName();
		String type = f1.getType(); 
		String additional = f1.getAdditional(); 
		String otherIDs = f1.getOtherIDs(); 
		double value = f1.getValue();

		try {
			
			connection = DBConnection.createConnection();
			
				PreparedStatement psRev = null;
				
				psRev = connection.prepareStatement("insert into bluelite.asset(Name,Type,AdditionalDetails,OtherIDs, Value) values(?,?,?,?,?)");
				
				psRev.setString(1, name);
				psRev.setString(2, type);
				psRev.setString(3, additional);
				psRev.setString(4, otherIDs);
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