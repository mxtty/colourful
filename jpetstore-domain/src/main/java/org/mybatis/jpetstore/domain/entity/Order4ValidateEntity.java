package org.mybatis.jpetstore.domain.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

import org.mybatis.jpetstore.domain.base.OrderBase;
import org.mybatis.jpetstore.domain.exception.ExceptionId;
import org.mybatis.jpetstore.domain.record.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Order4ValidateEntity extends OrderBase {
	@Getter
	public List<LineItem> lineItems = new ArrayList<LineItem>();

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
