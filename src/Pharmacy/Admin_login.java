package Pharmacy;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin_login
 */
@WebServlet("/Admin")
public class Admin_login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");  
	    PrintWriter out = response.getWriter();  
	          
	    String UserId=request.getParameter("UserId");  
	    String Password=request.getParameter("Password");  
	          
	    if(UserId.equals("Piyush")& Password.equals("2085")){
	        RequestDispatcher rd=request.getRequestDispatcher("Admin_homePage.html");  
	        rd.forward(request,response);  
	    }  
	    else{  
	    	
	        RequestDispatcher rd=request.getRequestDispatcher("Admin.html");  
	        rd.include(request,response);  
	    }  
	          
	    out.close();  
	    }   
		
		
	}
