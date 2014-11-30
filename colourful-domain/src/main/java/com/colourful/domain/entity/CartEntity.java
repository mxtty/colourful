package com.colourful.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.colourful.domain.persistence.entity.CartEntityMapper;
import com.colourful.domain.querydata.CartItem;
import com.colourful.domain.repository.CartRepository;
import com.colourful.domain.service.base.EntityFactory;

@Component
@Scope("prototype")
public class CartEntity extends CartRepository implements Serializable {

	private static final long serialVersionUID = 8329559983943337176L;

	@Autowired
	private CartEntityMapper entityMapper;

	public ItemEntity getItemEntity() {
		ItemEntity itemEntity = EntityFactory.newItemEntity(this.itemId,
				this.productId);
		itemEntity.readByPk();
		return itemEntity;
	}

	public void addItemQuantity(BigDecimal quantity) {
		if (readByPk()) {
			this.quantity = this.quantity.add(quantity);
			update();
		} else {
			this.quantity = BigDecimal.ONE;
			insert();
		}
	}

	public List<CartItem> getCarItemsByUserId(String userId) {
		return entityMapper.getCartItemsByUserId(userId);
	}

	public BigDecimal getSubTotal() {
		return BigDecimal.TEN;
	}
}
