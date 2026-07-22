package com.productapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping(path="welcome")
	public String hello(@RequestParam(name="name") String userName,
			@RequestParam(name="address") String userAddress) {
		return "hello champ! "+ userName+" : "+userAddress ;
	}
}
