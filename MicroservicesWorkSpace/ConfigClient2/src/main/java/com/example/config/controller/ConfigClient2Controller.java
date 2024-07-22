package com.example.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClient2Controller {
	
	@Value("${message}")
	private String msg;
	
	@GetMapping("/msg")
	public String getMsg() {
		return msg;
	}

}
