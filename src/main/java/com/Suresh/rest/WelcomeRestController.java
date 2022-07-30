package com.Suresh.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

	@GetMapping("/hello")
	public String getMessage() {
		return "Good Morning";
	}
}
