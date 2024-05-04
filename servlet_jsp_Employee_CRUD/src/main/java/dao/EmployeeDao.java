package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Employee;

public class EmployeeDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Nag");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Employee saveEmployee(Employee employee) {
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}

	public Employee fetchByMail(String email) {
		Query query = entityManager.createQuery("select e from Employee e where e.employeeEmail=?1");
		query.setParameter(1, email);
		try {
			Employee employee = (Employee) query.getSingleResult();
			return employee;
		} catch (Exception e) {
			return null;
		}
	}

	public List<Employee> fetchAll() {
		Query query = entityManager.createQuery("select e from Employee e ");
		List<Employee> list = query.getResultList();
		return list;
	}
	public boolean deleteEmployee(int id) {
		Employee employee=entityManager.find(Employee.class, id);
		if(employee!=null) {
		entityTransaction.begin();
		entityManager.remove(employee);
		entityTransaction.commit();
		return true;
		}
		else {
			return false;
		}
	}
	public boolean updateEmployee(Employee employee) {
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		return true;
	}
	
	public Employee fetchById(int id) {
		Employee employee=entityManager.find(Employee.class, id);
		return employee;
		}
}
