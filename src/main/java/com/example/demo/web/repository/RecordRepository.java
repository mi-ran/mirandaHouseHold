package com.example.demo.web.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.example.demo.web.mvc.model.Record;

public interface RecordRepository extends ElasticsearchCrudRepository<Record, Integer>{

	@Query()
	List<Record> findByUserIdAndAssetId();
}
