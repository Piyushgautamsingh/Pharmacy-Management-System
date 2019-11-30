package Pharmacy;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Connect
 */
@WebServlet("/Connect")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int UNIQUE_CONSTRAINT_VIOLATION = 1;
	boolean st=true;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

		response.setContentType("text/html");
		
		String Userid=request.getParameter("Userid"); 
		String Username=request.getParameter("Username"); 
		String Email=request.getParameter("Email");
		String Password=request.getParameter("Password");
		PrintWriter pw=response.getWriter();
		//pw.print("Welcome"+Username+" ");
		
				
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","2085");
			PreparedStatement ps=con.prepareStatement("insert into User_details values(?,?,?,?)");
	        ps.setString(1,Userid);
	        ps.setString(2,Username);
	        ps.setString(3,Email);
	        ps.setString(4,Password);
	        ps.executeUpdate();
		}
		catch(SQLException e)
		{
			//System.out.println("SQL Exception: "+ e.toString());
			st=false;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		if(st)
		{
			 response.sendRedirect("index.html"); 
		}
		else
		{
			response.sendRedirect("Error_2.html");
		}

		
	}

}
