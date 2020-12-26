package com.example.demo.web.mvc.controller.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.web.mvc.model.Asset;
import com.example.demo.web.mvc.model.Debt;
import com.example.demo.web.repository.AssetRepository;
import com.example.demo.web.repository.DebtRepository;

@Controller
public class MainController {

	@Autowired
	AssetRepository assetRepository;
	
	@Autowired
	DebtRepository debtRepository;
	
	/**
	 * 메인 화면을 리턴한다.
	 * @return
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String index(HttpSession session, Model model) {
		String userId = (String)session.getAttribute("LOGIN_ID");
		List<Asset> assetList = assetRepository.findByUserId(userId);
		List<Debt> debtList = debtRepository.findByUserId(userId);
		
		model.addAttribute("name", userId);
		model.addAttribute("assetList", assetList);
		model.addAttribute("debtList", debtList);
		return "index.html";
	}
}
