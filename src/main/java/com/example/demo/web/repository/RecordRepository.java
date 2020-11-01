package com.example.demo.web.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.example.demo.web.mvc.model.Record;

public interface RecordRepository extends ElasticsearchCrudRepository<Record, Integer>{

	
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
	List<Record> findByUserIdAndAssetId(String userId, int assetId, Date startDate, Date endDate);
	
	@Query("{\"bool\": {"
			+ "\"must\": ["
			+ "{\"match\": {\"userId\":\"?0\"}},"
			+ "{\"match\": {\"assetId\":\"?1\"}},"
			+ "{\"match\": {\"categoryId\":\"?2\"}}"
			+ "],"
			+ "\"filter\": {"
			+ "\"range\": {"
			+ "\"date\": {"
			+ "\"gte\": \"?3\","
			+ "\"lt\": \"?4\"}}"
			+ "}"
			+ "}}")
	List<Record> findByUserIdAndAssetIdAndCategory(String userId, int assetId, int categoryIdx, Date startDate, Date endDate);
}
