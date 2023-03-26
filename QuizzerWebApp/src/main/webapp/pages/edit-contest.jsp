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
	  <button onclick="location.href = 'addQuestions?contestName=${contest.name}';" >Add questions</button>
	  <button onclick="location.href = 'publishContest?contestName=${contest.name}';" >Publish Contest</button>
	  <form action="updateContest" id="login-form" method="post">
	    <p>Id:
	    <input type="text" id="id" name="id" value="${contest.id}" required><i class="validation"><span></span><span></span></i>
	    </p>
	    <p> Name:
	    <input type="text" id="name" name="name" value="${contest.name}" required><i class="validation"><span></span><span></span></i>
	    </p>
	    <p>DOC:
	    <input type="text" id="doc" name="doc" value="${contest.doc}" ><i class="validation"><span></span><span></span></i>
	    </p>
	    <p>No questions:
	    <input type="text" id="noques" name="noques" value="${contest.noques}" ><i class="validation"><span></span><span></span></i>
	    </p>
	    <p>DOP:
	    <input type="datetime-local" id="dop" name="dop" value="${contest.dop}" min="2022-12-24T00:00" max="2050-12-24T00:00">
	    </p>
	    <p>Duration:
	    <input type="text" id="duration" name="duration" value="${contest.duration}" required><i class="validation"><span></span><span></span></i>
	    </p>
	    <p>Summary:
	    <!-- 
	    <input type="text" id="summary" name="summary" value="${contest.summary}" ><i class="validation"><span></span><span></span></i>
	    -->
	    <textarea  id="summary" name="summary" cols="50" rows="10">${contest.summary}</textarea>
	    </p>
	    <p>
	    <input type="submit" id="save" value="Update">
	    </p>
	  </form>
      <h6 style="color:red;">${message}</h6>
	</div><!--login-form-wrap-->

</body>
</html>