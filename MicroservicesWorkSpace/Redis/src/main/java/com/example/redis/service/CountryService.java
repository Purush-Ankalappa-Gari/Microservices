package com.example.redis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.redis.binding.Country;

@Service
public class CountryService {
	
	@Autowired
    private RedisTemplate<String, Country> redisTemplate;

    private static final String KEY = "COUNTRYCODES";

    public Country findCountryByCode(String code) {
        return (Country) redisTemplate.opsForHash().get(KEY, code);
    }

    public List<Object> findAllCountries() {
        return redisTemplate.opsForHash().values(KEY);
    }

}
