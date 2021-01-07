package com.example.demo.web.mvc.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.web.mvc.model.Budget;
import com.example.demo.web.mvc.model.Category;
import com.example.demo.web.repository.BudgetRepository;
import com.example.demo.web.repository.CategoryRepository;

@Controller
@RequestMapping("/budget/{userId}")
public class BudgetController {

	@Autowired
	BudgetRepository budgetRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/{assetId}", method = RequestMethod.GET)
	public Map<String, Object> getBudget(@PathVariable String userId, @PathVariable String assetId,
			@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate)
	{
		Map<String, Object> result = new HashMap<>();
		List<Budget> budgetList = budgetRepository.findByUserIdAndAssetId(userId, assetId, startDate, endDate);
		result.put("budgets", budgetList);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public boolean insertBudget(@PathVariable String userId, @RequestBody Budget budget) {
		String categoryName = budget.getCategoryId();
		boolean needToAddCate = true;
		// category id 재설정
		List<Category> cateList = categoryRepository.findByUserId(userId);
		for (Category cate : cateList) {
			if (cate.getName().equals(categoryName)) {
				budget.setCategoryId(cate.getId());
				needToAddCate = false;
				break;
			}
		}
		
		// 없으면 새로운 category를 만든다
		if (needToAddCate) {
			Category newCate = new Category();
			newCate.setName(categoryName);
			newCate.setUserId(userId);
			categoryRepository.save(newCate);
		}
		
		budgetRepository.save(budget);
		return true;
	}
}