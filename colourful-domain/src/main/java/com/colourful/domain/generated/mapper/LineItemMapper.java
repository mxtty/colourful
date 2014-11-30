package com.colourful.domain.generated.mapper;

import java.util.List;

import com.colourful.domain.record.LineItem;

public interface LineItemMapper {

	List<LineItem> getLineItemsByOrderId(int orderId);

	int insertLineItem(LineItem lineItem);

}
