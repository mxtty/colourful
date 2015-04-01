package com.colourful.domain.entity;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.colourful.domain.data.ProductDetail;
import com.colourful.domain.entity.mapper.CartEntityMapper;
import com.colourful.domain.generated.base.BrnCartBase;
import com.colourful.domain.generated.record.BrnCart;
import com.colourful.domain.service.base.EntityFactory;
import com.colourful.domain.stereotype.Entity;
import com.rainbow.fw.core.util.EntityChecker;

@Entity
@SuppressWarnings("serial")
public class BrnCartEntity extends BrnCartBase {

	@Autowired
	private CartEntityMapper cartEntityMapper;

	public BrnCartDetailEntity getBrnCartDetailEntity(long productId) {
		EntityChecker.isNotNull(cartId);
		EntityChecker.isNotZero(productId);
		return EntityFactory.newBrnCartDetailEntity(cartId, productId);

	}

	public List<ProductDetail> getSelectedProductDetailList() {
		EntityChecker.isNotNull(cartId);
		return cartEntityMapper.getCartProductDetailList(cartId);
	}

	public BrnCartEntity getBrnCartEntityByUserId(String userId) {
		List<BrnCart> brnCartList = cartEntityMapper.getRecords(this);
		if (CollectionUtils.isEmpty(brnCartList))
			return null;

		BeanUtils.copyProperties(brnCartList.get(0), this);
		return this;
	}

}
