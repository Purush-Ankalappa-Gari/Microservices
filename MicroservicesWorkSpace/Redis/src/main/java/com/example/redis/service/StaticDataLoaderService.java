package com.example.redis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.redis.binding.Country;

import jakarta.annotation.PostConstruct;
@Service
public class StaticDataLoaderService {
	
	@Autowired
	private RedisTemplate<String,Country>redisTemplate;
	
	 static final String KEY ="COUNTRYCODES";
	 
	 @PostConstruct
	 public void loadStaticData() {
		 List<Country>countryList=getStaticData();
		 for(Country country:countryList) {
			 redisTemplate.opsForHash().put(KEY,country.getCountryCode(),country);
			 // Here Key is like group name and after that it will like hashKey and value pairs.
		 }
	 }
	 
	 
	 
	 private List<Country>getStaticData(){
	        // Fetch data from file, database, or any other source
	        // Here we hard-code some static data for simplicity

		 return List.of(
				new Country(1,"INDIA","+91"),
				new Country(2,"BETHAPALLI","+00"));
	 }
	

}
