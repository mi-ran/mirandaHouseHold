package com.example.demo.web.mvc.model;

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
@Document(indexName = "asset")
public class Asset {
	@Id
	@Field(type=FieldType.Text)
	String id;
	@Field(type=FieldType.Text)
	String assetName;
	@Field(type=FieldType.Integer)
	int account;
	@Field(type=FieldType.Text)
	String userId;
}
