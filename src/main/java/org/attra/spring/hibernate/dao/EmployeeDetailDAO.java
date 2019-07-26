package org.attra.spring.hibernate.dao;

import java.util.List;

import org.attra.spring.hibernate.model.Company;
import org.attra.spring.hibernate.model.Employee;
import org.attra.spring.hibernate.model.UserDetails;
import org.attra.spring.hibernate.pojo.EmployeeDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDetailDAO {

	@Autowired
	private SessionFactory sessionFactory;
 
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	private Company mapCompanyDetails(EmployeeDetails employeeDetails) {
		Company company = new Company();
		company.setCompany_id(employeeDetails.getCompanyId());
		company.setCompany_code(employeeDetails.getCompanyCode());
		company.setCompany_name(employeeDetails.getCompanyName());
		
		return company;
	}
	
	private Employee mapEmployeeDetails(EmployeeDetails employeeDetails) {
		Employee employee = new Employee();
		employee.setEmployee_id(employeeDetails.getEmployeeId());
		employee.setEmployee_code(employeeDetails.getEmployeeCode());
		employee.setEmployee_name(employeeDetails.getEmployeeName());
		employee.setEmployee_email(employeeDetails.getEmployeeEmail());
		
		return employee;
	}
	public void addEmployee(EmployeeDetails employeeDetails) {
		Session session = this.sessionFactory.getCurrentSession();
		
		Company company = mapCompanyDetails(employeeDetails);
		Employee employee = mapEmployeeDetails(employeeDetails);
		
		
		company.getEmployeeDetails().add(employee);
		employee.setCompany(company);
		session.save(company);
		
		session.save(employee);
		
	}

	public List<EmployeeDetails> getAllEmployees() {
		Session session = this.sessionFactory.getCurrentSession();
		List<EmployeeDetails> EmployeeList = session.createQuery("from Employee").list();
		return EmployeeList;
	}

	public Employee getEmployee(String employeeCode) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee employeeDetails = (Employee) session.load(Employee.class, new Integer(employeeCode));
		/*EmployeeDetails employeeDetails = (EmployeeDetails) session.load(EmployeeDetail.class, new Integer(employeeCode));*/
		return employeeDetails;
	}

	public void updateEmployee(EmployeeDetails employeeDetails) {
	Session session = this.sessionFactory.getCurrentSession();
		
		//Company company = mapCompanyDetails(employeeDetails);
		Employee employee = mapEmployeeDetails(employeeDetails);
		
		
		//company.getEmployeeDetails().add(employee);
		//employee.setCompany(company);
		//session.update(company);
		
		session.update(employee);
	}

	public void deleteEmployee(String employeeCode) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee employeeDetails = (Employee) session.load(Employee.class, new Integer(employeeCode));
		if (null != employeeDetails) {
			session.delete(employeeDetails);
		}
		 //employeeDetails = (EmployeeDetails) session.load(EmployeeDetails.class, new Integer(id));
		//EmployeeDetails employeeDetails=new EmployeeDetails();
		//employeeDetails.setEmployeeCode(employeeCode);
		
		//Company company = mapCompanyDetails(employeeDetails);
		//Employee employee = mapEmployeeDetails(employeeDetails);
		
		//((Session) company.getEmployeeDetails()).delete(employee);
		//employee.setCompany(company);
		//session.delete(company);
		
		session.delete(employeeDetails);
	}
	

}
