package klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import klu.model.User;
import klu.model.UserManager;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserManager UM;
	
	@PostMapping("/save")
	public String save(@RequestBody User U)
	{
		return UM.saveUser(U);
	}
	
	@GetMapping("/login/{uname}/{pwd}")
	public String login(@PathVariable("uname") String un,@PathVariable("pwd") String pw)
	{
		return UM.loginUser(un, pw);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User U)
	{
		return UM.loginUser(U.getUsername(), U.getPassword());
	}
}
//http://localhost:8080/user/login/hi/4    for password verification
//http://localhost:8080/user/save  for saving data
/*
 * http://localhost:8080/user/login   
 * {
 * "username":"hi",
 * "password":"123"
 * }
 */