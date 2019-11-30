package Pharmacy;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Manufacturer_details")
public class Manufacturer_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
	    int Manuf_id=Integer.parseInt(request.getParameter("Manuf_id")); 
		String Manfu_name=request.getParameter("Manuf_Name"); 
		int Med_id=Integer.parseInt(request.getParameter("Med_id")); 
		int Stock=Integer.parseInt(request.getParameter("stock"));
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","2085");
			PreparedStatement ps=con.prepareStatement("insert into Manuf_details values(?,?,?,?)");
	        ps.setInt(1,Manuf_id);
			ps.setString(2,Manfu_name);
	        ps.setInt(3,Med_id);
	        ps.setInt(4,Stock);
	        ps.executeUpdate();
	        
	        response.sendRedirect("Manufacturer Details.html"); 
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception: "+ e.toString());
			response.sendRedirect("Manufacturer_add.html"); 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

	}


	}