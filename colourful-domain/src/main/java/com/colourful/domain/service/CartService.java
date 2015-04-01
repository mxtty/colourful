package com.colourful.domain.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colourful.domain.entity.BrnCartEntity;
import com.colourful.domain.entity.BrnUserEntity;
import com.colourful.domain.service.base.EntityFactory;
import com.rainbow.fw.web.context.WebApplicationContext;

@Service
public class CartService {

	@Autowired
	private WebApplicationContext appContext;

	public void updateCart(long productId, BigDecimal quantity, String cartId) {

		BrnCartEntity cartEntity = EntityFactory.newBrnCartEntity(cartId);
		cartEntity.getBrnCartDetailEntity(productId).updateProduct(quantity);

	}

	public void removeFromCart(long productId, BigDecimal quantity, String cartId) {
		BrnCartEntity cartEntity = EntityFactory.newBrnCartEntity(cartId);

		if (!cartEntity.getEntityByPk()) {
			throw new RuntimeException();

		}

		cartEntity.getBrnCartDetailEntity(productId).removeProduct();
	}

	public String getCartId() {

		if (null != appContext.getCurrentCartId())
			return appContext.getCurrentCartId();

		// 登陆用户
		if (appContext.isAuthenticated()) {
			BrnUserEntity userEntity = EntityFactory.newBrnUserEntity(appContext.getUserDetails().getUserId());
			String cartId = userEntity.getCartId();
			appContext.setCurrentCartId(cartId);
			return cartId;
		}

		String cartId = appContext.getSessionId();
		appContext.setCurrentCartId(cartId);

		BrnCartEntity cartEntity = EntityFactory.newBrnCartEntity();
		cartEntity.setCartId(cartId);
		cartEntity.insert();

		return cartId;
	}

}
