package com.colourful.domain.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colourful.domain.entity.CartEntity;
import com.colourful.domain.service.base.EntityFactory;

@Service
public class CartService extends EntityFactory {

	@Autowired
	private CatalogService catalogService;

	public void addItem(String userId, String itemId, String productId,
			BigDecimal quentity) {
		CartEntity cartEntity = EntityFactory.newCartEntity(userId, itemId,
				productId);
		cartEntity.addItemQuantity(quentity);
	}

	public void clearCart() {
		// cartEntity.clear();
	}
}
