package com.example.demo.web.mvc.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "record", type = "record")
public class Record {
	@Id
	private int id;
	private int assetId;
	private int userId;
	private Date date;
	private String about; // 내용
	private int spend;	  // 지출
	private int import_;  // 수입
	private int account;  // 잔액
}