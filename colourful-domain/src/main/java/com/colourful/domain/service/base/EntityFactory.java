package com.colourful.domain.service.base;

import java.util.concurrent.atomic.AtomicInteger;

import com.colourful.domain.entity.BrnCategoryEntity;
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
		BrnUserDetailEntity entity = ContextProvider
				.getBean(BrnUserDetailEntity.class);
		AtomicInteger ai = new AtomicInteger();
		entity.setAddressId(ai.getAndIncrement());
		entity.setUserId(userId);
		return entity;
	}

	public static BrnCategoryEntity newBrnCategoryEntity() {
		BrnCategoryEntity entity = ContextProvider
				.getBean(BrnCategoryEntity.class);
		return entity;
	}

}
