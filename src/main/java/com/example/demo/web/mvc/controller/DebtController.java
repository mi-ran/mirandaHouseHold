package com.example.demo.web.mvc.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.web.mvc.model.Debt;
import com.example.demo.web.mvc.model.DebtRecord;
import com.example.demo.web.repository.DebtRecordRepository;
import com.example.demo.web.repository.DebtRepository;

@Controller
@RequestMapping("/debt/{userId}")
public class DebtController {

	@Autowired
	DebtRepository debtRepository;
	
	@Autowired
	DebtRecordRepository debtRecordRepository;
	
	/**
	 *  GET
	 */

	// 모든 부채를 검색
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public Map<String, Object> getDebts(@PathVariable String userId) {
		Map<String, Object> result = new HashMap();
		List<Debt> debts = debtRepository.findByUserId(userId);
		result.put("debts", debts);
		return result;
	}
	
	/**
	 * GET
	 */
	// 기간으로 부채를 검색
	@RequestMapping(value="/", method = RequestMethod.GET)
	public Map<String, Object> getDebtsFiltRange(@PathVariable String userId, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
		Map<String, Object> result = new HashMap();
		List<Debt> debts = debtRepository.findByUserId(userId);
		result.put("debts", debts);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public boolean insertDebt(@PathVariable String userId, @RequestBody Debt debt) {
		debtRepository.save(debt);
		return true;
	}
	
	@ResponseBody
	@RequestMapping(value = "/record", method = RequestMethod.PUT)
	public boolean insertDebtRecord(@PathVariable String userId, @RequestBody DebtRecord debtRecord) {
		Optional<Debt> optionalDebt = debtRepository.findById(debtRecord.getDebtId());
		if (optionalDebt.isPresent()) {
			Debt debt = optionalDebt.get();
			int account = debt.getAccount();
			account = account + debtRecord.getBorrowing();
			account = account - debtRecord.getBorrowed();
			debt.setAccount(account);
			
			debtRepository.save(debt);
			debtRecordRepository.save(debtRecord);
		}
		return true;
	}
	
	/*
	// debtId로 검색해서 하나의 debt를 조회
	// TODO 날짜 검색, displayCount
	@RequestMapping(value = "/{debtId}", method = RequestMethod.GET)
	public String getDebt(@PathVariable int debtId) {
		return "debt GET " + debtId;
	}
	*/
	
	/**
	 * UPDATE
	 */
	/*
	@RequestMapping(value = "/{debtId}", method = RequestMethod.PUT)
	public String modifyRecord(@PathVariable int recordId) {
		return "record PUT " + recordId;
	}
	*/
	
	/**
	 * DELETE
	 */
	// 하나의 debt삭제
	/*
	@RequestMapping(value = "/{debtId}", method = RequestMethod.DELETE)
	public String removeDebt(@PathVariable int debtId) {
		return "debtId DELETE " + debtId;
	}
	*/
	
	/**
	 * INSERT
	 */
	/*
	@RequestMapping(method = RequestMethod.POST)
	public String insertDebt() {
		return "debt POST ";
	}
	*/
}
