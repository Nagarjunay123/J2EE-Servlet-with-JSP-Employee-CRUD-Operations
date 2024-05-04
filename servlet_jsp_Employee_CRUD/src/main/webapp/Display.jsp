<%@page import="dto.Employee"%>
<%@page import="java.util.List"%>
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
 List<Employee> employees=(List)request.getAttribute("Employees");
String name=(String) request.getAttribute("name");
String message2="Welcome To my World Mr."+name;
if(name!=null){
%>	
<h1 id="h1"><%=message2%></h1>
<%} %>
<table border rules="all" cellpadding="10" cellspacing="5">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Age</th>
		<th>Salary</th>
		<th>Phone</th>
		<th>Email</th>
		<th>Password</th>
		<th>Address</th>
		<th>Delete</th>
		<th>Update</th>
	</tr>
<%
for(Employee employee: employees) {
%>
	<tr>
		<td><%=employee.getEmployeeId() %></td>
		<td><%=employee.getEmployeeName() %></td>
		<td><%=employee.getEmployeeAge() %></td>
		<td><%=employee.getEmployeeSal() %></td>
		<td><%=employee.getEmployeePhone() %></td>
		<td><%=employee.getEmployeeEmail() %></td>
		<td><%=employee.getEmployeePassword() %></td>
		<td><%=employee.getEmployeeAddress() %></td>
		<td><a href="delete?id=<%=employee.getEmployeeId()%>"><button>Delete</button></a></td>
		<td><a href="update?id=<%=employee.getEmployeeId()%>"><button>Update</button></a></td>
	</tr>
<%
} %>
</table>
<a href="Login.jsp"><button class="logout">Log Out</button></a>
</body>
</html>
