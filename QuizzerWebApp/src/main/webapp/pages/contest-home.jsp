<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h2>${candidate.name}</h2>
<h4>Name: ${contest.name} &nbsp; &nbsp; No of Questions: ${contest.noques}&nbsp; &nbsp; Start date: ${contest.dop} &nbsp; &nbsp;Duration: ${contest.duration} minutes</h4>
<div align="center">
    
	<button onclick="location.href = 'history';"  >Home</button>
    &nbsp; &nbsp; &nbsp; &nbsp;
    <% String button = (String)request.getAttribute("button");
       if(button == "Register"){
    	   %>
    	   <button onclick="location.href = 'register?contestName=${contest.name}';"  >Register</button>
           <%
       }
       else{
    	   %>
    	   <button onclick="location.href = 'start?contestName=${contest.name}';"  >Start</button>
    	   <%
    	   //out.print("Start");
       }
    %>
</div>
<h5>Instruction:</h5>
${contest.summary}

</body>
</html>