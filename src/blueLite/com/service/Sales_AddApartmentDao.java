package blueLite.com.service;


import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;


import blueLite.com.model.*;

import blueLite.com.util.DBConnection;








public class Sales_AddApartmentDao 
{
	private static Connection connection;
	
    public String checkInsert(Sales_Apartment apart)
    {
    	
        try
        {
          
        	connection = DBConnection.createConnection();
            PreparedStatement preparedStatement=null; 
            
            preparedStatement = connection.prepareStatement("insert into bluelite.apartment(apartmentName,apartmentId,site,type,room,squrft) values(?,?,?,?,?,?)"); 
            
            preparedStatement.setString(1, apart.getApartmentname());
			preparedStatement.setInt(2, apart.getId());
			preparedStatement.setString(3, apart.getSite());
			preparedStatement.setString(4, apart.getType());
			preparedStatement.setInt(5, apart.getNumber());
			preparedStatement.setDouble(6, apart.getSqureft());  
           
           
           
           
            
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

