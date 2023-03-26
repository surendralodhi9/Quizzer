<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome ${user.name}
<br>
<div align="center">
	<button onclick="location.href = 'contestHistory';"  >Contest history</button>
	&nbsp; &nbsp; &nbsp; &nbsp;
	<button onclick="location.href = 'createContest';" >Create new Contest</button>
</div>
<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="emp" items="${contestList}">   
   <tr>  
	   <td>${emp.name}</td>  
	   <td>${emp.name}</td>  
	   <td>${emp.name}</td>  
	   <td>${emp.name}</td>  
	   <td><a href="editemp/${emp.name}">Edit</a></td>  
	   <td><a href="deleteemp/${emp.name}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>
</body>
</html>