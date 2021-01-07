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
	@Field(type = FieldType.Text)
	private String assetId;
	@Field(type = FieldType.Date)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date date;
	@Field(type = FieldType.Text)
	private String about;
	@Field(type = FieldType.Integer)
	private int import_;
	@Field(type = FieldType.Integer)
	private int spend;
	@Field(type = FieldType.Text)
	private String categoryId;
}