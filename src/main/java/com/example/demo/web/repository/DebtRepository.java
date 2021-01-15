package com.example.demo.web.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.example.demo.web.mvc.model.Debt;

public interface DebtRepository extends ElasticsearchCrudRepository<Debt, String>{
	
	@Query("{\"match\":{"
			+ "\"userId\": {"
			+ "\"query\": \"?0\"}}}")
	List<Debt> findByUserId(String userId);
	
	@Query("{\"bool\": {"
			+ "\"must\": ["
			+ "{\"match\": {\"userId\":\"?0\"}}"
			+ "],"
			+ "\"filter\": {"
			+ "\"range\": {"
			+ "\"date\": {"
			+ "\"gte\": \"?1\","
			+ "\"lt\": \"?2\"}}"
			+ "}"
			+ "}}")
	List<Debt> findByUserId(String userId, Date startDate, Date endDate);
}
