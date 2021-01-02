package com.example.demo.web.mvc.controller.view;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.web.mvc.model.Asset;
import com.example.demo.web.mvc.model.Category;
import com.example.demo.web.mvc.model.Record;
import com.example.demo.web.repository.AssetRepository;
import com.example.demo.web.repository.CategoryRepository;
import com.example.demo.web.repository.RecordRepository;

@Controller
public class AssetViewController {

	@Autowired
	AssetRepository assetRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	RecordRepository recordRepository;
	
	private int getTodayMonth() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		return cal.get(Calendar.MONTH);
	}
	
	private int getTodayYear() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		return cal.get(Calendar.YEAR);
	}
	
	/**
	 * 자산 뷰를 리턴한다.
	 */
	@RequestMapping(value = "/assetView", method = RequestMethod.GET)
	public String assetView(HttpSession session, Model model, @RequestParam(defaultValue = "") String assetId) {
		String userId = (String)session.getAttribute("LOGIN_ID");
		Optional<Asset> asset = assetRepository.findById(assetId);
		List<Category> cateList = categoryRepository.findByUserId(userId);
		
		Date startDate = new GregorianCalendar(getTodayYear(), getTodayMonth(), 1).getTime();
		Date endDate = new GregorianCalendar(getTodayYear(), getTodayMonth() + 1, 1).getTime();
		List<Record> recordList = recordRepository.findByUserIdAndAssetId(userId, assetId, startDate, endDate);
		
		for (Record record : recordList) {
			for (Category cate : cateList) {
				if (cate.getId().equals(record.getCategoryId())) {
					record.setCategoryId(cate.getName());
					break;
				}
			}
		}
		
		model.addAttribute("name", userId);
		model.addAttribute("asset", asset.get());
		model.addAttribute("categoryList", cateList);
		model.addAttribute("recordList", recordList);
		model.addAttribute("year", getTodayYear());
		model.addAttribute("month", getTodayMonth() + 1);
		return "naeyuck.html";
	}
}