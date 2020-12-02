package com.example.demo.web.mvc.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "record")
public class Record {
	@Id
	@Field(type=FieldType.Text)
	private String id;
	@Field(type=FieldType.Integer)
	private int assetId;
	@Field(type=FieldType.Text)
	private String userId;
	@Field(type = FieldType.Date)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
	private Date date;
	@Field(type=FieldType.Text)
	private String about; // 내용
	@Field(type=FieldType.Integer)
	private int spend;	  // 지출
	@Field(type=FieldType.Integer)
	private int import_;  // 수입
	@Field(type=FieldType.Integer)
	private int account;  // 잔액
	@Field(type=FieldType.Integer)
	private int categoryId; // 카테고리
}