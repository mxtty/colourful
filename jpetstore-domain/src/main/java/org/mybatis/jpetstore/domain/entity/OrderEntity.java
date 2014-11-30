package org.mybatis.jpetstore.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;

import org.mybatis.jpetstore.code.CardType;
import org.mybatis.jpetstore.domain.base.OrderBase;
import org.mybatis.jpetstore.domain.querydata.CartItem;
import org.mybatis.jpetstore.domain.record.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rainbow.fw.web.context.ContextProvider;

@Component
@Scope("prototype")
public class OrderEntity extends OrderBase {
	@Getter
	public List<LineItem> lineItems = new ArrayList<LineItem>();

	public List<Order> getOrdersByUsername(String userName) {
		return orderMapper.getOrdersByUsername(userName);
	}

	public int insertOrder() {
		SequenceEntity sequenceEntity = ContextProvider.getBean(SequenceEntity.class);
		orderId = sequenceEntity.nextId(Order.class);
		int count = orderMapper.insertOrder(this);
		sequenceEntity.update();
		int lineNum = 1;
		for (LineItem lineItem : lineItems) {
			LineItemEntity lineItemEntity = ContextProvider.getBean(LineItemEntity.class);
			BeanUtils.copyProperties(lineItem, lineItemEntity);
			lineItemEntity.setOrderId(orderId);
			lineItemEntity.setLineNumber(lineNum++);
			lineItemEntity.insert();
		}

		return count;
	}

	public void initOrder(CartEntity cart) {

		AccountEntity account = ContextProvider.getBean(AccountEntity.class);
		orderDate = new Date();
		account.setUsername("j2ee");
		account.getEntityByPk();

		username = account.getUsername();

		shipToFirstName = account.getFirstName();
		shipToLastName = account.getLastName();
		shipAddress1 = account.getAddress1();
		shipAddress2 = account.getAddress2();
		shipCity = account.getCity();
		shipState = account.getState();
		shipZip = account.getZip();
		shipCountry = account.getCountry();

		billToFirstName = account.getFirstName();
		billToLastName = account.getLastName();
		billAddress1 = account.getAddress1();
		billAddress2 = account.getAddress2();
		billCity = account.getCity();
		billState = account.getState();
		billZip = account.getZip();
		billCountry = account.getCountry();

		totalPrice = cart.getSubTotal();

		creditCard = "999 9999 9999 9999";
		expiryDate = "12/03";
		cardType = CardType.VISA;
		courier = "UPS";
		locale = "CA";
		status = "P";

		int i = 0;
//		for (CartItem cartItem : cart.getCarItemsByUserName("wangqi")) {
//			//lineItems.add(new LineItem(i++, cartItem));
//		}
	}

}
