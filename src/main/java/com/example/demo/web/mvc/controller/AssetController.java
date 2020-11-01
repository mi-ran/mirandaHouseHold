package com.example.demo.web.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.web.mvc.model.Asset;
import com.example.demo.web.repository.AssetRepository;

@Controller
@RequestMapping("/asset/{userId}")
public class AssetController {

	@Autowired
	AssetRepository assetRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Map<String, Object> getAll(@PathVariable String userId) {
		Map<String, Object> result = new HashMap();
		List<Asset> assets = assetRepository.findByUserId(userId);
		result.put("assets", assets);
		return result;
	}
	
	// TODO dateParam, displayCount
	@RequestMapping(value = "/{assetId}", method = RequestMethod.GET)
	public Map<String, Object> getAsset(@PathVariable String userId, @PathVariable int assetId) {
		Map<String, Object> result = new HashMap();
		Asset asset = assetRepository.findByUserIdAndAssetId(userId, assetId);
		result.put("asset", asset);
		return result;
	}
}
