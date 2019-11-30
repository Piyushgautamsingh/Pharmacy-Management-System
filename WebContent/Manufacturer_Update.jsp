<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manufacturer_Update</title>
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
	  var Manuf_name = document.myform.txt_Manuf_name;
	  var Med_id=document.myfrom.Med_id;
	  var Stock=document.myfrom.Stock;
	 
  if (Manuf_name.value == "")
  {
   window.alert("please enter Manuf_name ?");
   Mg.focus();
   return false;
  }
  if (Med_id.value == "")
  {
   window.alert("please enter Med_id?");
   Brand_name.focus();
   return false;
  }
  if (Stock.value == "")
  {
   window.alert("please enter Stock ?");
   Brand_name.focus();
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
<div class="main"> 
<form method="post" name="myform"  onsubmit="return validate();">
 
  <center>
   <h1> Update Manufacturer Details </h1>
  </center>
  
  <table> 
  <%
  try
  {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	     	Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","2085");
   if(request.getParameter("edit")!=null) 
   {
  
  
    int Manuf_id=Integer.parseInt(request.getParameter("edit"));
    int Stock,Med_id;
    String Manfu_name; 
    PreparedStatement pstmt=null; 
    
    pstmt=con.prepareStatement("select * from  Manuf_details where Manuf_id=?"); 
    pstmt.setInt(1,Manuf_id);
    ResultSet rs=pstmt.executeQuery();
    
    while(rs.next()) 
    {
     Manuf_id=rs.getInt(1);
     Manfu_name=rs.getString(2);
     Med_id=rs.getInt(3);
     Stock=rs.getInt(3);
   %>
   
   <tr>
    <td>Manuf_name</td>
    <td><input type="text" name="txt_Manfu_name" value="<%=Manfu_name%>"></td>
   </tr> 
   
   <tr>
    <td>Med_id</td>
    <td><input type="Number" name="Med_id" value="<%=Med_id %>"></td>
   </tr> 
   <tr>
    <td>Stock</td>
    <td><input type="number" name="Stock" value="<%=Stock%>"></td>
   </tr> 
   <tr>
   
   
   <tr>
    <td><input type="submit" name="btn_update" value="Update"></td> 
   </tr>
    <input type="hidden" name="txt_hide" value="<%=Manuf_id %>">
  <%
    }
   }
  }
  catch(Exception e)
  {
   out.println(e);
  }
  %> 
 
  </table> 
  
  <center>
    <h1><a href="Manufacturer_display.jsp">Back</a></h1>
  </center>
  
 </form>
</div>
<%@ page import="java.sql.*" %>

<%
try
{
	Class.forName("oracle.jdbc.driver.OracleDriver");

	Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","2085");
if(request.getParameter("btn_update")!=null) 
{
	 int Med_id;
	 int Stock,Manuf_id;
	    String Manfu_name;

Manuf_id=Integer.parseInt(request.getParameter("txt_hide")); 
Manfu_name=request.getParameter("txt_Manfu_name");  
Med_id=Integer.parseInt(request.getParameter("Med_id"));
Stock=Integer.parseInt(request.getParameter("Stock"));

PreparedStatement pstmt=null;  

pstmt=con.prepareStatement("UPDATE  Manuf_details "+" SET  Manfu_name='"+Manfu_name+"',Med_id='"+Med_id+"' ,Stock='"+Stock+"' where Manuf_id='"+Manuf_id+"'");
pstmt.executeUpdate(); 
con.close(); 

out.println("Update Successfully...! Click Back link."); 
} 

}
catch(Exception e)
{
out.println("Not updated ="+e);
}

%>
</body>
</html>