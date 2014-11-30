package org.mybatis.jpetstore.persistence.entity;

import java.util.List;

import org.mybatis.jpetstore.domain.querydata.CartItem;

public interface CartEntityMapper {
	List<CartItem> getCartItemsByUserId(String userId);
}
