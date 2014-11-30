package com.colourful.domain.persistence;

import java.util.List;

import com.colourful.domain.querydata.CartItem;
import com.colourful.domain.record.Cart;

public interface CartMapper {

	List<CartItem> getCartItemsByUsername(String username);

	void insert(Cart cart);

	Cart readByPk(Cart cart);

	void update(Cart cart);
}
