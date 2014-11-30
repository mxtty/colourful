package com.colourful.domain.record;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

import com.colourful.domain.entity.Product;

@Data
public class Item implements Serializable {

	private static final long serialVersionUID = -2159121673445254631L;

	protected String itemId;
	protected String productId;
	protected BigDecimal listPrice;
	protected BigDecimal unitCost;
	protected int supplierId;
	protected String status;
	protected String attribute1;
	protected String attribute2;
	protected String attribute3;
	protected String attribute4;
	protected String attribute5;
	protected Product product;
	protected int quantity;

	public String toString() {
		return "(" + getItemId() + "-" + getProductId() + ")";
	}

}
