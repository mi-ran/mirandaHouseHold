package com.example.demo.web.repository;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BudgetRepositoryTest {
	@Autowired
	private BudgetRepository budgetRepository;
	
	@Test
	public void findByUserIdAndAssetId() {
		budgetRepository.findByUserIdAndAssetId("", 0, new Date(), new Date());
	}
}
