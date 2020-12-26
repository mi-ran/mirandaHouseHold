package com.example.demo.web.mvc.controller.view;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	/**
	 * 메인 화면을 리턴한다.
	 * @return
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String index(HttpSession session, Model model) {
		String userId = (String)session.getAttribute("LOGIN_ID");
		model.addAttribute("name", userId);
		return "index.html";
	}
}
