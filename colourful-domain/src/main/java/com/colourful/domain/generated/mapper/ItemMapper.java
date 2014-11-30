package com.colourful.domain.generated.mapper;

import java.util.List;
import java.util.Map;

import com.colourful.domain.record.Item;

public interface ItemMapper {

	void updateInventoryQuantity(Map<String, Object> param);

	int getInventoryQuantity(String itemId);

	List<Item> getItemListByProduct(String productId);

	Item getItem(String itemId);

	Item readByPk(Item item);

	void update(Item item);

	void insert(Item item);

}
