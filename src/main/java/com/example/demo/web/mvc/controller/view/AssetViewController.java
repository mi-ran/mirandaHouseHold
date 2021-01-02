package com.example.demo.web.mvc.controller.view;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.web.mvc.model.Asset;
import com.example.demo.web.mvc.model.Category;
import com.example.demo.web.repository.AssetRepository;
import com.example.demo.web.repository.CategoryRepository;

@Controller
public class AssetViewController {

	@Autowired
	AssetRepository assetRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	/**
	 * 자산 뷰를 리턴한다.
	 */
	@RequestMapping(value = "/assetView", method = RequestMethod.GET)
	public String assetView(HttpSession session, Model model, @RequestParam(defaultValue = "") String assetId) {
		String userId = (String)session.getAttribute("LOGIN_ID");
		Optional<Asset> asset = assetRepository.findById(assetId);
		List<Category> cateList = categoryRepository.findByUserId(userId);
		
		model.addAttribute("name", userId);
		model.addAttribute("asset", asset.get());
		model.addAttribute("categoryList", cateList);
		return "naeyuck.html";
	}
}