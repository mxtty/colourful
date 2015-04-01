package com.colourful.domain.data;

import java.util.Date;

import lombok.Data;

@Data
public class News {
	private String author;
	private String title;
	private String description;
	private String contents;
	private Date newsDate;
}
