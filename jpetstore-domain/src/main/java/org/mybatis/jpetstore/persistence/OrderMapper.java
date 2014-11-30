package org.mybatis.jpetstore.persistence;

import java.util.List;

import org.mybatis.jpetstore.domain.record.Order;

public interface OrderMapper {

	List<Order> getOrdersByUsername(String username);

	Order getOrder(int orderId);

	int insertOrder(Order order);

	int insertOrderStatus(Order order);

}
