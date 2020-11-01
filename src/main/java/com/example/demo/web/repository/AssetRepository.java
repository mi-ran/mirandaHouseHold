package com.example.demo.web.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.example.demo.web.mvc.model.Asset;

public interface AssetRepository extends ElasticsearchCrudRepository<Asset, Integer> {
	@Query("{\"match\":{"
			+ "\"userId\": {"
			+ "\"query\": \"?0\"}}}")
	List<Asset> findByUserId(String userId);
	
	@Query("{\"bool\": {"
			+ "\"must\": ["
			+ "{\"match\": {\"userId\":\"?0\"}},"
			+ "{\"match\": {\"id\":\"?1\"}}"
			+ "]}"
			+ "}")
	Asset findByUserIdAndAssetId(String userId, int assetId);
}
