package org.attra.spring.hibernate.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.attra.spring.hibernate.dao.EmployeeDetailDAO;
import org.attra.spring.hibernate.model.Employee;
import org.attra.spring.hibernate.pojo.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;

@Service("EmployeeDetailService")
public class EmployeeDetailService {
	
	@Autowired
	EmployeeDetailDAO employeeDetailDao;
	
	@Transactional
	public List<EmployeeDetails> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDetailDao.getAllEmployees();
	}

	@Transactional
	public Employee getEmployee(String employeeCode) {
		// TODO Auto-generated method stub
		return employeeDetailDao.getEmployee(employeeCode);
	}

	@Transactional
	public void addEmployee(EmployeeDetails employee) {
		// TODO Auto-generated method stub
		employeeDetailDao.addEmployee(employee);
	}

	@Transactional
	public void updateEmployee(EmployeeDetails employee) {
		// TODO Auto-generated method stub
		employeeDetailDao.updateEmployee(employee);
	}

	@Transactional
	public void deleteEmployee(String employeeCode) {
		// TODO Auto-generated method stub
		employeeDetailDao.deleteEmployee(employeeCode);
	}

}
