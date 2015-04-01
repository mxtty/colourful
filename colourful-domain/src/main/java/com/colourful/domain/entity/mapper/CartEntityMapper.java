package com.colourful.domain.entity.mapper;

import java.util.List;

import com.colourful.domain.data.ProductDetail;
import com.colourful.domain.generated.record.BrnCart;

public interface CartEntityMapper {
	List<ProductDetail> getCartProductDetailList(String cartId);

	List<BrnCart> getRecords(BrnCart brnCart);
}
