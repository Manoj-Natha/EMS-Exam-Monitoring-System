<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>EMS | Admin</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
$(function() {
$( "#tabs" ).tabs({
collapsible: true
});
});
</script>
</head>
<body>
<p> Welcome ${username}</p><br><br>
<a href="login.html"> Click here to logout your Session!!!</a>
<div id="tabs">
<ul>
<li><a href="#tabs-2">REGISTER EXAM DETAILS</a></li>
<li><a href="#tabs-3">PUBLISHED RESULTS</a></li>
</ul>

<div id="tabs-2">
<p>Welcome to Exam Registeration</p>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/ems"
     user="root"  password="root"/>
 
<sql:query dataSource="${snapshot}" var="result">
SELECT * from student;
</sql:query>
<table border="1" width="100%">
<caption>
Student Profile
</caption>
<th>Student-Name</th>
<th>roll_no</th>
<c:forEach var="row" items="${result.rows}">
 <tr><td><c:out value="${row.f_name}"/></td> <td><c:out value="${row.roll_no}"/></td></tr>
 <tr></tr>      
</c:forEach>
</table>
</div>
<div id="tabs-3">
<p>Welcome to Results Score</p>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/ems"
     user="root"  password="root"/>
 
<sql:query dataSource="${snapshot}" var="result">
SELECT * from result;
</sql:query>
<table border="1" width="100%">
<caption>
Student Profile
</caption>
<th>Roll_No</th>
<th>UserName</th>
<th>Marks</th>
<th>Email</th>
<c:forEach var="row" items="${result.rows}">
 <tr><td><c:out value="${row.roll_no}"/></td>
 <td><c:out value="${row.username}"/></td>  
 <td><c:out value="${row.marks}"/></td> 
 <td><c:out value="${row.email}"/></td> 
 
 </tr>
 <tr></tr>      
</c:forEach>
</table>
</div>
</div>
</body>
</html>