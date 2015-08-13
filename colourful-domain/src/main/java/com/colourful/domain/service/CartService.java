package com.colourful.domain.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colourful.domain.entity.BrnCartDetailEntity;
import com.colourful.domain.entity.BrnCartEntity;
import com.colourful.domain.entity.BrnUserEntity;
import com.colourful.domain.service.base.EntityFactory;
import com.rainbow.fw.core.env.CartIdService;
import com.rainbow.fw.web.context.WebApplicationContext;

@Service
public class CartService {

	@Autowired
	private CartIdService cartIdService;

	@Autowired
	private WebApplicationContext appContext;

	/**
	 * 用户在非登录状态下购物，使用临时购物车，使用登录用户结帐时， 将临时购物车切换到用户购物车。
	 * 
	 * @param loginUserCartId
	 *            登录用户的CartId
	 */
	public void changeCartIdByUser(String loginUserCartId) {

		BrnCartDetailEntity cartDetailEntity = EntityFactory.newBrnCartDetailEntity();

		cartDetailEntity.changeCartId(cartIdService.getCartId(), loginUserCartId);

		cartIdService.updateCartId(loginUserCartId);

	}

	public void updateCart(long detailId, BigDecimal quantity, String cartId) {

		BrnCartEntity cartEntity = EntityFactory.newBrnCartEntity(cartId);
		cartEntity.getBrnCartDetailEntity(detailId).updateProduct(quantity);

	}

	public void removeFromCart(long productId, BigDecimal quantity, String cartId) {
		BrnCartEntity cartEntity = EntityFactory.newBrnCartEntity(cartId);

		if (!cartEntity.getEntityByPk()) {
			throw new RuntimeException();

		}

		cartEntity.getBrnCartDetailEntity(productId).removeProduct();
	}

	public String getCartId() {

		if (null != cartIdService.getCartId())
			return cartIdService.getCartId();

		// 登陆用户
		if (appContext.isAuthenticated()) {
			BrnUserEntity userEntity = EntityFactory.newBrnUserEntity(appContext.getUserDetails().getUserId());
			String cId = userEntity.getCartId();
			cartIdService.setCartId(cId);
			return cId;
		}

		BrnCartEntity cartEntity = EntityFactory.newBrnCartEntity();
		cartEntity.setCartId(cartIdService.newCartId());
		cartEntity.insert();

		return cartIdService.getCartId();
	}

}
