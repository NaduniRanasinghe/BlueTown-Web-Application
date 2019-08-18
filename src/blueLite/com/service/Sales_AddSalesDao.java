package blueLite.com.service;


import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;


import blueLite.com.model.*;

import blueLite.com.util.DBConnection;








public class Sales_AddSalesDao 
{
	private static Connection connection;
	
    public String checkInsert(Sales_Sales sale)
    {
    	
        try
        {
          
        	connection = DBConnection.createConnection();
            PreparedStatement preparedStatement=null; 
            
            preparedStatement = connection.prepareStatement("insert into bluelite.sales(saleID,totPay,intPay,instlCount,cusID) values(?,?,?,?,?)"); 
            
            preparedStatement.setInt(1,sale.getSaleId());
			preparedStatement.setDouble(2,sale.getTotPay());
			preparedStatement.setDouble(3,sale.getIntPay());
			preparedStatement.setInt(4,sale.getInstlCount());
			preparedStatement.setInt(5,sale.getCusId());
			//preparedStatement.setDate(5,sale.getDate());
		 
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

