package com.example.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/record/")
public class RecordController {

	@RequestMapping(value = "/{assetIdx}", method = RequestMethod.GET)
	public String getRecordsByAsset(@PathVariable int assetIdx) {
		return "asset GET " + assetIdx;
	}
	
	@RequestMapping(value = "/{assetId}", method = RequestMethod.GET)
	public String getAsset(@PathVariable int assetId) {
		return "asset GET " + assetId;
	}
	
	//update
	@RequestMapping(value = "/{assetId}", method = RequestMethod.PUT)
	public String modifyAsset(@PathVariable int assetId) {
		return "asset PUT " + assetId;
	}
	
	//delete
	@RequestMapping(value = "/{assetId}", method = RequestMethod.DELETE)
	public String removeAsset(@PathVariable int assetId) {
		return "asset DELETE " + assetId;
	}
	
	//insert
	@RequestMapping(value = "/{assetId}", method = RequestMethod.POST)
	public String insertAsset(@PathVariable int assetId) {
		return "asset POST " + assetId;
	}
}
