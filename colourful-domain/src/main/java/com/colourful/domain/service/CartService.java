package com.colourful.domain.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.colourful.domain.entity.BrnCartEntity;
import com.colourful.domain.service.base.EntityFactory;

@Service
public class CartService {

	public void addToCart(long productId, BigDecimal quantity, String cartId) {
		BrnCartEntity cartEntity = EntityFactory.newBrnCartEntity(cartId);

		if (!cartEntity.getEntityByPk()) {
			cartEntity.insert();

		}

		cartEntity.addCartDetail(productId, quantity);

		System.out.println("SID:" + cartId);
		System.out.println("CART_ID:" + cartEntity.getCartId());

	}

}
