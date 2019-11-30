package Pharmacy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Medicine_stock")
public class Medicine_stock extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean st=true;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	
	    int Med_id=Integer.parseInt(request.getParameter("Med_id")); 
		String Medicine=request.getParameter("Medicine"); 
		String Mg=request.getParameter("Mg"); 
		String Brand_name=request.getParameter("Brand Name");
		String Stock=request.getParameter("stock");
		int Price=Integer.parseInt(request.getParameter("Price"));
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","2085");
			PreparedStatement ps=con.prepareStatement("insert into Medicine_stock values(?,?,?,?,?,?)");
	        ps.setInt(1,Med_id);
			ps.setString(2,Medicine);
	        ps.setString(3,Mg);
	        ps.setString(4,Brand_name);
	        ps.setString(5,Stock);
	        ps.setInt(6,Price);
	        ps.executeUpdate();
	        
	        response.sendRedirect("Medicine_display.html"); 
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception: "+ e.toString());
			response.sendRedirect("Medicine.html"); 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

	}

}
