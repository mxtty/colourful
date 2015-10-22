package com.colourful.form;

import java.util.Date;

import lombok.Data;

@Data
public class NewsForm {
	private String title;
	private String author;
	private String contents;
	private Date updateDate;
}
