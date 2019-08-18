package blueLite.com.service;


import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;


import blueLite.com.model.*;

import blueLite.com.util.DBConnection;








public class Sales_AddFeaturesDao 
{
	private static Connection connection;
	
    public String checkInsert(Sales_Features features)
    {
    	/*String nic = addEmp.getNic();
        String fname=addEmp.getFname(); 
        String lname=addEmp.getLname(); 
       String appDate= addEmp.getAppDate();
       String phone = addEmp.getContact();
        String gender = addEmp.getGender();
        String position=addEmp.getPosition();    
        String email = addEmp.getEmail(); */
        
        
    
        
        try
        {
          
        	connection = DBConnection.createConnection();
            PreparedStatement preparedStatement=null; 
            
            preparedStatement = connection.prepareStatement("insert into bluelite.features(apartmentId,AC,AttachedBathroom,CCTV,serventRoom) values(?,?,?,?,?)"); 
            
            preparedStatement.setInt(1,features.getApartmentId());
			preparedStatement.setString(2, features.getRoom());
			preparedStatement.setString(3,features.getBathroom());
			preparedStatement.setString(4,features.getCCTV());
			preparedStatement.setString(5,features.getsRoom());
			  
           
           
           
           
            
            preparedStatement.executeUpdate(); 
            
            preparedStatement.close(); 
            
            connection.close(); 
            
            return "INSERT SUCCESS"; 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return "FAIL INSERT";
    }
    
}
