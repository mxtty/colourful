package com.colourful.domain.entity;

import com.colourful.domain.generated.base.BrnCartDetailBase;
import com.colourful.domain.service.base.EntityFactory;
import com.colourful.domain.stereotype.Entity;

@Entity
@SuppressWarnings("serial")
public class BrnCartDetailEntity extends BrnCartDetailBase {

	public BrnProductEntity getProductEntity() {
		BrnProductEntity entity = EntityFactory.newBrnProductEntity(productId);
		return entity;
	}
}
