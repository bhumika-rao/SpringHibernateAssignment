package org.attra.spring.hibernate.controller;

import org.attra.spring.hibernate.service.EmployeeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import org.attra.spring.hibernate.model.Employee;
import org.attra.spring.hibernate.pojo.EmployeeDetails;

@Controller
public class EmployeeDetailController {

	@Autowired
	EmployeeDetailService employeeDetailService;
	
	@RequestMapping(value = "/add")
	public String load(Model model){
		model.addAttribute("employeeDetails",new EmployeeDetails());
		return "employeeDetails";
	}
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addEmployee(@ModelAttribute("employeeDetails") EmployeeDetails employee) {	
		if(employee.getEmployeeId()==0)
		{
			employeeDetailService.addEmployee(employee);
		}
		else
		{	
			employeeDetailService.updateEmployee(employee);
		}
 
		return "redirect:/getAllEmployees";
	}
 
	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getEmployees(Model model) {
		 
		List<EmployeeDetails> listOfEmployees = employeeDetailService.getAllEmployees();
		model.addAttribute("employeeDetails", new EmployeeDetails());
		model.addAttribute("listOfEmployees", listOfEmployees);
		return "employeeDetails";
	}
	
	
	@RequestMapping(value = "/getEmployee/{employeeCode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Employee getEmployeeById(@PathVariable String employeeCode) {
		return employeeDetailService.getEmployee(employeeCode);
	}
 
	
	
 
	@RequestMapping(value = "/updateEmployee/{employeeCode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateEmployee(@PathVariable("employeeCode") String employeeCode,Model model) {
		model.addAttribute("employeeDetails", this.employeeDetailService.getEmployee(employeeCode));
		model.addAttribute("listOfEmployees", this.employeeDetailService.getAllEmployees());
		return "employeeDetails";
	}
 
	@RequestMapping(value = "/deleteEmployee/{employeeCode}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteEmployee(@PathVariable("employeeCode") String employeeCode) {
		employeeDetailService.deleteEmployee(employeeCode);
		return "redirect:/getAllEmployees";
 
	}
}