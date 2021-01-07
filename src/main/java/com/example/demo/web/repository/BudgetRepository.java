package com.example.demo.web.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.example.demo.web.mvc.model.Budget;

public interface BudgetRepository extends ElasticsearchCrudRepository<Budget, String>{

	@Query("{\"bool\": {"
			+ "\"must\": ["
			+ "{\"match\": {\"userId\":\"?0\"}},"
			+ "{\"match\": {\"assetId\":\"?1\"}}"
			+ "],"
			+ "\"filter\": {"
			+ "\"range\": {"
			+ "\"date\": {"
			+ "\"gte\": \"?2\","
			+ "\"lt\": \"?3\"}}"
			+ "}"
			+ "}}")
	List<Budget> findByUserIdAndAssetId(String userId, String assetId, Date startDate, Date endDate);
}
