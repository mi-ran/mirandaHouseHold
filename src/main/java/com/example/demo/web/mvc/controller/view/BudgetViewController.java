package com.example.demo.web.mvc.controller.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.web.mvc.model.Category;
import com.example.demo.web.repository.BudgetRepository;
import com.example.demo.web.repository.CategoryRepository;

@Controller
public class BudgetViewController {
	@Autowired
	BudgetRepository budgetRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/budgetView", method = RequestMethod.GET)
	public String budgetView(HttpSession session, Model model, @RequestParam(defaultValue = "") String assetId, @RequestParam(defaultValue = "-1") int year, @RequestParam(defaultValue = "-1") int month) {
		String userId = (String)session.getAttribute("LOGIN_ID");
		List<Category> cateList = categoryRepository.findByUserId(userId);
		
		model.addAttribute("assetId", assetId);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("categoryList", cateList);
		model.addAttribute("name", userId);
		return "yeasan.html";
	}
	

}
