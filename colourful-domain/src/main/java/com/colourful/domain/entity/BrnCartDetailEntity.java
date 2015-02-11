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

	public void removeProduct(BigDecimal subQuantity) {
		EntityChecker.isNotNull(cartId, productId, subQuantity);

		if (!getEntityByPk() || null == quantity) {
			throw new RuntimeException();
		}

		if (quantity.compareTo(subQuantity) > 0) {
			quantity = quantity.subtract(subQuantity);
			update();
		} else {
			delete();
		}
	}

	public void addProduct(BigDecimal addQuantity) {
		EntityChecker.isNotNull(cartId, productId);
		if (!getEntityByPk()) {
			quantity = addQuantity;
			insert();
			return;
		}

		if (null == quantity) {
			quantity = addQuantity;
		} else {
			quantity = quantity.add(addQuantity);
		}
		update();
	}

}
