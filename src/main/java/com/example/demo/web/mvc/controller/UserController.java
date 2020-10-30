package com.example.demo.web.mvc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.web.mvc.model.User;
import com.example.demo.web.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/login/{id}", method = RequestMethod.GET)
	public boolean canLogin(@PathVariable String userId, @RequestParam(defaultValue = "") String password) {
		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
			// 새로운 계정 등록
			registUser(userId, password);
			return true;
		}
		return user.get().getPassword().equals(password);
	}
	
	public void registUser(String userId, String password) {
		User newUser = new User(userId, password);
		userRepository.save(newUser);
	}
}
