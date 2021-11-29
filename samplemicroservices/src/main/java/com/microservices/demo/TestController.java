package com.microservices.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@RequestMapping("/welcome")
	public String welcomepage() {
		return "-Welcome to My First Microservices Tutorial-";
	}
}
