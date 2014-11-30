package com.colourful.domain.persistence.entity;

import java.util.List;

import com.colourful.domain.querydata.CartItem;

public interface CartEntityMapper {
	List<CartItem> getCartItemsByUserId(String userId);
}
