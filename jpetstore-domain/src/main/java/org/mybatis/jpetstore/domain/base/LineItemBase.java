package org.mybatis.jpetstore.domain.base;

import org.mybatis.jpetstore.domain.record.LineItem;
import org.mybatis.jpetstore.persistence.LineItemMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class LineItemBase extends LineItem {
	@Autowired
	protected LineItemMapper lineItemMapper;

	public int insert() {
		return lineItemMapper.insertLineItem(this);
	}

	
}
