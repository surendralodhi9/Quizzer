<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome ${user.name}
<div align="center">
	<button onclick="location.href = 'contestHistory';"  >Contest history</button>
	&nbsp; &nbsp; &nbsp; &nbsp;
	<button onclick="location.href = 'createContest';" >Create new Contest</button>
</div>
<h1>Create New Contest</h1>
<div id="login-form-wrap">

	  <form action="createNewContest" id="login-form" method="get">
	    <p>
	    <input type="text" id="contestName" name="contestName" placeholder="Enter the contest name" required><i class="validation"><span></span><span></span></i>
	    </p>
	    <p>
	    <input type="submit" id="create" value="Create Contest">
	  </form>
      <h4 style="color:red;">${message}</h4>
	</div><!--login-form-wrap-->
</body>
</html>