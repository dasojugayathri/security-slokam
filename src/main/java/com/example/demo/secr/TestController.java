package com.example.demo.secr;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("hello")
	public String m1() {
		return "hello";
	}
	@PreAuthorize("hasRole('USER')")
	@GetMapping("get")
	public String m2() {
		return "hello";
	}
	@GetMapping("/api/all")
	public String m3() {
		return "success";
	}

}
