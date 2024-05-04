package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import dto.Employee;
@WebServlet("/signup")
public class RegisterEmployee extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		double sal=Double.parseDouble(req.getParameter("sal"));
		long phone=Long.parseLong(req.getParameter("phone"));
		String email=req.getParameter("mail");
		String pw=req.getParameter("pw");
		String address=req.getParameter("address");
		
		EmployeeDao employeeDao=new EmployeeDao();
		Employee inemployee=employeeDao.fetchByMail(email);
		
		if(inemployee!=null) {
			req.setAttribute("existed", "This mail already register please go with login");
			RequestDispatcher dispatcher=req.getRequestDispatcher("SignUp.jsp");
			dispatcher.forward(req, resp);
		}
		else {
		Employee employee=new Employee();
		employee.setEmployeeName(name);
		employee.setEmployeeAge(age);
		employee.setEmployeeSal(sal);
		employee.setEmployeePhone(phone);
		employee.setEmployeeEmail(email);
		employee.setEmployeePassword(pw);
		employee.setEmployeeAddress(address);
		
		
		Employee dbEmployee=employeeDao.saveEmployee(employee);
		
		if(dbEmployee!=null) {
			req.setAttribute("message", "congratulations your successfully Signed up please proceed to login");
			RequestDispatcher dispatcher=req.getRequestDispatcher("Login.jsp");
			dispatcher.forward(req, resp);
		}
		}
	}
}
