package org.valar.project.contactsApplication.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.valar.project.contactsApplication.model.User;
import org.valar.project.contactsApplication.service.UserServiceImpl;

//import org.valar.project.contactsApplication.model.User;

@Controller
public class RegistrationController {

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse rsponse) {
		ModelAndView modelView = new ModelAndView("register");
		modelView.addObject("user", new User());
		return modelView;
	}

	@RequestMapping(value = "registerProcess", method = RequestMethod.POST)
	public ModelAndView  saveUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) {
		userService.registerUser(user);
		return new ModelAndView("welcome", "firstname", user.getFirstname());
	}
}
