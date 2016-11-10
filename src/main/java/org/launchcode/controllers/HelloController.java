package org.launchcode.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.launchcode.models.HelloLog;
import org.launchcode.models.dao.HelloLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	
	@Autowired
	private HelloLogDao helloLogDao;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String helloform()
	{
		return "helloform";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String hello(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String language = request.getParameter("language");
		//get the name parameter from request; will be null if no parameter is passed in
		if (name == null || name == ""){
			name = "world";
		}
		if (language == null || language == ""){
			language = "Hello";
		}
		
		HelloLog log = new HelloLog(name);
		helloLogDao.save(log);
		
		model.addAttribute("name", name);
		model.addAttribute("language", language);
		model.addAttribute("title", "Hello, Spring! Response");
		return "hello";
		
		
	}
	@RequestMapping(value = "/log")
	public String log(Model model){
		//get data out of db
		List<HelloLog> logs = helloLogDao.findAll();
		//put data into template
		model.addAttribute("logs", logs);
		
		return "log";
	}
	
	
}
