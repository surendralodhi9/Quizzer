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
Contest: ${contestName}
<br>
<div align="center">
	<button onclick="location.href = '../history';"  >Contest history</button>
	&nbsp; &nbsp; &nbsp; &nbsp;
	<button onclick="location.href = 'createContest';" >Create new Contest</button>
</div>
<h1>Leaderboard</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Rank</th><th>Email</th><th>Score</th><th>Finish time</th></tr>  
   <c:forEach var="register" items="${resultList}">   
   <tr>  
	   <td>${rank}</td>  
	   <td>${register.email}</td>  
	   <td>${register.score}</td>
	   <td>${register.completionTime}</td>    
   </tr>
   <% int rank = (int)request.getAttribute("rank");
      request.setAttribute("rank", rank + 1);
   %>  
   </c:forEach>  
   </table>
</body>
</html>