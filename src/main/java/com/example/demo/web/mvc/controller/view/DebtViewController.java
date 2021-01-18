package com.example.demo.web.mvc.controller.view;

import java.util.Date;
import java.util.GregorianCalendar;
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
import com.example.demo.web.mvc.model.Debt;
import com.example.demo.web.mvc.model.DebtRecord;
import com.example.demo.web.mvc.model.Record;
import com.example.demo.web.repository.DebtRecordRepository;
import com.example.demo.web.repository.DebtRepository;

@Controller
public class DebtViewController {
	
	@Autowired
	DebtRepository debtRepository;
	
	@Autowired
	DebtRecordRepository debtRecordRepository;
	
	/**
	 * Debt 뷰를 리턴한다.
	 */
	@RequestMapping(value = "/debtView", method = RequestMethod.GET)
	public String debtView(HttpSession session, Model model, @RequestParam String debtId) {
		String userId = (String)session.getAttribute("LOGIN_ID");
		Optional<Debt> debt = debtRepository.findById(debtId);
		List<DebtRecord> debtRecord = debtRecordRepository.findByDebtId(debtId);
		
		model.addAttribute("name", userId);
		model.addAttribute("debt", debt.orElse(null));
		model.addAttribute("debtRecord", debtRecord);
		return "giveNtake.html";
	}
}