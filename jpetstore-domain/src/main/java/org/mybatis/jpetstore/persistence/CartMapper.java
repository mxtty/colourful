package org.mybatis.jpetstore.persistence;

import java.util.List;

import org.mybatis.jpetstore.domain.querydata.CartItem;
import org.mybatis.jpetstore.domain.record.Cart;

public interface CartMapper {

	List<CartItem> getCartItemsByUsername(String username);

	void insert(Cart cart);

	Cart readByPk(Cart cart);

	void update(Cart cart);
}
