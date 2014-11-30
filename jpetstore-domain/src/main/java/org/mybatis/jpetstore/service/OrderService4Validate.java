package org.mybatis.jpetstore.service;

import org.mybatis.jpetstore.domain.entity.Order4ValidateEntity;
import org.springframework.stereotype.Service;

import com.rainbow.fw.web.context.ContextProvider;

@Service
public class OrderService4Validate {

	private Order4ValidateEntity orderEntity;

	public OrderService4Validate() {
		System.out.println("OrderService Created!");
	}

	public Order4ValidateEntity createEntity() {
		this.orderEntity = ContextProvider.getBean(Order4ValidateEntity.class);
		return orderEntity;
	}

	public void checkOut() {
		System.out.println("check out");
	}

	// @Transactional
	// public void insertOrder(OrderForm order) {
	//
	//
	// order.setOrderId(getNextId("ordernum"));
	// lineItemEntity
	//
	// for (int i = 0; i < order.getLineItems().size(); i++) {
	// LineItem lineItem = (LineItem) order.getLineItems().get(i);
	// String itemId = lineItem.getItemId();
	// Integer increment = new Integer(lineItem.getQuantity());
	// Map<String, Object> param = new HashMap<String, Object>(2);
	// param.put("itemId", itemId);
	// param.put("increment", increment);
	// itemMapper.updateInventoryQuantity(param);
	// }

	//
	// orderMapper.insertOrder(order);
	// orderMapper.insertOrderStatus(order);
	// for (int i = 0; i < order.getLineItems().size(); i++) {
	// LineItem lineItem = (LineItem) order.getLineItems().get(i);
	// lineItem.setOrderId(order.getOrderId());
	// lineItemMapper.insertLineItem(lineItem);
	// }
	// }

	// @Transactional
	// public OrderEntity getOrder(int orderId) {
	// OrderEntity order = orderMapper.getOrder(orderId);
	// order.setLineItems(lineItemMapper.getLineItemsByOrderId(orderId));
	//
	// for (int i = 0; i < order.getLineItems().size(); i++) {
	// LineItem lineItem = (LineItem) order.getLineItems().get(i);
	// Item item = itemMapper.getItem(lineItem.getItemId());
	// item.setQuantity(itemMapper.getInventoryQuantity(lineItem
	// .getItemId()));
	// lineItem.setItem(item);
	// }
	//
	// return order;
	// }

	// public int getNextId(String name) {
	// Sequence sequence = new Sequence(name, -1);
	// sequence = (Sequence) sequenceMapper.getSequence(sequence);
	// if (sequence == null) {
	// throw new RuntimeException(
	// "Error: A null sequence was returned from the database (could not get next "
	// + name + " sequence).");
	// }
	// Sequence parameterObject = new Sequence(name, sequence.getNextId() + 1);
	// sequenceMapper.updateSequence(parameterObject);
	// return sequence.getNextId();
	// }

}
