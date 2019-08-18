package blueLite.com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import blueLite.com.model.CRM_register;
import blueLite.com.util.DBConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class CRM_registerServices {
	
	Connection conn =null;
	
	public void registerUser(CRM_register register) {
		
	conn = (Connection) DBConnection.createConnection();
	
	
	int cid = register.getCid();
	String nic = register.getNic();
	String fname = register.getFname();
	String lname = register.getLname();
	String email = register.getEmail();
	String mobile = register.getMobile();
	String address1 = register.getAddress1();
	String address2 = register.getAddress2();
	String city = register.getCity();
	String gender = register.getGender();
	String apartmenttype = register.getApartmenttype();
	String site = register.getSite();
	String password = register.getPassword();
	
	 System.out.println(cid);
	 System.out.println(fname);
	 System.out.println(email);
	try {
		
		String query = "insert into customer(nic,firstname,lastname,email,mobile,address1,address2,city,gender,apartmenttype,site,password) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps1 = (PreparedStatement) conn.prepareStatement(query);
		
		
		ps1.setString(1, nic);
		ps1.setString(2, fname);
		ps1.setString(3, lname);
		ps1.setString(4, email);
		ps1.setString(5, mobile);
		ps1.setString(6, address1);
		ps1.setString(7, address2);
		ps1.setString(8, city);
		ps1.setString(9, gender);
		ps1.setString(10, apartmenttype);
		ps1.setString(11, site);
		ps1.setString(12, password);
		
		ps1.executeUpdate();
		
		
		conn.close();
		
	}
	catch(SQLException e){
		
		e.printStackTrace();
	}
	
	
	
	}

}
