<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <script type="text/javascript">
        window.history.forward();
        function noBack() {
            window.history.forward();
        }
    </script>
<script>
<!--
<%
String clock = request.getParameter( "clock");
if(clock == null){
	clock = (String)request.getAttribute("duration");
	
}
System.out.println(clock);
%>
var timeout = <%=clock%>;

function timer()
{
if( --timeout > 0 )
{
document.forma.clock.value = timeout;

window.setTimeout( "timer()", 1000 );
}
else
{
document.forma.clock.value = "Time over";

///disable submit-button etc
myFunction()
}
function myFunction() {
	  
	  alert("Time over, click on OK button to submit the contest");
	  ///let text;
	  //let person = prompt("Time over, click on OK button to submit the contest");
	  //if (person == null || person == "") {
	  //  text = "User cancelled the prompt.";
	  //} else {
	  //  text = "Hello " + person + "! How are you today?";
	  //}
	  //document.getElementById("demo").innerHTML = text;
	  document.getElementById('submitButton').click();
	}
}
//-->
</script>
</head>
<body>


<h2>${candidate.email}</h2>
<h4>Name: ${contest.name} &nbsp; &nbsp; No of Questions: ${contest.noques}&nbsp; &nbsp; Start date: ${contest.dop} &nbsp; &nbsp;Duration: ${contest.duration} minutes</h4>
<form action="<%=request.getRequestURL()%>" name="forma">
Remaining time: <input type="text" name="clock" value="<%=clock%>" style="border:0px solid white">

...
</form>

<script>
<!--
timer();
//-->
</script>
<div align="right">
	<button id = "submitButton" onclick="location.href = '/candidate/contest/${contest.name}/submitted';"  >Submit</button>
</div>
<div align="center">
<h5>${question.content}</h5><br><br><br>
<form action="/candidate/contest/start/${contest.name}" method="post">

<input type="hidden" name="questionNo" value="${questionNo}">
<input type="hidden" name="selectedAnswer" value="0">
<input type="hidden" name="duration" value="${duration}">
<ol type="A">
	<c:forEach var="answer" items="${answersList}">
	    
	   <li>
	       <input type="radio" name="selectedAnswer" value="${answer.id}" ${answer.id == selectedAnswer ? 'checked' :''}>
	       ${answer.content}  
	       <br>
	   </li>  
	</c:forEach>
</ol>   
   <br><br><br>
   	    
	    <input type="submit" name="buttonId" value="Previous" onClick="<%request.setAttribute("duration", request.getParameter("clock"));%>">
	    -
	    <input type="submit" name="buttonId" value="Next" >
	    
</form>
   <!-- 
   <a href="/candidate/contest/start/${contest.name}?questionNo=${questionNo - 1}">Previous</a> -
   <a href="/candidate/contest/start/${contest.name}?questionNo=${questionNo + 1}">Next</a> 
    -->
</div>

</body>

</html>