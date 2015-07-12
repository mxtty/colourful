package com.colourful.form;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

import com.colourful.domain.data.Products;

@Data
public class MenuForm {

	private List<Products> productsList;
	@NotNull(message = "选择不能为空")
	private List<Long> selectedProductIdList;

	public void addProducts(Products products) {
		if (null != products)
			this.productsList.add(products);
	}
}
