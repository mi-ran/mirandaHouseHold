package com.example.demo.web.mvc.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/record/{userId}")
public class RecordController {

	/**
	 *  GET
	 */
	// 자산Id로 검색해서 전체 record를 조회 
	// TODO 날짜 검색, displayCount
	@RequestMapping(value = "/{assetId}", method = RequestMethod.GET)
	public Map<String, Object> getRecordsByAsset(@PathVariable String userId, @PathVariable int assetIdx,
			@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate,
			@RequestParam("displayCount") int displayCount, @RequestParam("startIndex") int startIndex)
	{
		Map<String, Object> result = new HashMap();
		
		return result;
	}
	
	// recordId로 검색해서 하나의 record를 조회
	@RequestMapping(value = "/{recordId}", method = RequestMethod.GET)
	public String getRecord(@PathVariable int recordId) {
		return "record GET " + recordId;
	}
	
	/**
	 * UPDATE
	 */
	@RequestMapping(value = "/{recordId}", method = RequestMethod.PUT)
	public String modifyRecord(@PathVariable int recordId) {
		return "record PUT " + recordId;
	}
	
	/**
	 * DELETE
	 */
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
	
	/**
	 * INSERT
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String insertRecord() {
		return "record POST ";
	}
}
