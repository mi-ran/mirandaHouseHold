package com.example.demo.web.mvc.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public boolean canLogin(HttpSession session, @RequestParam(defaultValue = "") String userId, @RequestParam(defaultValue = "") String password) {
		/*
		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
			// 새로운 계정 등록
			registUser(userId, password);
			session.setAttribute("LOGIN_ID", userId);
			return true;
		}
		boolean result = user.get().getPassword().equals(password);
		if (result) {
			session.setAttribute("LOGIN_ID", userId);
		}
		return result;
		*/
		return false;
	}
	
	public void registUser(String userId, String password) {
		User newUser = new User(userId, password);
		userRepository.save(newUser);
	}
}
