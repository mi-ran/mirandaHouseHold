package com.example.demo.web.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.web.mvc.model.Category;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {
	@Autowired
	private ElasticsearchTemplate esTemplate;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	public void addInex() {
		esTemplate.createIndex(Category.class);
		esTemplate.putMapping(Category.class);
		esTemplate.refresh(Category.class);
	}
	
	@Test
	public void getAll() {
		Iterable<Category> result = categoryRepository.findAll();
		for (Category cate : result) {
			System.out.println(cate);
		}
	}
}
