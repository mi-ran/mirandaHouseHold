package com.example.demo.web.repository;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.web.mvc.model.Record;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RecordRepositoryTest {
	@Autowired
	private ElasticsearchTemplate esTemplate;
	
	@Autowired
	private RecordRepository recordRepository;
	
	@Test
	public void addIndex() {
		//esTemplate.deleteIndex(Record.class);
		//esTemplate.createIndex(Record.class);
		//esTemplate.putMapping(Record.class);
		//esTemplate.refresh(Record.class);
	}
	
	@Test
	public void getAll() {
		Iterable<Record> result = recordRepository.findAll();
		for(Record record : result) {
			System.out.println(record);
		}
	}
	
	@Test
	public void getRecord() {
		Iterable<Record> result = recordRepository.findByUserIdAndAssetId("", 0, new Date(), new Date());
		for(Record record : result) {
			System.out.println(record);
		}
	}
}
