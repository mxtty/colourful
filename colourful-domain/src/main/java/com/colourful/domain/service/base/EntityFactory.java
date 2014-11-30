package com.colourful.domain.service.base;

import java.util.concurrent.atomic.AtomicInteger;

import com.colourful.domain.entity.BrnUserDetailEntity;
import com.colourful.domain.entity.BrnUserEntity;
import com.colourful.domain.entity.CartEntity;
import com.colourful.domain.entity.ItemEntity;
import com.rainbow.fw.web.context.ContextProvider;

public class EntityFactory {

	public static CartEntity newCartEntity(String userId, String itemId,
			String productId) {
		CartEntity entity = ContextProvider.getBean(CartEntity.class);
		entity.setUserId(userId);
		entity.setItemId(itemId);
		entity.setProductId(productId);
		return entity;
	}

	public static ItemEntity newItemEntity(String itemId, String productId) {
		ItemEntity entity = ContextProvider.getBean(ItemEntity.class);

		entity.setItemId(itemId);
		entity.setProductId(productId);
		return entity;
	}

	public static BrnUserEntity newBrnUserEntity(String userId) {
		BrnUserEntity entity = ContextProvider.getBean(BrnUserEntity.class);
		entity.setUserId(userId);
		return entity;
	}

	public static BrnUserDetailEntity newBrnUserDetailEntity(String userId) {
		BrnUserDetailEntity entity = ContextProvider
				.getBean(BrnUserDetailEntity.class);
		AtomicInteger ai = new AtomicInteger();
		entity.setAddressId(ai.getAndIncrement());
		entity.setUserId(userId);
		return entity;
	}

}
