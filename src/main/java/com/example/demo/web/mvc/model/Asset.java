package com.example.demo.web.mvc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "asset", type = "asset")
public class Asset {
	@Id
	int id;
	String assetName;
	int account;
	int userId;
}
