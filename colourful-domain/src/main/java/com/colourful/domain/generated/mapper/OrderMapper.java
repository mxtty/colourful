package com.colourful.domain.generated.mapper;

import java.util.List;

import com.colourful.domain.record.Order;

public interface OrderMapper {

	List<Order> getOrdersByUsername(String username);

	Order getOrder(int orderId);

	int insertOrder(Order order);

	int insertOrderStatus(Order order);

}
