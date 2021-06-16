package com.injavawetrust.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured")
public class SecuredController {

	@GetMapping("/guest")
	@Secured("ROLE_GUEST")
	public String guest() {
		return "test for guest role";
	}

	@GetMapping("/user")
	@Secured("ROLE_USER")
	public String user() {
		return "test for user role";
	}

	@GetMapping("/roles")
	@Secured({ "ROLE_USER", "ROLE_ADMIN", "ROLE_GUEST" })
	public String roles() {
		return "test for any role";
	}
}
