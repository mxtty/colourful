package com.rainbow.fw.core.env;

import java.util.UUID;

import lombok.Data;

@Data
public class CartIdService {
	private String cartId;

	public String newCartId() {
		this.cartId = UUID.randomUUID().toString();
		return cartId;
	}

	public void updateCartId(String newCartId) {
		this.cartId = newCartId;
	}

}
