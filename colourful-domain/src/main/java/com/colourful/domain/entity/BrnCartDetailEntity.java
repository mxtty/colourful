package com.colourful.domain.entity;

import java.math.BigDecimal;

import com.colourful.domain.generated.base.BrnCartDetailBase;
import com.colourful.domain.service.base.EntityFactory;
import com.colourful.domain.stereotype.Entity;
import com.rainbow.fw.core.util.EntityChecker;

@Entity
@SuppressWarnings("serial")
public class BrnCartDetailEntity extends BrnCartDetailBase {

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
