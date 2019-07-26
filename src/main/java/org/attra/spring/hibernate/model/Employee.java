package org.attra.spring.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee{
 
	@Id
	@Column(name="employee_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int employee_id;
 
	@Column(name="employee_code")
	String employee_code; 
 
	@Column(name="employee_name")
	String employee_name;
	
	@Column(name="employee_email")
	String employee_email;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COMPANY_ID",nullable=false)
	private Company company;
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_code() {
		return employee_code;
	}

	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_code=" + employee_code + ", employee_name="
				+ employee_name + ", employee_email=" + employee_email + "]";
	}

	
	
}