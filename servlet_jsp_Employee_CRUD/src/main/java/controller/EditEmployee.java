package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import dto.Employee;

@WebServlet("/edit")
public class EditEmployee extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		double sal=Double.parseDouble(req.getParameter("sal"));
		long phone=Long.parseLong(req.getParameter("phone"));
		String email=req.getParameter("mail");
		String pw=req.getParameter("pw");
		String address=req.getParameter("address");
		
		Employee employee=new Employee();
		employee.setEmployeeId(id);
		employee.setEmployeeName(name);
		employee.setEmployeeAge(age);
		employee.setEmployeeSal(sal);
		employee.setEmployeePhone(phone);
		employee.setEmployeeEmail(email);
		employee.setEmployeePassword(pw);
		employee.setEmployeeAddress(address);
		
		EmployeeDao employeeDao=new EmployeeDao();
		boolean ispresent=employeeDao.updateEmployee(employee);
		if(ispresent) {
			List<Employee> list=employeeDao.fetchAll();
			req.setAttribute("Employees", list);
			RequestDispatcher dispatcher=req.getRequestDispatcher("Display.jsp");
			dispatcher.forward(req, resp);
		}
	
	}

}
