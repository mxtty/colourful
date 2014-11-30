package org.mybatis.jpetstore.service.base;

import org.mybatis.jpetstore.domain.entity.CartEntity;
import org.mybatis.jpetstore.domain.entity.ItemEntity;

import com.rainbow.fw.web.context.ContextProvider;

public class EntityFactory {
	public static CartEntity newCartEntity(String userId, String itemId, String productId) {
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

}
