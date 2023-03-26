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
<h1>Questions List of ${contest.name}</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Content</th><th>Max Score</th><th>Min Score</th><th>Answer id</th><th>Edit</th><th>Delete</th><th>Add Answers</th></tr>  
   <c:forEach var="question" items="${questionsList}">   
   <tr>  
	   <td>${question.id}</td>  
	   <td>${question.content}</td>  
	   <td>${question.maxScore}</td>
	   <td>${question.minScore}</td> 
	   <td>${question.answerId}</td> 
	   
	   <td><a href="editQuestion?questionId=${question.id}">Edit</a></td>  
	   <td><a href="deleteQuestion?questionId=${question.id}">Delete</a></td>  
	   <td><a href="addAnswers?questionId=${question.id}">Add answers</a></td>  
   </tr>  
   </c:forEach>  
   </table>

</body>
</html>