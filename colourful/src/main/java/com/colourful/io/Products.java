package com.colourful.io;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Products {

	/** 商品种别名 */
	private String catetoryName;

	private List<ProductDetail> productList = new ArrayList<ProductDetail>();

	public void addProduct(ProductDetail productDetail) {
		if (null == productDetail) {
			return;
		}
		productList.add(productDetail);
	}
}