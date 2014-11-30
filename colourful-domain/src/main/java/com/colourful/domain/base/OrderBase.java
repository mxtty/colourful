package com.colourful.domain.base;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.colourful.domain.generated.mapper.OrderMapper;
import com.colourful.domain.record.Order;

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
