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

@WebServlet("/update")
public class UpdateEmployee extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		EmployeeDao employeeDao=new EmployeeDao();
		Employee employee=employeeDao.fetchById(id);
		if(employee!=null)
		req.setAttribute("emp",employee);
		RequestDispatcher dispatcher=req.getRequestDispatcher("Update.jsp");
		dispatcher.forward(req, resp);
		
	}
}
