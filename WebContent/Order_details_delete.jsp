<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order_drop</title>
<style type="text/css">
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
  position: fixed;
  right: 0;
  bottom: 0;
  left: 0;
  padding: 1rem;
  background-color: #efefef;
  text-align: center;
} 
  .main
 {
  width:700px;;
  margin-left:250px;
  margin-top:50px;
  padding: 10px;
  border: 5px solid grey;
   
 }
 table
 {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 600px;
 }
 td
 {
  border: 5px solid silver;
  text-align: center;
  padding: 8px;
 }
 .main
 {
  width:700px;;
  margin-left:250px;
  padding: 10px;
  border: 5px solid grey;
  
 }
 table
 {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 600px;
 }
 td
 {
  border: 5px solid silver;
  text-align: left;
  padding: 8px;
 }

</style> 
  
 <!-- javascript for form validation-->
<script>
  
 function validate()
 {
	  var Brand_name = document.myform.txt_Manuf_name;
	  var Mg=document.myfrom.Med_id;
	  var Quantity=document.myfrom.Stock;
	 
  if (Brand_name.value == "")
  {
   window.alert("please enter Brand_name ?");
   Brand_name.focus();
   return false;
  }
  if (Mg.value == "")
  {
   window.alert("please enter Mg?");
   Mg.focus();
   return false;
  }
  if (Quantity.value == "")
  {
   window.alert("please enter Quantity ?");
  Quantity.focus();
   return false;
  }
 }
   
</script> 
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

 

  
  <center>
    <h1><a href="Order_details.jsp">Back</a></h1>
  </center>

<%@ page import="java.sql.*" %>

<%
try
{
	Class.forName("oracle.jdbc.driver.OracleDriver");

	Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","2085");
	if(request.getParameter("delete")!=null)
	 {
     int Order_id=Integer.parseInt(request.getParameter("delete"));
     out.println("Order_id = "+Order_id);

PreparedStatement pstmt=null;  

pstmt=con.prepareStatement("delete from Order_details where  Order_id=?");
pstmt.setInt(1,Order_id);

pstmt.executeUpdate(); 
con.close(); 

out.println("Delete Successfully...! Click Back link."); 
} 

}
catch(Exception e)
{
out.println("Not Delete ="+e);
}

%>
</body>
</html>