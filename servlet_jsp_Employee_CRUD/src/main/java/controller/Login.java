package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import dto.Employee;
@WebServlet("/login")
public class Login extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("mail");
		String pw=req.getParameter("pw");
		
		EmployeeDao employeeDao=new EmployeeDao();
		Employee employee=employeeDao.fetchByMail(email);
		
		if(employee!=null) {
			String p=employee.getEmployeePassword();
			
			if(pw.equals(p)) {
				List<Employee> list=employeeDao.fetchAll();
				req.setAttribute("Employees", list);
				req.setAttribute("name", employee.getEmployeeName());
				RequestDispatcher dispatcher=req.getRequestDispatcher("Display.jsp");
				dispatcher.forward(req, resp);
			}
			else {
				req.setAttribute("password", "Invalid password");
				RequestDispatcher dispatcher=req.getRequestDispatcher("Login.jsp");
				dispatcher.forward(req, resp);

			}
		}
		else {
			req.setAttribute("email", "Email not exist please registrar");
			RequestDispatcher dispatcher=req.getRequestDispatcher("Login.jsp");
			dispatcher.forward(req, resp);		
			}
	}
}
