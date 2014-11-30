package com.colourful.domain.repository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.colourful.domain.persistence.CartMapper;
import com.colourful.domain.record.Cart;

@Component
@Scope("prototype")
@SuppressWarnings("serial")
public class CartRepository extends Cart {

	@Autowired
	protected CartMapper cartMapper;

	public boolean insert() {
		cartMapper.insert(this);
		return true;
	}

	public boolean update() {
		cartMapper.update(this);
		return true;
	}

	public boolean readByPk() {
		Cart cart = cartMapper.readByPk(this);
		if (null == cart) {
			return false;
		}
		BeanUtils.copyProperties(cart, this);
		return true;
	}

}
