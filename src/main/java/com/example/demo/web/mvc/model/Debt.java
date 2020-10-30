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
@Document(indexName = "debt", type = "debt")
public class Debt {
	@Id
	private int id;
	private int userId;
	private String name;
	
	@Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy.MM.dd hh:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd hh:mm:ss", timezone = "Asia/Seoul")
	private Date date;
	
	private int borrowed;  // 빌린돈
	private int borrowing; // 빌려준 돈
}
