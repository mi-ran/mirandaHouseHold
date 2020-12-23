package com.example.demo.web.mvc.controller.view;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	/**
	 * 로그인 페이지를 리턴한다.
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login.html";
	}
	
	/**
	 * 로그아웃 시킨다.
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public Boolean logout(HttpSession session) {
		session.removeAttribute("LOGIN_ID");
		System.out.println("logout");
		return true;
	}
}
