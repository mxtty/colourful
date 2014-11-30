package com.colourful.domain.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.colourful.domain.base.OrderBase;
import com.colourful.domain.exception.ExceptionId;
import com.colourful.domain.record.Order;

@Component
@Scope("prototype")
public class Order4ValidateEntity extends OrderBase {
	@Getter
	public List<LineItems> lineItems = new ArrayList<LineItems>();

	public List<Order> getOrdersByUsername(String userName) {
		return orderMapper.getOrdersByUsername(userName);
	}

	public int insertOrder() {
		return 0;
	}

	public void initOrder(CartEntity cartEntity) {
	}

	public void throwAppExceptionSample() {
		ExceptionId.appeid.rejectApp("1002");

	}

	public void throwSysExceptionSample() {
		ExceptionId.syseid.rejectSys("1001");
	}
}
