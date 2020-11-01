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

import com.example.demo.web.mvc.model.Record;
import com.example.demo.web.repository.RecordRepository;

@Controller
@RequestMapping("/record/{userId}")
public class RecordController {

	@Autowired
	RecordRepository recordRepository;
	
	/**
	 *  GET
	 */
	// 자산Id로 검색해서 전체 record를 조회 
	// TODO 날짜 검색, displayCount
	@RequestMapping(value = "/{assetId}", method = RequestMethod.GET)
	public Map<String, Object> getRecordsByAsset(@PathVariable String userId, @PathVariable int assetId,
			@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate)
	{
		Map<String, Object> result = new HashMap<>();
		List<Record> records = recordRepository.findByUserIdAndAssetId(userId, assetId, startDate, endDate);
		result.put("records", records);
		
		return result;
	}
	
	@RequestMapping(value = "/{assetId}/{categoryId}", method = RequestMethod.GET)
	public Map<String, Object> getRecordsByAssetAndCategory(@PathVariable String userId, @PathVariable int assetId, @PathVariable int categoryId,
			@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate)
	{
		Map<String, Object> result = new HashMap<>();
		List<Record> records = recordRepository.findByUserIdAndAssetIdAndCategory(userId, assetId, categoryId, startDate, endDate);
		result.put("records", records);
		return result;
	}
	
	/*
	// recordId로 검색해서 하나의 record를 조회
	@RequestMapping(value = "/{recordId}", method = RequestMethod.GET)
	public String getRecord(@PathVariable int recordId) {
		return "record GET " + recordId;
	}
	
	@RequestMapping(value = "/{recordId}", method = RequestMethod.PUT)
	public String modifyRecord(@PathVariable int recordId) {
		return "record PUT " + recordId;
	}
	
	// 하나의 레코드 삭제
	@RequestMapping(value = "/{recordId}", method = RequestMethod.DELETE)
	public String removeRecord(@PathVariable int recordId) {
		return "record DELETE " + recordId;
	}
	
	// 한 자산에 해당하는 모든 레코드 삭제
	@RequestMapping(value = "/{assetId}", method = RequestMethod.DELETE)
	public String removeRecords(@PathVariable int assetId) {
		return "record DELETE " + assetId;
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String insertRecord() {
		return "record POST ";
	}
	**/
}
