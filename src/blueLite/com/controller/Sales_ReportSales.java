package blueLite.com.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
//import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;


//@WebServlet("/ReportApartment")
public class Sales_ReportSales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Sales_ReportSales() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	String	url = "jdbc:mysql://localhost:3306/bluelite" ;
	String user ="root";
	
	String pass = "root";
	
		Connection conn = null;
		try {
			conn = (Connection) DriverManager.getConnection(url, user, pass);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
			JasperReport jasperReport = null;
		JasperDesign jasperDesign =  null;
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		 
		String path = getServletContext().getRealPath("/WEB-INF/");
		try {
			jasperDesign = JRXmlLoader.load(path + "/SalesReport.jrxml");
			//String sql = " select id, nic from bluelite.employee";
			//JRDesignQuery newQuery = new JRDesignQuery();
			
			//newQuery.setText(sql);
			
			//jasperDesign.setQuery(newQuery);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			jasperReport = JasperCompileManager.compileReport(jasperDesign);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] byteStream = null;
		try {
			byteStream = JasperRunManager.runReportToPdf(jasperReport, parameters,conn);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		OutputStream outStream = response.getOutputStream();
		
		response.setContentType("application/pdf");
		
		response.setContentLength(byteStream.length);
		
		outStream.write(byteStream, 0, byteStream.length);
		
		
		
		
	}

}
