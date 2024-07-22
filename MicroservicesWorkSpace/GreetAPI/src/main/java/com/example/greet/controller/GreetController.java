package com.example.greet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gre")
public class GreetController {
	@Autowired
	private Environment env;
	
	@GetMapping("/greet")
	public String getGreetMsg() {
		String port=env.getProperty("server.port");
		return "Good morning from GreetAPI with port number "+port;
	}
}



