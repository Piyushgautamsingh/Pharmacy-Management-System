<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import ="java.io.*" %>
    <%@ page import ="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Medicine stock</title>
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


a {
  text-decoration: none;
}


   .loginheading
        {
            border-bottom: solid 3px #ffff ;
            padding-left: 55px;
              margin-left: 1px;
            padding-bottom: 22px;
            color: #45B39D ;
            font-size: 40px;
            font-weight: semibold;
            font-family: Sans-serif;
            text-align: center;
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


.footer {
  position: absolute;
  right: 0;
  bottom: 0;
  left: 0;
  top:1800px;
  padding: 1rem;
  background-color: #efefef;
  text-align: center;;
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
  margin-left:30px;
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
}
</style>


</head>
<body>

<div class="header">
  <div class=".header img ">
  <img src="Logo.png" alt="logo" height="62" width="82"></div>
  <a href="index.html" class="logo1"><div class="Head"> <b>MediCrest</b></div><br><br>Live healthy. Live happy. Live Longs.</a>
  
  <div class="header-right">
    <a class="active" href="index.html">Home</a>
     <a href="About.html">About</a>
    <a href="Customers Speak.html">Customers Speak</a>
   
  </div>
</div>
  <br>

     <br>
      <a href="Medicine_display.html" class="previous"> &laquo; Back</a>
<div class="main">
   <center>
    <h1> Medicine Stock</h1>
   </center>
  <table>
  
   <tr>
    <th>Med_id</th>
    <th>Medicine</th>
    <th>Mg</th>
    <th>Brand_name</th>
    <th>Stock</th>
    <th>Price</th>
    <th>Update</th>
    <th>Delete</th>
   </tr>
  <%
  
  try
  { 
	  response.setContentType("text/html;charset=UTF-8");
		Class.forName("oracle.jdbc.driver.OracleDriver");
	
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","2085");
		PreparedStatement ps=con.prepareStatement("select * from Medicine_stock");
        ResultSet rs=ps.executeQuery();   
  
   while(rs.next())
   { 
  %>
    <tr>
     <td> <%=rs.getString(1)%> </td>
     <td> <%=rs.getString(2)%> </td>
     <td> <%=rs.getString(3)%> </td>
     <td> <%=rs.getString(4)%> </td>
      <td> <%=rs.getString(5)%> </td>
       <td> <%=rs.getString(6)%> </td>
     
     <td> <a href="Medicine_Update.jsp?edit=<%=rs.getString(1)%> ">Edit</a> </td>
     <td> <a href="Medicine_delete.jsp?delete=<%=rs.getString(1)%> ">Delete</a> </td>
     
    </tr>
  <%
   }
   
  }
  catch(Exception e)
  {
   out.println(e);
  }
  
  %>
  
  </table>
  
</div>
        <div class="footer">Copyright@2019  <a href="Piyush Gautam.html"> Piyush Gautam </a><strong>  All Right Reserved</strong>
             </div>
</body>
</html>