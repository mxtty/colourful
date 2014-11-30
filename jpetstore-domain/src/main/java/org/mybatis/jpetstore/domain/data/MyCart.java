package org.mybatis.jpetstore.domain.data;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

import org.mybatis.jpetstore.domain.querydata.CartItem;

@Data
public class MyCart {
	private List<CartItem> cartItems;
	private BigDecimal subTotal = BigDecimal.ZERO;

	public int getNumberOfItems() {
		return cartItems.size();
	}

	public BigDecimal getSubTotal() {
		for (CartItem ci : cartItems) {
			subTotal = subTotal.add(ci.getTotalCost());
		}
		return subTotal;
	}
}
