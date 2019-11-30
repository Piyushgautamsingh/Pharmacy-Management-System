package Pharmacy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Order_details")
public class Order_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	response.setContentType("text/html");
		String Medicine=request.getParameter("Medicine"); 
		request.setAttribute("Med",Medicine);
		request.getRequestDispatcher("Payment.jsp");
		String Mg=request.getParameter("Mg"); 
		request.setAttribute("Mg",Mg);
		request.getRequestDispatcher("Payment.jsp");
		String Brand_name=request.getParameter("Brand Name");
		request.setAttribute("Brand_name",Brand_name);
		request.getRequestDispatcher("Payment.jsp");
		String quantity=request.getParameter("Quantity");
		request.setAttribute("Quantity",quantity);
		request.getRequestDispatcher("Payment.jsp").forward(request, response);
		
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","2085");
			PreparedStatement ps=con.prepareStatement("insert into Order_details (Medicine,Mg,Brand_name,Quantity) VALUES (?,?,?,?,?)");
	        ps.setString(1,Medicine);
	        ps.setString(2,Mg);
	        ps.setString(3,Brand_name);
	        ps.setString(4,quantity);
	        ps.executeUpdate();
	        response.sendRedirect("Payment.jsp"); 
		}
		  catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("Error3.html");
			}

	}

}
