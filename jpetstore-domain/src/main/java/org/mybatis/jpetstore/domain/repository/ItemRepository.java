package org.mybatis.jpetstore.domain.repository;

import org.mybatis.jpetstore.domain.record.Item;
import org.mybatis.jpetstore.persistence.ItemMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

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
