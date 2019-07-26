package org.attra.spring.hibernate.controller;

import java.util.List;

import org.attra.spring.hibernate.service.*;
import org.attra.spring.hibernate.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserDetailController {

	@Autowired
	UserDetailService userDetailService;
	
	@RequestMapping(value = "/")
	public String load(){
		return "redirect:/getAllUsers";
	}
 
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getUsers(Model model) {
		 
		List<UserDetails> listOfUsers = userDetailService.getAllUsers();
		model.addAttribute("userDetails", new UserDetails());
		model.addAttribute("listOfUsers", listOfUsers);
		return "userDetails";
	}
	@RequestMapping(value = "/listoferrorsform", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getUsers1(Model model) {
 
		List<UserDetails> listOfUsers = userDetailService.getAllUsers();
		model.addAttribute("userDetails", new UserDetails());
		model.addAttribute("listOfUsers", listOfUsers);
		return "userDetails";
	}
	
	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public UserDetails getUserById(@PathVariable int id) {
		return userDetailService.getUser(id);
	}
 
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addUser(@ModelAttribute("userDetails") UserDetails userDetails) {	
		if(userDetails.getUserId()==0)
		{
			userDetailService.addUser(userDetails);
		}
		else
		{	
			userDetailService.updateUser(userDetails);
		}
 
		return "redirect:/getAllUsers";
	}
 
	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateUser(@PathVariable("id") int id,Model model) {
		model.addAttribute("userDetails", this.userDetailService.getUser(id));
		model.addAttribute("listOfUsers", this.userDetailService.getAllUsers());
		return "userDetails";
	}
 
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteUser(@PathVariable("id") int id) {
		userDetailService.deleteuser(id);
		return "redirect:/getAllUsers";
 
	}	
}
