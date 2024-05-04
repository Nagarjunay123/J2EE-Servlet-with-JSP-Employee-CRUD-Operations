<%@page import="dto.Employee"%>
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
Employee employee=(Employee)request.getAttribute("emp");
%>
<h1 class="vignan">Welcome to Update page here you can change your details</h1>
	<form action="edit" method="post">
		<label>Employee Id : </label>	
		<input type="number" name="id"  readonly value=<%=employee.getEmployeeId() %>>	<br><br>
		
		<label>Employee Name : </label>
		<input type="text" placeholder="Enter Your Name" name="name" value=<%=employee.getEmployeeName() %>><br><br>
		
		<label>Employee Age : </label>
		<input type="number" placeholder="Enter Your Age" name="age" value=<%=employee.getEmployeeAge() %>><br><br>
		 
		<label>Employee Salary : </label> 
		<input type="number" placeholder="Enter Your Salary" name="sal" value=<%=employee.getEmployeeSal() %>><br><br> 
		
		<label>Employee Phone Number : </label> 
		<input type="tel" placeholder="Enter Your Number" name="phone" value=<%=employee.getEmployeePhone() %>><br><br> 
		
		<label>Employee Email : </label> 
		<input type="email" placeholder="Enter Your Email" name="mail" value=<%=employee.getEmployeeEmail() %>><br><br>

		<label>Employee Password : </label> 
		<input type="password" placeholder="Enter Your password" name="pw" value=<%=employee.getEmployeePassword() %>><br><br>
		 
		<label>Employee Address : </label> 
		<input type="text" placeholder="Enter Your Address" name="address" value=<%=employee.getEmployeeAddress() %>><br><br>

		<button class="signup">Update</button>
			
	</form>

</body>
</html>