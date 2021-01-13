package com.example.demo.web.mvc.controller.view;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.web.mvc.model.Asset;
import com.example.demo.web.mvc.model.Category;
import com.example.demo.web.mvc.model.Record;

@Controller
public class DebtViewController {
	
	/**
	 * Debt 뷰를 리턴한다.
	 */
	@RequestMapping(value = "/debtView", method = RequestMethod.GET)
	public String assetView(HttpSession session, Model model) {
		return "giveNtake.html";
	}
}