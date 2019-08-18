package blueLite.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;


import blueLite.com.model.HR_Salary;
import blueLite.com.util.DBConnection;

public class HR_SalaryDao {

	private static Connection connection;
	
	 public String checkInsert(HR_Salary addSal)
	    {
		 
		 
		 double total = addSal.calculateTotalSal(addSal.getBasicSal(), addSal.getOtRate(), addSal.getOtHrs(), addSal.getBonus(), addSal.getCommission(), addSal.getDecrement());
	      try
	        {
	          
	        	connection = DBConnection.createConnection();
	            PreparedStatement pstmt=null; 
	            
	            pstmt=connection.prepareStatement("insert into bluelite.salary(nic,basicSal,decrement,bonus,otrate,othrs,commission,total) values(?,?,?,?,?,?,?,?)"); 
	            
	            pstmt.setString(1, addSal.getNic());
	            pstmt.setDouble(2, addSal.getBasicSal());
	            pstmt.setDouble(3, addSal.getDecrement());
	            pstmt.setDouble(4, addSal.getBonus());
	            pstmt.setDouble(5, addSal.getOtRate());
	            pstmt.setDouble(6, addSal.getOtHrs());
	            pstmt.setDouble(7, addSal.getCommission());
	            pstmt.setDouble(8, total);
	        
	           
	           
	           
	            
	            pstmt.executeUpdate(); 
	            
	            pstmt.close(); 
	            
	            connection.close(); 
	            
	            return "INSERT SUCCESS"; 
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        
	        return "FAIL INSERT";
	    }
	 
	 
	  public String checkUpdate(HR_Salary editSal)
	    {	
	    	
	    	 double total = editSal.calculateTotalSal(editSal.getBasicSal(), editSal.getOtRate(), editSal.getOtHrs(), editSal.getBonus(), editSal.getCommission(), editSal.getDecrement());
	    	
	        try
	        {
	          
	            PreparedStatement pstmt=null; 
	            connection = DBConnection.createConnection();
	            pstmt=connection.prepareStatement("update bluelite.salary set basicSal = ?, decrement = ?, bonus = ?, othrs = ?, otrate = ?, commission = ?, total = ? where nic = ?"); 

	            
	            
	            pstmt.setDouble(1, editSal.getBasicSal());
	            pstmt.setDouble(2, editSal.getDecrement());
	            pstmt.setDouble(3, editSal.getBonus());
	            pstmt.setDouble(4, editSal.getOtHrs());
	            pstmt.setDouble(5, editSal.getOtRate());
	            pstmt.setDouble(6, editSal.getCommission());
	            pstmt.setDouble(7, total);
	            pstmt.setString(8, editSal.getNic());
	            
	           
	           /* 
	           /* 
	             */
	            
	            pstmt.executeUpdate(); 
	            
	            pstmt.close(); 
	            
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
