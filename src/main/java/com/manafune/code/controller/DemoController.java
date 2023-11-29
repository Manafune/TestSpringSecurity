package com.manafune.code.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/demo")
	public String showDemo() {
		return "Hello Worlf From DEMO";
	}
}
