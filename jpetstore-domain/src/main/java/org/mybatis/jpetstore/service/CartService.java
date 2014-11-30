package org.mybatis.jpetstore.service;

import java.math.BigDecimal;

import org.mybatis.jpetstore.domain.entity.CartEntity;
import org.mybatis.jpetstore.service.base.EntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService extends EntityFactory {

	@Autowired
	private CatalogService catalogService;

	public void addItem(String userId, String itemId, String productId, BigDecimal quentity) {
		CartEntity cartEntity = EntityFactory.newCartEntity(userId, itemId, productId);
		cartEntity.addItemQuantity(quentity);
	}

	public void clearCart() {
		// cartEntity.clear();
	}
}
