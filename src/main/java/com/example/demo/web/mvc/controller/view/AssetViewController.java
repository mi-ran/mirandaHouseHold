package com.example.demo.web.mvc.controller.view;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AssetViewController {

	/**
	 * 자산 뷰를 리턴한다.
	 */
	@RequestMapping(value = "/assetView", method = RequestMethod.GET)
	public String assetView(HttpSession session, Model model, @RequestParam(defaultValue = "") String assetId) {
		String userId = (String)session.getAttribute("LOGIN_ID");
		model.addAttribute("name", userId);
		
		return "naeyuck.html";
	}
}
