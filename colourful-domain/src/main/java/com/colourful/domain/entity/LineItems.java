package com.colourful.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

import com.colourful.domain.querydata.CartItem;
import com.colourful.domain.record.Item;

@Data
public class LineItems implements Serializable {

	private static final long serialVersionUID = 6804536240033522156L;

	private int orderId;
	private int lineNumber;
	private int quantity;
	private String itemId;
	private BigDecimal unitPrice;
	private Item item;
	private BigDecimal total;

	public LineItems(int lineNumber, CartItem cartItem) {
		this.lineNumber = lineNumber;
		this.quantity = cartItem.getQuantity();
		this.itemId = cartItem.getInStock();
		this.unitPrice = cartItem.getListPrice();

	}

	public void setItem(Item item) {
		this.item = item;
		calculateTotal();
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		calculateTotal();
	}

	private void calculateTotal() {
		if (item != null && item.getListPrice() != null) {
			total = item.getListPrice().multiply(new BigDecimal(quantity));
		} else {
			total = null;
		}
	}

}
