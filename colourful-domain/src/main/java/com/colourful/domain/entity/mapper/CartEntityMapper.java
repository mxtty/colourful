package com.colourful.domain.entity.mapper;

import java.util.List;

import com.colourful.domain.querydata.CartItem;

public interface CartEntityMapper {
	List<CartItem> getCartItemsByUserId(String userId);
}
