package com.example.demo.web.mvc.controller.view;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.web.repository.BudgetRepository;

@Controller
public class BudgetViewController {
	@Autowired
	BudgetRepository budgetRepository;
	
	@RequestMapping(value = "/budgetView", method = RequestMethod.GET)
	public String budgetView(HttpSession session, Model model) {
		String userId = (String)session.getAttribute("LOGIN_ID");
		
		model.addAttribute("name", userId);
		return "yeasan.html";
	}
	

}
