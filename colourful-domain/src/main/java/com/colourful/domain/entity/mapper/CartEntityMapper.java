package com.colourful.domain.entity.mapper;

import java.util.List;

import com.colourful.domain.data.ProductDetail;

public interface CartEntityMapper {
	List<ProductDetail> getSelectedProductDetailList(String cartId);

}
