package com.injavawetrust.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@PreAuthorize("hasRole('SUPER_ADMIN')")
public class TopSecretService {

	public String getClassifiedInfo() {
		return "Top Secret";
	}
}
