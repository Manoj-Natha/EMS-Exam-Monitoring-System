<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.io.*,java.util.*"%>
     <%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
   <%//@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%//@ taglib uri="http://java.sun.com/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	String sql=("select * from exam_cell  where uname=?");
	stmt=con.prepareStatement(sql);
	stmt.setString(1,s1);
	re=stmt.executeQuery();
	System.out.println("MAYBE1");
	
	if(re.next())
	{
    String url=re.getString(2);
    if(url.equals(s2))
    {
    	 session.setAttribute("username",s1);
         response.sendRedirect("firstpageAdmin.jsp");
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
</html>