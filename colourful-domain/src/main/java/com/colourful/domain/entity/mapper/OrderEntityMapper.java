package com.colourful.domain.entity.mapper;

import java.util.List;

import com.colourful.domain.data.ProductDetail;
import com.colourful.domain.generated.record.BrnOrder;

public interface OrderEntityMapper {
	List<ProductDetail> getOrderedProductDetailList(long orderId);

	long insert(BrnOrder brnOrder);
}