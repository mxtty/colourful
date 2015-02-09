package com.colourful.domain.entity;

import java.math.BigDecimal;

import com.colourful.domain.exception.ExceptionId;
import com.colourful.domain.generated.base.BrnCartBase;
import com.colourful.domain.service.base.EntityFactory;
import com.colourful.domain.stereotype.Entity;

@Entity
@SuppressWarnings("serial")
public class BrnCartEntity extends BrnCartBase {

	public void addCartDetail(long productId, BigDecimal quantity) {
		BrnCartDetailEntity cartDetailEntity = getCartDetailEntity(productId);

		if (cartDetailEntity.getEntityByPk()) {
			cartDetailEntity.setQuantity(cartDetailEntity.getQuantity().add(quantity));
			cartDetailEntity.update();
			return;
		}

		cartDetailEntity.setQuantity(quantity);
		cartDetailEntity.insert();

	}

	public BrnCartDetailEntity getCartDetailEntity(long productId) {
		if (null == cartId) {
			ExceptionId.E1001.rejectApp("CART ID 未设定");

		}
		BrnCartDetailEntity cartDetailEntity = EntityFactory.newBrnCartDetailEntity(cartId, productId);
		return cartDetailEntity;

	}
}
