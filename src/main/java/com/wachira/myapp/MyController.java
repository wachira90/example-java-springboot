package com.wachira.myapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MyController {

	@GetMapping("/")
	public String rootpath() {
		System.out.println("PATH /");
		return "THIS API V2";
	}
	
	@GetMapping("/hello")
	public String hello() {
		System.out.println("PATH /hello");
		return "Hello Spring Boot Rest API";
	}
}

