<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>EMS | LOGIN CHECK</title>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
</head>
    <body>
    <%
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    try
	{
	ResultSet re;
	Connection con;
	PreparedStatement stmt;
	 String s1 = (String) request.getAttribute("s1");
	 String s2 = (String) request.getAttribute("s2");
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root");
	String sql=("select * from student  where username=?");
	stmt=con.prepareStatement(sql);
	stmt.setString(1,s1);
	re=stmt.executeQuery();
	if(re.next())
	{
    String url=re.getString(13);
    System.out.println(url);
    if(url.equals(s2))
    {
    	 session.setAttribute("username",s1);
         response.sendRedirect("firstpage.jsp");
    }
    else
    {
    	response.sendRedirect("Error.jsp");
    }
	}
    else
    {
    	response.sendRedirect("Error.jsp");
    }
	
	}
	catch(Exception e)
	{
	out.println("Error:"+e);
	}
    %>
    
        
      </body>
      </html>>