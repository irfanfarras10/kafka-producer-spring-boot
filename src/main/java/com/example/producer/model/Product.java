package com.example.producer.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Product{
	private Id _id;
	private String createdDate;
	private String updateDate;
	private boolean active;
	private int stockAvailable;
}
