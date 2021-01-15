package com.example.demo.web.mvc.model;

import java.util.Date;

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
@Document(indexName = "debtrecord")
public class DebtRecord {
	@Id
	@Field(type=FieldType.Text)
	private String id;
	@Field(type=FieldType.Text)
	private String debtId;
	@Field(type = FieldType.Date)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date date;
	@Field(type=FieldType.Integer)
	private int borrowed;  // 빌린돈
	@Field(type=FieldType.Integer)
	private int borrowing; // 빌려준 돈
}
