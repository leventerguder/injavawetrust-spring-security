package com.injavawetrust.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodosController {

	
	@GetMapping("/test1")
	public String test1() {
		return "TodosController#test1";
	}
}
