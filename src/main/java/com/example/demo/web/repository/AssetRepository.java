package com.example.demo.web.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.example.demo.web.mvc.model.Asset;

public interface AssetRepository extends ElasticsearchCrudRepository<Asset, String> {
	@Query("{\"match\":{"
			+ "\"userId\": {"
			+ "\"query\": \"?0\"}}}")
	List<Asset> findByUserId(String userId);
	
}
