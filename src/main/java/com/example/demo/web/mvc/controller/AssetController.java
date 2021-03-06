package com.example.demo.web.mvc.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value = "/{assetId}", method = RequestMethod.GET)
	public Map<String, Object> getAsset(@PathVariable String userId, @PathVariable String assetId) {
		Map<String, Object> result = new HashMap();
		Optional<Asset> asset = assetRepository.findById(assetId);
		result.put("asset", asset.get());
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public boolean insertAsset(@PathVariable String userId, @RequestBody Asset asset) {
		System.out.println("성공");
		assetRepository.save(asset);
		return true;
	}
}
