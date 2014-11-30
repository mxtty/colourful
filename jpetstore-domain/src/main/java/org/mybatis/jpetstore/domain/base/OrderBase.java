package org.mybatis.jpetstore.domain.base;

import org.mybatis.jpetstore.domain.record.Order;
import org.mybatis.jpetstore.persistence.OrderMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class OrderBase extends Order {
	@Autowired
	protected OrderMapper orderMapper;

	public int insert() {
		return orderMapper.insertOrder(this);
	}

	public void getEntityByPk() {
		Order order = orderMapper.getOrder(orderId);
		BeanUtils.copyProperties(order, this);
	}
}
