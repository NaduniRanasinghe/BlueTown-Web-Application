package blueLite.com.service;


import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;


import blueLite.com.model.*;

import blueLite.com.util.DBConnection;








public class Sales_AddCostDao 
{
	private static Connection connection;
	
    public String checkInsert(Sales_cost fcost)
    {
    	
        try
        {
          
        	connection = DBConnection.createConnection();
            PreparedStatement preparedStatement=null; 
            
            preparedStatement = connection.prepareStatement("insert into bluelite.cost(id,feature,payment) values(?,?,?)"); 
            
            preparedStatement.setInt(1, fcost.getId());
			preparedStatement.setString(2, fcost.getType());
			preparedStatement.setDouble(3,fcost.getCost());
			
           
            
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

