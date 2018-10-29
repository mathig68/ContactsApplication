package org.valar.project.contactsApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping(value ={"/", "index"})
	public String index() {
		return "index";
	}
	
	@RequestMapping("/user/dashboard")
	public String userDashboard() {
		return "user_dashboard";
	}
	
	@RequestMapping("/admin/dashboard")
	public String adminDashboard() {
		return "admin_dashboard";
	}
}
