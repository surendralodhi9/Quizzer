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
<div align="center">
	<button onclick="location.href = 'contestHistory';"  >Contest history</button>
	&nbsp; &nbsp; &nbsp; &nbsp;
	<button onclick="location.href = 'createContest';" >Create new Contest</button>
</div>
	<div id="login-form-wrap">
	  <button onclick="location.href = 'displayAllQuestions?contestId=${contest.id}';" >Display questions</button>
	  <button onclick="location.href = 'publishContest?contestName=${contest.name}';" >Publish Contest</button>
	  <form action="saveAndDisplayQuestion" id="login-form" method="post">
	  	<p>Contest id:
	    <input type="text" id="contestId" name="contestId" value="${question.contestId}" required><i class="validation"><span></span><span></span></i>
	    </p>
	  	<p>Question id:
	    <input type="text" id="Id" name="Id" value="${question.id}" required><i class="validation"><span></span><span></span></i>
	    </p>
	    <p>Question:
	    <textarea  id="content" name="content" cols="50" rows="10"  required>${question.content}</textarea>
	    </p>
	    <p>Max Score:
	    <input type="text" id="maxScore" name="maxScore" value="${question.maxScore}" required><i class="validation"><span></span><span></span></i>
	    </p>
	    <p>Min Score:
	    <input type="text" id="minScore" name="minScore" value="${question.minScore}" required><i class="validation"><span></span><span></span></i>
	    </p>
	    <p>Answer Id:
	    <input type="text" id="answerId" name="answerId" value="${question.answerId}" ><i class="validation"><span></span><span></span></i>
	    </p>
	    <p>
	    <input type="submit" id="submit" value="Save">
	    </p>
	  </form>
      <h6 style="color:red;">${message}</h6>
	</div><!--login-form-wrap-->
 
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>QuestionId</th><th>Content</th><th>Edit</th><th>Delete</th><th>Make this as answer</th></tr>  
   <c:forEach var="answer" items="${answersList}">   
   <tr>  
	   <td>${answer.id}</td>  
	   <td>${answer.questionId}</td>  
	   <td>${answer.content}</td>
	   
	   <td><a href="editAnswer?answerId=${answer.id}">Edit</a></td>  
	   <td><a href="deleteAnswer?answerId=${answer.id}">Delete</a></td>  
	   <td><a href="makeAnswer?questionId=${question.id}&answerId=${answer.id}">Make this as answer</a></td>  
   </tr>  
   </c:forEach>  
   </table>
	  <form action="saveAnswers" id="login-form" method="post">
	  	<p>QuestionId:
	    <input type="text" id="questionId" name="questionId" value="${question.id}" required><i class="validation"><span></span><span></span></i>
	    </p>
	    <p>Answer:
	    <textarea  id="content" name="content" cols="50" rows="10" placeholder="Enter your answer" required></textarea>
	    </p>
	    <p>
	    <input type="submit" id="submit" value="Add">
	    </p>
	  </form>

</body>
</html>