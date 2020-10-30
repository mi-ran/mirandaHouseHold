package com.example.demo.web.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.example.demo.web.mvc.model.Category;

public interface CategoryRepository extends ElasticsearchCrudRepository<Category, Integer>{

}
