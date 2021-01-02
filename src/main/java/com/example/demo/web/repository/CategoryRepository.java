package com.example.demo.web.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.example.demo.web.mvc.model.Category;

public interface CategoryRepository extends ElasticsearchCrudRepository<Category, String>{
	@Query("{\"match\":{"
			+ "\"userId\": {"
			+ "\"query\": \"?0\"}}}")
	List<Category> findByUserId(String userId);
}
