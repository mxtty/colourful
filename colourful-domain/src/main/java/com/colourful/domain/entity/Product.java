package com.colourful.domain.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Product implements Serializable {

	private static final long serialVersionUID = -7492639752670189553L;

	private String productId;
	private String categoryId;
	private String name;
	private String description;

	public String toString() {
		return getName();
	}

}
