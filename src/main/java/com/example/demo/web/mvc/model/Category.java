package com.example.demo.web.mvc.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "category")
public class Category {
	@Id
	@Field(type=FieldType.Text)
	private String id;
	@Field(type=FieldType.Text)
	private String userId;
	@Field(type=FieldType.Text)
	private String name;
}
