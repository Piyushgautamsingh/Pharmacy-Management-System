package Pharmacy;
import java.sql.*;
public class LoginDao {  
public static boolean validate(String User_id,String Password){  
boolean status=false;
try{  
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","2085");
      
PreparedStatement ps=con.prepareStatement( "select * from User_details where User_id=? and Password=?");  
ps.setString(1,User_id);  
ps.setString(2,Password);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e)
{
	e.printStackTrace();
}  
return status;  
}  
}  