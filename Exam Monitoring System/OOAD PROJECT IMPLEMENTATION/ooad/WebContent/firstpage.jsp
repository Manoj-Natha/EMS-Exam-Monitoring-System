<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>EMS | Student</title>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
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
<li><a href="#tabs-1">PROFILE</a></li>
<li><a href="#tabs-2">REGISTER EXAM</a></li>
<li><a href="#tabs-3">RESULTS</a></li>
</ul>
<div id="tabs-1">

<p>Welcome to View Your Profile</p>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/ems"
     user="root"  password="root"/>
 
<sql:query dataSource="${snapshot}" var="result">
SELECT * from student where username="${username}";
</sql:query>
<table border="1" width="100%">
<caption>
Student Profile
</caption>
<c:forEach var="row" items="${result.rows}">
 <tr><th>Student-Name</th><td><c:out value="${row.f_name}"/></td></tr>
 <tr><th>DataofBirth</th><td><c:out value="${row.dob}"/></td></tr>
  <tr><th>Address</th><td><c:out value="${row.address}"/></td></tr>
   <tr><th>City</th><td><c:out value="${row.city}"/></td></tr>
 <tr><th>Email</th><td><c:out value="${row.email}"/></td></tr>
 <tr><th>Country</th><td><c:out value="${row.country}"/></td></tr>       
</c:forEach>
</table>
</div>
<div id="tabs-2">
<center>
<p>Welcome to Exam Registeration</p>
<form name="register" method="POST" action="Registration">
Select the Exam center:<select name="location">
<option value="Chennai">Chennai</option>
<option value="Coimbatore">Coimbatore</option>
<option value="Madurai">Madurai</option>
<option value="Trichy">Trichy</option>
</select><br /><br />
Enter the Exam date: <input type="text" name="testdate" /><br /><br />
Select the Exam Timing:<select name="timing">
<option value="8.30">8.30</option>
<option value="1.30">1.30</option>
</select>
<input type="hidden" value="${username}" name="uname">
<input type="submit" value="Confirm" />
</form>
</center>
</div>
<div id="tabs-3">
<p>Welcome to Results Score</p>
<a href="http://localhost:8080/ooad/checkingresult.html">check your result here</a>


</div>
</div>
</body>
</html>