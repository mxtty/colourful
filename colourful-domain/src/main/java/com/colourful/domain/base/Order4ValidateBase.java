package com.colourful.domain.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.colourful.domain.generated.mapper.OrderMapper;
import com.colourful.domain.record.Order4Validate;

public abstract class Order4ValidateBase extends Order4Validate {
	@Autowired
	protected OrderMapper orderMapper;

	public int insert() {
		return 1;
	}

	public void getEntityByPk() {
	}
}
