package com.example.demo.web.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.example.demo.web.mvc.model.User;

public interface UserRepository extends ElasticsearchCrudRepository<User, String>{

}
