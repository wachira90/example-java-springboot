package com.wachira.myapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RootController {

	@GetMapping("/")
	public String rootpath() {
		System.out.println("PATH /");
		return "<h1>THIS API ROOT API <br><a href='/swagger-ui/'>[swagger-ui]</a></h1>";
	}
	
	@GetMapping("/hello")
	public String hello() {
		System.out.println("PATH /hello");
		return "Hello Spring Boot Rest API";
	}
}
