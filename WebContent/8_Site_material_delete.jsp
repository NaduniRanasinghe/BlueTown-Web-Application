<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="blueLite.com.util.DBConnection"%>

<!DOCTYPE html>
<html>

<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link href="css/main.css" rel="stylesheet" type="text/css">
          <link rel="stylesheet" type="text/css" href="stylesheet.css">
</head>
    
<body>        
  
<%
    if(request.getParameter("delete_id")!=null) 
    {
        int id=Integer.parseInt(request.getParameter("delete_id")); 
        
      	Connection connection = null;
        
        try
        {
        	connection = DBConnection.createConnection();
            
            PreparedStatement pstmt=null; 
            
            pstmt=connection.prepareStatement("delete from bluelite.material where materialID=?"); 
            pstmt.setInt(1,id);
            pstmt.executeUpdate(); 

            RequestDispatcher rd=request.getRequestDispatcher("8_Site_material_table.jsp"); 
            rd.forward(request, response); 
            
            pstmt.close(); 
            
            connection.close();   
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
%>