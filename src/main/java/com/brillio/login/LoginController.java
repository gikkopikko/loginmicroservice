package com.brillio.login;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/login")
	public String loginUser(@RequestBody User user) {
		Optional<User> foundUser=userRepository.findByEmail(user.getEmail());
		if(foundUser.isPresent())
		{
			if(foundUser.get().getPassword().equals(user.getPassword()))
				return "Successfull login";
			return "wrong email or passowrd";
		}
		return "email doesn't exits please Sign Up";
	}
	
	@PostMapping("/signup")
	public String signupUser(@RequestBody User user) {
		Optional<User> foundUser=userRepository.findByEmail(user.getEmail());
		if(foundUser.isPresent())
		{
				return "Email already exists";
		}
		userRepository.save(user);
		return "Signup successfull";
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}
