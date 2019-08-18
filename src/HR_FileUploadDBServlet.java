


 
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 
@WebServlet("/HR_FileUploadDBServlet")
@MultipartConfig(maxFileSize = 16177215)    
public class HR_FileUploadDBServlet extends HttpServlet {
   
	private static final long serialVersionUID = 1L;
	
    private String dbURL = "jdbc:mysql://localhost:3306/bluelite";
    private String dbUser = "root";
    private String dbPass = "root";
     
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
      
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
         
        InputStream inputStream = null; 
         
        
        Part filePart = request.getPart("cv");
        if (filePart != null) {
            
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            
            inputStream = filePart.getInputStream();
        }
         
        Connection conn = null; 
        String message = null;  
        
        try {
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
 
           
            String sql = "INSERT INTO bluelite.contacts (first_name, last_name, cv) values (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
             
            if (inputStream != null) {
                
                statement.setBlob(3, inputStream);
            }
 
           
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
              
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
           
            request.setAttribute("Message", message);
             
            
            getServletContext().getRequestDispatcher("/1_HR_career-information-portal.jsp").forward(request, response);
        }
    }
}
