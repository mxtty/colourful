package com.colourful.domain.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.colourful.domain.data.ProductDetail;
import com.colourful.domain.entity.mapper.OrderEntityMapper;
import com.colourful.domain.generated.base.BrnOrderBase;
import com.colourful.domain.service.base.EntityFactory;
import com.colourful.domain.stereotype.Entity;

@Entity
@SuppressWarnings("serial")
public class BrnOrderEntity extends BrnOrderBase {

	@Autowired
	private OrderEntityMapper orderEntityMapper;

	public void newOrder() {
		orderEntityMapper.insert(this);
	}

	public List<ProductDetail> getOrderedProductDetailList() {
		return orderEntityMapper.getOrderedProductDetailList(orderId);
	}

	public BrnCartEntity getBrnCartEntity() {
		BrnCartEntity cartEntity = EntityFactory.newBrnCartEntity(cartId);
		cartEntity.getEntityByPk();

		return cartEntity;

	}

}
