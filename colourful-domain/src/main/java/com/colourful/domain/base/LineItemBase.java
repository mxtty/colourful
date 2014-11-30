package com.colourful.domain.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.colourful.domain.generated.mapper.LineItemMapper;
import com.colourful.domain.record.LineItem;

public abstract class LineItemBase extends LineItem {
	@Autowired
	protected LineItemMapper lineItemMapper;

	public int insert() {
		return lineItemMapper.insertLineItem(this);
	}

}
