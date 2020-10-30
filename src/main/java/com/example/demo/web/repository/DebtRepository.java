package com.example.demo.web.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.example.demo.web.mvc.model.Debt;

public interface DebtRepository extends ElasticsearchCrudRepository<Debt, Integer>{
	List<Debt> findByUserId(int userId);
}
