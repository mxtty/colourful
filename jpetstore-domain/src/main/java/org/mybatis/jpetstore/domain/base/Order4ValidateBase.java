package org.mybatis.jpetstore.domain.base;

import org.mybatis.jpetstore.domain.record.Order4Validate;
import org.mybatis.jpetstore.persistence.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Order4ValidateBase extends Order4Validate {
	@Autowired
	protected OrderMapper orderMapper;

	public int insert() {
		return 1;
	}

	public void getEntityByPk() {
	}
}
