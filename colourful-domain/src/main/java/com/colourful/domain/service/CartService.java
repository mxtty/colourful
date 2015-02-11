package com.colourful.domain.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.colourful.domain.entity.BrnCartEntity;
import com.colourful.domain.service.base.EntityFactory;

@Service
public class CartService {

	public void addToCart(long productId, BigDecimal quantity, String cartId) {

		BrnCartEntity cartEntity = EntityFactory.newBrnCartEntity(cartId);
		cartEntity.getBrnCartDetailEntity(productId).addProduct(quantity);

	}

	public void removeFromCart(long productId, BigDecimal quantity, String cartId) {
		BrnCartEntity cartEntity = EntityFactory.newBrnCartEntity(cartId);

		if (!cartEntity.getEntityByPk()) {
			throw new RuntimeException();

		}

		cartEntity.getBrnCartDetailEntity(productId).removeProduct(quantity);
	}

}
