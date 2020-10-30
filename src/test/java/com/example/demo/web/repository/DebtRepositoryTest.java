package com.example.demo.web.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.web.mvc.model.Debt;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DebtRepositoryTest {
	@Autowired
	private ElasticsearchTemplate esTemplate;
	
	@Autowired
	private DebtRepository debtRepository;
	
	@Test
	public void addIndex() {
		esTemplate.deleteIndex(Debt.class);
		esTemplate.createIndex(Debt.class);
		esTemplate.putMapping(Debt.class);
		esTemplate.refresh(Debt.class);
	}

	@Test
	public void getAll() {
		Iterable<Debt> result = debtRepository.findAll();
		for (Debt db : result) {
			System.out.println(db);
		}
	}
	
	@Test
	public void findByUserId() {
		List<Debt> result = debtRepository.findByUserId(0);
		for (Debt db : result) {
			System.out.println(db);
		}
	}
}
