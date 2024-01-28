package com.sip.ams.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sip.ams.entities.AuthenticationBean;

@CrossOrigin(origins = "*")
@RestController
public class BasicAuthRestController {
	@GetMapping(path = "/basicauth")
	public AuthenticationBean basicauth() {
		// verification du user
		return new AuthenticationBean("You are authenticated");
	}
}