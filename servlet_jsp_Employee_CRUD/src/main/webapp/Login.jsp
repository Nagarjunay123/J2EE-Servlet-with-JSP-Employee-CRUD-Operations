<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="./stylish.css">
</head>
<body>

<%
String message=(String) request.getAttribute("message");
if(message!=null){
%>	
<h3><%=message%></h3>
<%} %>

<h1 id="h1">Welcome to Login page</h1>

<form action="login" method="post">
	<label>Employee Email : </label>
	<input type="email" placeholder="Enter your Email Address" name="mail"><br><br>
	<%
String email=(String) request.getAttribute("email");
if(email!=null){
%>	
<p><%=email%></p>
<%} %>
	<label>Employee Password : </label>
	<input type="password" placeholder="Enter your password" name="pw"><br><br>
	<%
String password=(String) request.getAttribute("password");
if(password!=null){
%>	
<p><%=password%></p>
<%} %>
	<button class="login">LogIn</button>
	
</form>
<a href="SignUp.jsp"><button class="loginn">SignUp</button></a>

</body>
</html>