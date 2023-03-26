<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<h1>Contests List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>No. of Questions</th><th>Creation date</th><th>Publish date</th><th>Duration(in mins)</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="contest" items="${contestList}">   
   <tr>  
	   <td>${contest.id}</td>  
	   <td>${contest.name}</td>  
	   <td>${contest.noques}</td>
	   <td>${contest.doc}</td> 
	   <td>${contest.dop}</td> 
	   <td>${contest.duration}</td>  
	   <td><a href="editContest?contestName=${contest.name}">Edit</a></td>  
	   <td><a href="deleteContest?contestName=${contest.name}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>
</body>
</html>