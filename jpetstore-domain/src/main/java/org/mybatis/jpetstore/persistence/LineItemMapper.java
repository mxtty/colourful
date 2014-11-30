package org.mybatis.jpetstore.persistence;

import java.util.List;

import org.mybatis.jpetstore.domain.record.LineItem;

public interface LineItemMapper {

	List<LineItem> getLineItemsByOrderId(int orderId);

	int insertLineItem(LineItem lineItem);
	
	

}
