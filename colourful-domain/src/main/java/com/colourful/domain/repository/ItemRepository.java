package com.colourful.domain.repository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.colourful.domain.generated.mapper.ItemMapper;
import com.colourful.domain.record.Item;

@SuppressWarnings("serial")
public class ItemRepository extends Item {

	@Autowired
	protected ItemMapper itemMapper;

	public boolean insert() {
		itemMapper.insert(this);
		return true;
	}

	public boolean update() {
		itemMapper.update(this);
		return true;
	}

	public boolean readByPk() {
		Item item = itemMapper.readByPk(this);
		if (null == item) {
			return false;
		}
		BeanUtils.copyProperties(item, this);
		return true;
	}

}
