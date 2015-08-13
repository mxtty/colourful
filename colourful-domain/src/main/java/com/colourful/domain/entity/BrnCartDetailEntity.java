package com.colourful.domain.entity;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.colourful.domain.entity.mapper.CartDetailEntityMapper;
import com.colourful.domain.entity.param.ChangeCartIdParam;
import com.colourful.domain.generated.base.BrnCartDetailBase;
import com.colourful.domain.service.base.EntityFactory;
import com.colourful.domain.stereotype.Entity;
import com.rainbow.fw.core.util.EntityChecker;

@Entity
@SuppressWarnings("serial")
public class BrnCartDetailEntity extends BrnCartDetailBase {

	@Autowired
	private CartDetailEntityMapper cartDetailEntityMapper;

	public void changeCartId(String fromCartId, String toCartId) {
		ChangeCartIdParam param = new ChangeCartIdParam();
		param.setFromCartId(fromCartId);
		param.setToCartId(toCartId);
		cartDetailEntityMapper.changeCartId(param);
	}

	public BrnProductEntity getProductEntity() {
		BrnProductEntity entity = EntityFactory.newBrnProductEntity(productId);
		return entity;
	}

	public void removeProduct() {
		EntityChecker.isNotNull(cartId, productId);

		if (!getEntityByPk() || null == quantity) {
			throw new RuntimeException();
		}

		delete();
	}

	public void updateProduct(BigDecimal addQuantity) {
		EntityChecker.isNotNull(cartId, productId);
		if (!getEntityByPk()) {
			quantity = addQuantity;
			insert();
			return;
		}

		quantity = addQuantity;
		update();
	}

}
