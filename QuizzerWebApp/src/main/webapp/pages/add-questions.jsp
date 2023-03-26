<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<h2>Edit contest details</h2>
	<div id="login-form-wrap">
	  <button onclick="location.href = 'displayAllQuestions?contestId=${contest.id}';" >Display questions</button>
	  <button onclick="location.href = 'publishContest?contestName=${contest.name}';" >Publish Contest</button>
	  <form action="saveAndDisplayQuestion" id="login-form" method="post">
	  	<p>Contest id:
	    <input type="text" id="contestId" name="contestId" value="${contest.id}" required><i class="validation"><span></span><span></span></i>
	    </p>
	    <p>Question:
	    <textarea  id="content" name="content" cols="50" rows="10" placeholder="Enter your question" required></textarea>
	    </p>
	    <p>Max Score:
	    <input type="text" id="maxScore" name="maxScore" placeholder="Max Score" required><i class="validation"><span></span><span></span></i>
	    </p>
	    <p>Min Score:
	    <input type="text" id="minScore" name="minScore" placeholder="Min Score" required><i class="validation"><span></span><span></span></i>
	    </p>
	    <p>
	    <input type="submit" id="submit" value="Add">
	    </p>
	  </form>
      <h6 style="color:red;">${message}</h6>
	</div><!--login-form-wrap-->

</body>
</html>