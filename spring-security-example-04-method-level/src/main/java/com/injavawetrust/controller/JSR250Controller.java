package com.injavawetrust.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles-allowed")
public class JSR250Controller {

	@GetMapping("/guest")
	@RolesAllowed("ROLE_GUEST")
	public String guest() {
		return "test for guest role";
	}

	@GetMapping("/user")
	@RolesAllowed("ROLE_USER")
	public String user() {
		return "test for user role";
	}

	@GetMapping("/roles")
	@RolesAllowed({ "ROLE_USER", "ROLE_ADMIN", "ROLE_GUEST" })
	public String roles() {
		return "test for any role";
	}
}
