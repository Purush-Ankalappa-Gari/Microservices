package com.example.welcome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.welcome.feign.GreetFeign;

@RestController
@RequestMapping("wel")
public class WelcomeController {
	@Autowired
	private GreetFeign greetFeign;
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		
		return greetFeign.getMsgFromGReetApi()+" + " + " Heyy this is welocme from WELCOME API";
	}
	
	

}
