package com.injavawetrust.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PingController {

	@GetMapping("/ping")
	public String ping() {
		return "PingController#ping";
	}
	
	@GetMapping("/ping2")
	public String ping2() {
		return "PingController#ping2";
	}
}
