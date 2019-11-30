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

@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		String Username=request.getParameter("firstname"); 
		String Email=request.getParameter("email");
		String Address=request.getParameter("address"); 
		String City=request.getParameter("city");
		String State=request.getParameter("state");
		String Zip=request.getParameter("zip");
		String Name_on_card=request.getParameter("cardname");
		String Cardnumber=request.getParameter("cardnumber");
		String Expmonth=request.getParameter("expmonth");
		String Expyear=request.getParameter("expyear");
		String Cvv=request.getParameter("cvv");
		PrintWriter pw=response.getWriter();
		//pw.print("Welcome"+Username+" ");
		
				
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","2085");
			PreparedStatement ps=con.prepareStatement("insert into Payment_details (Username,Address,City,State,Zip,Name_on_card,Cardnumber,Expmonth,Expyear,Cvv) values(?,?,?,?,?,?,?,?,?,?)");
	        ps.setString(1,Username);
	        ps.setString(2,Address);
	        ps.setString(3,City);
	        ps.setString(4,State);
	        ps.setString(5,Zip);
	        ps.setString(6,Name_on_card);
	        ps.setString(7,Cardnumber);
	        ps.setString(8,Expmonth);
	        ps.setString(9,Expyear);
	        ps.setString(10,Cvv);
	        ps.executeUpdate();
	        response.sendRedirect("checkout.html");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
