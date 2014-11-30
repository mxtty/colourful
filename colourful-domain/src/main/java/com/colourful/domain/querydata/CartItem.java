package com.colourful.domain.querydata;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7556159798410231121L;

	protected String itemId;
	protected String productId;

	protected String description;
	protected String inStock;
	protected int quantity;
	protected BigDecimal listPrice;
	protected BigDecimal totalCost;

	public BigDecimal getTotalCost() {
		return listPrice.multiply(BigDecimal.valueOf(quantity));
	}
}
