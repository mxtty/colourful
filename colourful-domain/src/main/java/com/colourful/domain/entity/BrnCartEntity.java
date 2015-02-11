package com.colourful.domain.entity;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.colourful.domain.data.ProductDetail;
import com.colourful.domain.entity.mapper.CartEntityMapper;
import com.colourful.domain.generated.base.BrnCartBase;
import com.colourful.domain.stereotype.Entity;
import com.rainbow.fw.core.util.EntityChecker;

@Entity
@SuppressWarnings("serial")
public class BrnCartEntity extends BrnCartBase {

	@Autowired
	private CartEntityMapper cartEntityMapper;

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

	public List<ProductDetail> getSelectedProductDetailList() {
		EntityChecker.isNotNull(cartId);
		return cartEntityMapper.getSelectedProductDetailList(cartId);
	}
}
