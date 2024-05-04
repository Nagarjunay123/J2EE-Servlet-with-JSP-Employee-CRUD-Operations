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
<h1 id="h1">Welcome to Registration page</h1>
	<form action="signup" method="post">
		<label>Employee Name : </label> 
		<input type="text" placeholder="Enter Your Name" name="name"><br><br> 
		
		<label>Employee Age : </label> 
		<input type="number" placeholder="Enter Your Age" name="age"><br><br>
		 
		<label>Employee Salary : </label> 
		<input type="number" placeholder="Enter Your Salary" name="sal"><br><br>
		 
		<label>Employee Phone Number : </label> 
		<input type="tel" placeholder="Enter Your Number" name="phone"><br><br>
		 
		<label>Employee Email : </label> 
		<input type="email" placeholder="Enter Your Email" name="mail"><br><br>

		<%
		String existed = (String) request.getAttribute("existed");
		if (existed != null) {
		%>
		<p><%=existed%></p>
		<%
		}
		%>
		

		<label>Employee Password : </label> 
		<input type="password" placeholder="Enter Your password" name="pw"><br><br> 
		
		<label>Employee Address : </label> 
		<input type="text" placeholder="Enter Your Address" name="address"><br><br>

		<button class="signup">SignUp</button>
		
		
	</form>
	<a href="Login.jsp"><button id="nag" class="signupp">Login</button></a>
</body>
</html>