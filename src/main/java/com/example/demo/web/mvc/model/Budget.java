package com.example.demo.web.mvc.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
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
@Document(indexName = "budget")
public class Budget {
	@Id
	@Field(type=FieldType.Text)
	private String id;
	@Field(type=FieldType.Text)
	private String userId;
	@Field(type = FieldType.Integer)
	private int assetId;
	@Field(type = FieldType.Date)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
	private Date date;
	@Field(type = FieldType.Text)
	private String about;
	@Field(type = FieldType.Integer)
	private int account;
	@Field(type = FieldType.Integer)
	private int categoryId;
}