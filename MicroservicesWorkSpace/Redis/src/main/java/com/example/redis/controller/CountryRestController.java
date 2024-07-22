package com.example.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.binding.Country;
import com.example.redis.service.CountryService;

@RestController
public class CountryRestController {
	
	@Autowired
    private CountryService countryService;

    @GetMapping("/{code}")
    public Country findCountryByCode(@PathVariable String code) {
        return countryService.findCountryByCode(code);
    }

    @GetMapping("/countries")
    public List<Object> findAllCountries() {
        return countryService.findAllCountries();
    }

}
