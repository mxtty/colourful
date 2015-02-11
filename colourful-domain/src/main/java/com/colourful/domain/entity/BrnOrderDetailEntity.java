package com.colourful.domain.entity;

import org.springframework.beans.factory.annotation.Autowired;

import com.colourful.domain.entity.mapper.OrderDetailEntityMapper;
import com.colourful.domain.generated.base.BrnOrderDetailBase;
import com.colourful.domain.stereotype.Entity;

@Entity
@SuppressWarnings("serial")
public class BrnOrderDetailEntity extends BrnOrderDetailBase {

	@Autowired
	private OrderDetailEntityMapper orderDetailEntityMapper;

}
