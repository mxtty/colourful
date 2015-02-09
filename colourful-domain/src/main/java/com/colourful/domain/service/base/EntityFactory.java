package com.colourful.domain.service.base;

import java.util.concurrent.atomic.AtomicInteger;

import com.colourful.domain.entity.BrnCartDetailEntity;
import com.colourful.domain.entity.BrnCartEntity;
import com.colourful.domain.entity.BrnCategoryEntity;
import com.colourful.domain.entity.BrnImageEntity;
import com.colourful.domain.entity.BrnProductEntity;
import com.colourful.domain.entity.BrnUserDetailEntity;
import com.colourful.domain.entity.BrnUserEntity;
import com.rainbow.fw.web.context.ContextProvider;

public class EntityFactory {

	public static BrnUserEntity newBrnUserEntity(String userId) {
		BrnUserEntity entity = ContextProvider.getBean(BrnUserEntity.class);
		entity.setUserId(userId);
		return entity;
	}

	public static BrnUserDetailEntity newBrnUserDetailEntity(String userId) {
		BrnUserDetailEntity entity = ContextProvider.getBean(BrnUserDetailEntity.class);
		AtomicInteger ai = new AtomicInteger();
		entity.setAddressId(ai.getAndIncrement());
		entity.setUserId(userId);
		return entity;
	}

	public static BrnCategoryEntity newBrnCategoryEntity(long categoryId) {
		BrnCategoryEntity entity = ContextProvider.getBean(BrnCategoryEntity.class);
		// System.out.println("CG:"+categoryId);
		entity.setCategoryId(categoryId);
		return entity;
	}

	public static BrnProductEntity newBrnProductEntity(long productId) {
		BrnProductEntity entity = ContextProvider.getBean(BrnProductEntity.class);
		entity.setProductId(productId);
		return entity;
	}

	public static BrnImageEntity newBrnImageEntity(long imageId) {
		BrnImageEntity entity = ContextProvider.getBean(BrnImageEntity.class);
		entity.setImageId(imageId);
		return entity;
	}

	public static BrnImageEntity newBrnImageEntity() {

		return ContextProvider.getBean(BrnImageEntity.class);

	}

	public static BrnCartEntity newBrnCartEntity() {

		return ContextProvider.getBean(BrnCartEntity.class);

	}

	public static BrnCartEntity newBrnCartEntity(String cartId) {

		BrnCartEntity entity = ContextProvider.getBean(BrnCartEntity.class);
		entity.setCartId(cartId);
		return entity;

	}

	public static BrnCartDetailEntity newBrnCartDetailEntity(String cartId, long productId) {

		BrnCartDetailEntity entity = ContextProvider.getBean(BrnCartDetailEntity.class);

		entity.setCartId(cartId);
		entity.setProductId(productId);

		return entity;
	}

}
