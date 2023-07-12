package com.example.Phase3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class SecurityConfig {
	@GetMapping()
	public String getAllProducts(@RequestParam String username,  @RequestParam String password){
		if(username.equals("kartik") && password.equals("1234"))
			return "Successfully Logged In";
		return "Incorrect Credentials ";
	}
}
