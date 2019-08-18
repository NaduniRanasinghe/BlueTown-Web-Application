package blueLite.com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import blueLite.com.model.CRM_login;

import blueLite.com.util.DBConnection;
import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class CRM_loginService {

Connection connection = null;
	
	public String loginUserService(CRM_login obj) throws SQLException
	{
	
		String user = obj.getNic();
		String pass = obj.getPassword();
		
		
		String cusNic = "";
		String cusPass = "";
		String empNic ="";
		String empPass ="";
		
		//Connect database
		
		
		try {
		    String query1 = "select * from bluelite.customer";
		    String query2 = "select * from bluelite.employee";
		   
		    Connection connection = null;
		    Statement ps = null;
		    Statement ps1 = null;
		    connection = (Connection) DBConnection.createConnection();
		    
		    ps=(Statement) connection.createStatement();
		   ps1=(Statement) connection.createStatement();
		  
			ResultSet rs = ps.executeQuery(query1);
			ResultSet rs1 = ps1.executeQuery(query2);
			
			while(rs.next()){
				
				cusNic = rs.getString("nic");
				cusPass = rs.getString("password");
				
				if(user.equals(cusNic) && pass.equals(cusPass))
				{
					return "SUCCESS";
				}else
					
				 while(rs1.next()){
					
				empNic = rs1.getString("empnic");
				empPass = rs1.getString("emppassword");
				
		
				if(user.equals(empNic) && pass.equals(empPass))
				{
					String val = rs1.getString("department") + rs1.getString("post");
					return  val ;
					
				} 
			} 
					
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "Invalid user credentials";
	}
}
	