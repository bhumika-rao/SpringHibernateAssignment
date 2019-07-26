package org.attra.spring.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COMPANY")
public class Company{
 
	@Id
	@Column(name="company_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int company_id;
 
	@Column(name="company_code")
	String company_code; 
 
	@Column(name="company_name")
	String company_name;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="company")
	private Set<Employee> employeeDetails= new HashSet<Employee>(0);

	public int getCompany_id() {
		return company_id;
	}

	public Set<Employee> getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(Set<Employee> employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public String getCompany_code() {
		return company_code;
	}

	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	@Override
	public String toString() {
		return "Company [company_id=" + company_id + ", company_code=" + company_code + ", company_name=" + company_name
				+ "]";
	}
	
	
	
 
}