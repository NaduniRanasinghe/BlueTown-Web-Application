package blueLite.com.service;


import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;

import blueLite.com.model.CRM_register;
import blueLite.com.util.DBConnection;

public class CRM_editServices
{
	Connection connection = null;
	
	
	
    public String checkUpdate(CRM_register editCus)
    {
    	connection = (Connection) DBConnection.createConnection();
    	
    	int cid = editCus.getCid();
    	String nic = editCus.getNic();
    	String fname = editCus.getFname();
    	String lname = editCus.getLname();
    	String email = editCus.getEmail();
    	String mobile = editCus.getMobile();
    	String address1 = editCus.getAddress1();
    	String address2 = editCus.getAddress2();
    	String city = editCus.getCity();
    	String gender = editCus.getGender();
    	String apartmenttype = editCus.getApartmenttype();
    	String site = editCus.getSite();
    	String password = editCus.getPassword();
	
		 
      
        
        try
        {
        	String query = ("update bluelite.customer set nic = ?,firstname = ?,lastname = ?,email = ?,mobile = ?,address1 = ?,address2 = ?,city = ?,gender = ?,apartmenttype  = ?,site = ?,password = ? where cusid = ?");
    		
    		PreparedStatement ps1 = (PreparedStatement) connection .prepareStatement(query);
    		 

    		
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
    		ps1.setInt(13, cid);
    		
            ps1.executeUpdate(); 
            
            ps1.close(); 
            
            connection.close();
            
            return "UPDATE SUCCESS"; 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return "FAIL UPDATE"; 
    }

}
