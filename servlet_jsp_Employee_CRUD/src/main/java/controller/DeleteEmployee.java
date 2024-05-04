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
@WebServlet("/delete")
public class DeleteEmployee extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		EmployeeDao employeeDao=new EmployeeDao();
		boolean ispresent=employeeDao.deleteEmployee(id);
		if(ispresent) {
			List<Employee> list=employeeDao.fetchAll();
			req.setAttribute("Employees", list);
			RequestDispatcher dispatcher=req.getRequestDispatcher("Display.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
