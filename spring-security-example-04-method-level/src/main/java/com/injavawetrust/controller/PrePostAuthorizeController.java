package com.injavawetrust.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.injavawetrust.service.TopSecretService;

@RestController
@RequestMapping("/prepost")
public class PrePostAuthorizeController {

	private TopSecretService topSecretService;

	public PrePostAuthorizeController(TopSecretService topSecretService) {
		this.topSecretService = topSecretService;
	}

	@GetMapping("/guest")
	@PreAuthorize("hasRole('ROLE_GUEST') OR hasRole('ROLE_ADMIN') ")
	public String guest() {
		return "test for guest role";
	}

	@GetMapping("/user")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public String user() {
		return "test for user role";
	}

	@GetMapping("/roles")
	@PreAuthorize("!isAnonymous()")
	public String roles() {
		return "test for any role";
	}

	@PreAuthorize("#id<=10 && hasRole('ROLE_GUEST')")
	@GetMapping("/ids/{id}")
	public String checkIdValue(@PathVariable Integer id) {
		return "test for checkIdValue";
	}

	@GetMapping("/top-secret")
	public String topSecret() {
		return topSecretService.getClassifiedInfo();
	}
	
}