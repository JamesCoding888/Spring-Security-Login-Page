package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@RequestMapping("/")
	// @ResponseBody
	public String welcome() {
		// return "Welcome ! Spring Security";
		return "welcome";
	}
	
	@RequestMapping("/loginpage")	
	public String loginpage() {
		return "loginpage";
	}
	
	@RequestMapping("/fail")
	@ResponseBody
	public String failpage() {
		return "fail";
	}
	
	@RequestMapping("/adminpage")
	@ResponseBody
	public String adminpage() {
		return "adminpage";
	}
	
	@RequestMapping("/managerpage")
	@ResponseBody
	public String managerpage() {
		return "managerpage";
	}
	
	@RequestMapping("/employeepage")
	@ResponseBody
	public String employeepage() {
		return "employeepage";
	}
}
