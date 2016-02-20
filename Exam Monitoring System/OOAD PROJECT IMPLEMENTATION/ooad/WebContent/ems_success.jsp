<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EMS | Success</title>
</head>
<body>
<%
String f_name=request.getParameter("f_name");
String l_name=request.getParameter("l_name");
String dob=request.getParameter("dob");
String address=request.getParameter("address");
String mobile=request.getParameter("mobile");
String country=request.getParameter("country");
String zip=request.getParameter("zip");
String gender=request.getParameter("gender");
String email=request.getParameter("email");
String city=request.getParameter("city");
String uname=request.getParameter("uname");
String pwd=request.getParameter("pwd");

try
{
ResultSet re;
Connection con;
PreparedStatement stmt;
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root");
String sqls=("select * from student where email=?");
stmt=con.prepareStatement(sqls);
stmt.setString(1,email);
re=stmt.executeQuery();
if(!re.next()) {
String sql=("insert into student (f_name,l_name,dob,gender,address,mobile,email,city,zip,country,username,password) values (?,?,?,?,?,?,?,?,?,?,?,?)");
stmt=con.prepareStatement(sql);
stmt.setString(1,f_name);
stmt.setString(2,l_name);
stmt.setString(3,dob);
stmt.setString(4,gender);
stmt.setString(5,address);
stmt.setString(6,mobile);
stmt.setString(7,email);
stmt.setString(8,city);
stmt.setString(9,zip);
stmt.setString(10,country);
stmt.setString(11,uname);
stmt.setString(12,pwd);
stmt.executeUpdate();
response.sendRedirect("signupsuccess.jsp");
}
else {
	response.sendRedirect("signupfail.jsp");
}
}
catch(Exception e) {
	e.printStackTrace();
}
%>
</body>
</html>