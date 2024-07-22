package com.example.welcome.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="GREETAPI")
public interface GreetFeign {
	@GetMapping("/API/greet")
	public String getMsgFromGReetApi();

}
