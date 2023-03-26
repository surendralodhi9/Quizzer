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
Welcome ${candidate.name}
<br>
<h1>Contests List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Name</th><th>Score</th><th>Completion time</th><th>Go to contest</th><th>Leaderboard</th></tr>  
   <c:forEach var="register" items="${registerList}">   
   <tr>   
	   <td>${register.contestName}</td>  
	   <td>${register.score}</td>
	   <td>${register.completionTime}</td>  
	   <td><a href="/candidate/contest/${register.contestName}">Go to contest</a></td>  
	   <td><a href="/candidate/contest/${register.contestName}/leaderboard">Leaderboard</a></td>  
   </tr>  
   </c:forEach>
   </table>
</body>
</html>