<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
<style>
html, body
        {
            padding: 0;
            margin-top: 0;
            width: 100%;
            height: 100%;
            font-family: "Helvetica Neue" , Helvetica, sans-serif;
            -webkit-transition: background 1.0s ease-in;
-moz-transition: background 1.0s ease-in;
-ms-transition: background 1.0s ease-in;
-o-transition: background 1.0s ease-in;
transition: background 1.0s ease-in;

}
.header {
  overflow: hidden;
  background-color:#64DDBF;
  padding: 5px 40px;

}

/* Style the header links */
.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 20px;
  text-decoration: none;
   font-family: helvetica, serif;
  line-height: 10px;
  border-radius: 4px;
}
.header img {
  float: left;
  width: 100px;
  height: 100px;
  background: 0;
}

.header h1 {
  position: relative;
  top: 25px;
  left: 15px;
  font-size: 18px;
}

/* Change the background color on mouse-over */
.header a:hover {
  background-color: #ddd;
  color: black;
}

/* Style the active/current link*/
.header a.active {
  background-color: dodgerblue;
  color: white;
}

/* Float the link section to the right */
.header-right {
  float: right;
}

.logincontent
        {
       
            position: absolute;
            width: 850px;
            height: 550px;
            top: 60%;
            left: 56%;
            margin-top: -280px;
            margin-left: -505px;
            background:#FAFAFA ;
            padding-top: 40px;
        }
     
.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}

.col_25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col_50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col_75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col_25,
.col_50,
.col_75 {
  padding: 0 16px;
}

.container {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}

input[type=text] {
  width: 90%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.btn {
  background-color: #4CAF50;
  color: white;
  padding: 12px;
  margin: 10px 0;
   margin-top:15px;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

.btn:hover {
  background-color: #45a049;
}

span.price {
  float: right;
  color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (and change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
}


.footer {
clear: both;
    position: relative;
  padding: 1rem;
     margin-top: 1500px;
  background-color: #efefef;
  text-align: center;
}
 .main
 {
  width:700px;;
  margin-left:350px;
  margin-top:50px;
  padding: 10px;
  border: 5px solid grey;
   
 }
 table
 {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 600px;
  margin-left:50px;
 }
 td
 {
  border: 5px solid silver;
  text-align: center;
  padding: 10px;
  
 }
 a {
  text-decoration: none;
  display: inline-block;
  padding: 8px 16px;
}

a:hover {
  background-color:#E0EDEB ;
  color: black;
}

.previous {
  background-color: #E0EDEB ;
  color: black;
}</style>
</head>
<body>

<div class="header">
  <div class=".header img ">
  <img src="Logo.png" alt="logo" height="62" width="82"></div>
  <a href="index.html" class="logo1"><b><font size="4">MediCrest</font></b><br><br>Live healthy. Live happy. Live Longs.</a>
  
  <div class="header-right">
    <a class="active" href="index.html">Home</a>
     <a href="About.html">About</a>
    <a href="Customers Speak.html">Customers Speak</a>
     </div>
     </div>
      <br>

     <br>
      <a href="Order.html" class="previous"> &laquo; Back</a>
       <%@ page import ="java.io.*" %>
    <%@ page import ="java.sql.*" %>
    <%@page import="java.lang.*" %>
<%		
String   Medicine,Mg, Brand_name,Quantity ,Price_p,stock;
int Profit=0,price=0,rem_stock=0;
 Medicine=(String)request.getAttribute("Med");
 Mg=(String)request.getAttribute("Mg");
 Brand_name=(String)request.getAttribute("Brand_name");
 Quantity=(String)request.getAttribute("Quantity");
	boolean st=true;
%>
 <div class="main">
 <center>
  <h1>Your Cart</h1>
  <br>
  <br>
 </center>
 
<table>

 <tr>
  <th>Med_id</th>
  <th>Medicine</th>
  <th>Mg</th>
  <th>Brand_name</th>
 </tr>
<%
try{

	response.setContentType("text/html;charset=UTF-8");
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","2085");
	PreparedStatement ps=con.prepareStatement("select * from Medicine_stock where Medicine='"+Medicine+"'and Mg='"+Mg+"'and Brand_name='"+Brand_name+"'and Stock >='"+Quantity+"'");
	
	 ResultSet rs=ps.executeQuery();
	   while(rs.next())
	   { 
	  %>
	    <tr>
	     <td> <%=rs.getString(1)%> </td>
	     <td> <%=rs.getString(2)%> </td>
	     <td> <%=rs.getString(3)%> </td>
	     <td> <%=rs.getString(4)%> </td>
	   
	       <%Price_p=rs.getString(6);
	       Profit=Integer.parseInt(Price_p)*Integer.parseInt(Quantity);	 
            price=Profit;
	       stock=rs.getString(5);
	       rem_stock=Integer.parseInt(stock)-Integer.parseInt(Quantity);
	      
		     
	        
	        %>
	      
    </tr>
  <%
   }
	   ps=con.prepareStatement("UPDATE Medicine_stock SET Stock='"+rem_stock+"' where Medicine='"+Medicine+"'and Mg='"+Mg+"' and Brand_name='"+Brand_name+"'");
	   ps.executeUpdate();
	   ps=con.prepareStatement("insert into Sales (PROFIT) values(?)");
	   ps.setInt(1,Profit);
	   ps.executeUpdate();

}

catch(Exception e)
{
	
	e.printStackTrace();
}

/*if(price==0)
{
	RequestDispatcher dd = request.getRequestDispatcher("Error3.html");

	 dd.forward(request, response);
}*/
%>
 </table>
  

<br>
<br>
<br>

<div class="row">
  <div class="col_75">
    <div class="container">

        <div class="row">
          <div class="col_50">
          <h3>Billing Amount:</h3>
              Rs <%=price%>(+GST)
 
        </div>
        <br>
        <a href="Payment_page.html">
        <input type="submit" value="Continue to Payment" class="btn" oncilck="checkout.html"></a>
      </form>
    </div>
  </div> 
 
</div>
</div>
</div>
 <div class="footer">Copyright@2019  <a href="Piyush Gautam.html"> Piyush Gautam </a><strong>  All Right Reserved</strong>
             </div>
    
</body>
</html>