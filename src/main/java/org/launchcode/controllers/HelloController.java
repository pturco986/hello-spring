package org.launchcode.controllers;

import javax.servlet.http.HttpServletRequest;

import org.launchcode.models.HelloMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String helloform()
	{
		return "helloform";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String hello(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		
		//get the name parameter from request; will be null if no parameter is passed in
		if (name == null || name == ""){
			name = "world";
		}
		
		model.addAttribute("name", name);
		return "hello";
		
	}
	
	
}
