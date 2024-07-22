package com.example.circuit.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@RestController
public class ConsumerController {
	@Autowired
	private RestTemplate restTemplate;
	
	private String url="http://localhost:8087/msg";
	
	//@CircuitBreaker(name="Consumer",fallbackMethod = "getCircuitBreakerFallBackResponse")
	//@RateLimiter(name="rateLimiterInstance",fallbackMethod = "rateLimitFallBackResponse")
	
//	 @GetMapping("/getMsgFromProducer")
//	 @TimeLimiter(name="timeLimiterConsumerInstance",fallbackMethod = "timeLimiterFallBackResponse")
//	 public CompletableFuture<String> getMsg() {
//		 System.out.println("Trying to fecth data from another service");
//		 String response=restTemplate.getForObject(url,String.class);
//		 return CompletableFuture.completedFuture(response);
//	 }
	// @Bulkhead(name="bulkHeadConsumerInstance",fallbackMethod = "BulkHeadFallBackResponse")
	 @GetMapping("/getMsgFromProducer")
	 @Retry(name="retryConsumerInstance",fallbackMethod = "RetryFallBackResponse")
	 public String getMsg() {
		 System.out.println("Trying to fecth data from another service at "+LocalDateTime.now().getSecond()+" second");
		 String response=restTemplate.getForObject(url,String.class);
		 
		 return response;
		 
	 }
	 
	 public String getCircuitBreakerFallBackResponse(Exception e) {
		 System.out.println("Circuit Fall back method called");
		 return "Not responding";
	 }
	 
	 public String rateLimitFallBackResponse(Exception e) {
		 System.out.println("Rate Limiter fall back method time "+LocalDateTime.now());
		 return"Rate Limiter fallback method called";
		 
	 }
	 
	 public CompletableFuture<String> timeLimiterFallBackResponse(Exception e) {
		 System.out.println("Time limiter fall back response");
		 return CompletableFuture.completedFuture("OOPS time out purush");
	 }
	 
	 public String BulkHeadFallBackResponse(Exception e) {
		 System.out.println("Bulk head fall back response");
		 return "So many concuurent calls came at a time";
	 }
	 
	 public String RetryFallBackResponse(Exception e) {
		 System.out.println("Retry fall back response "+LocalDateTime.now().getSecond()+" second");
		 return "Retry failed";
	 }

}
