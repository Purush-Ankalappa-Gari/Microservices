package com.example.circuit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
	
	@GetMapping("/msg")
	public String getMsg() throws InterruptedException {
		return "Heyy hii this is purush from Bethapalli";
	}

}
