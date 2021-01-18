package com.example.demo.web.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.example.demo.web.mvc.model.DebtRecord;

public interface DebtRecordRepository extends ElasticsearchCrudRepository<DebtRecord, String> {

	@Query("{\"bool\": {"
			+ "\"must\": ["
			+ "{\"match\": {\"debtId\":\"?0\"}}"
			+ "]"
			+ "}}")
	List<DebtRecord> findByDebtId(String debtId);
}
