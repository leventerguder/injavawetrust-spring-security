package com.injavawetrust;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.injavawetrust.user.User;
import com.injavawetrust.user.UserRepository;

@RestController
@RequestMapping
public class HelloController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/hello/{name}")
	public User hello(@PathVariable String name) {
		return userRepository.findByName(name);
	}
}