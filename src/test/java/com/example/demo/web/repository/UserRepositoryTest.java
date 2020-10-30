package com.example.demo.web.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.web.mvc.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	@Autowired
	private ElasticsearchTemplate esTemplate;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void addIndex() {
		esTemplate.createIndex(User.class);
		esTemplate.putMapping(User.class);
		esTemplate.refresh(User.class);
	}
	
	@Test
	public void getAll() {
		Iterable<User> result = userRepository.findAll();
		for(User user : result) {
			System.out.println(user);
		}
	}
}
