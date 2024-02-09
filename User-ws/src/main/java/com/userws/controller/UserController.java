package com.userws.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	@RequestMapping("/status/check")
	public String status() {
		return "Working";
	}

}
