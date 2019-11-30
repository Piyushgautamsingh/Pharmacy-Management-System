package Pharmacy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class User_Login extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");  
	    PrintWriter out = response.getWriter();  
	          
	    String UserId=request.getParameter("UserId");  
	    String Password=request.getParameter("Password");  
	    
	          
	    if(LoginDao.validate(UserId, Password)){
	        RequestDispatcher rd=request.getRequestDispatcher("Order.html"); 
	        rd.forward(request,response);
	        
	    }  
	    else{  
	    	
	        RequestDispatcher rd=request.getRequestDispatcher("Error.html");  
	        rd.include(request,response);  
	    }  
	          
	    out.close();  
	    }  
	}  