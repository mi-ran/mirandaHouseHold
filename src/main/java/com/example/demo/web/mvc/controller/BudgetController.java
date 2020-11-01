package com.example.demo.web.mvc.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.web.mvc.model.Budget;
import com.example.demo.web.repository.BudgetRepository;

@Controller
@RequestMapping("/budget/{userId}")
public class BudgetController {

	@Autowired
	BudgetRepository budgetRepository;
	
	@RequestMapping(value = "/{assetId}", method = RequestMethod.GET)
	public Map<String, Object> getBudget(@PathVariable String userId, @PathVariable int assetId,
			@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate)
	{
		Map<String, Object> result = new HashMap<>();
		List<Budget> budgetList = budgetRepository.findByUserIdAndAssetId(userId, assetId, startDate, endDate);
		result.put("budgets", budgetList);
		return result;
	}
}
