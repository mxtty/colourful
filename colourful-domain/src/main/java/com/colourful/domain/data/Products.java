package com.colourful.domain.data;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Products {

	/** 商品种别名 */
	private String categoryName;

	private long categoryId;

	private List<ProductDetail> productList = new ArrayList<ProductDetail>();

	public void addProduct(ProductDetail productDetail) {
		if (null == productDetail) {
			return;
		}
		productList.add(productDetail);
	}

	public void addProduct(List<ProductDetail> newProductsList) {
		if (null == newProductsList) {
			return;
		}
		productList.addAll(newProductsList);
	}
}