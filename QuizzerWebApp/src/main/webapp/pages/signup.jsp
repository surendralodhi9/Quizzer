<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Quizzer</title>
<style><%@include file="style.css"%></style>
</head>
<body>
<div>
<center> <h1> Welcome to Quizzer </h1> </center>
</div>

	<!-- partial:index.partial.html -->
	<div id="login-form-wrap">
	  <h2>Sign up as Candidate</h2>
	  <form action="signup-complete" id="login-form" method="post">
	    <p>
	    <input type="text" id="username" name="username" placeholder="Name" required><i class="validation"><span></span><span></span></i>
	    </p>
	    <p>
	    <input type="email" id="email" name="email" placeholder="Email" required><i class="validation"><span></span><span></span></i>
	    </p>
	    <p>
	    <input type="password" id="password" name="password" placeholder="Password" required><i class="validation"><span></span><span></span></i>
	    </p>
		<p>
	    <input type="password" id="confirm_password" name="confirm_password" placeholder="Confirm password" required><i class="validation"><span></span><span></span></i>
	    </p>
	    <p>
	    <input type="submit" id="signup" value="Submit">
	  </form>
	  <div style="color:red;">${message}</div>
	  <div id="create-account-wrap">
         <p>Already have account? <a href="candidate">Login</a><p>
      </div><!--create-account-wrap-->
	</div><!--login-form-wrap-->
	<br>
	<!-- partial -->
</body>
</html>