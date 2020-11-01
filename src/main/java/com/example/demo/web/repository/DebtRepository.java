package com.example.demo.web.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.example.demo.web.mvc.model.Debt;

public interface DebtRepository extends ElasticsearchCrudRepository<Debt, Integer>{
	
	@Query("{\"match\":{"
			+ "\"userId\": {"
			+ "\"query\": \"?0\"}}}")
	List<Debt> findByUserId(String userId);
}
