package com.colourful.io;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;

import org.hibernate.validator.constraints.Range;

import com.colourful.domain.code.CardType;
import com.colourful.domain.querydata.CartItem;

@Data
public class OrderForm {
	private int orderId;
	private List<CartItem> cartList;
	private String username;
	private Date orderDate;
	private String shipAddress1;
	private String shipAddress2;
	private String shipCity;
	private String shipState;
	private String shipZip;
	private String shipCountry;
	private String billAddress1;
	private String billAddress2;
	private String billCity;
	private String billState;
	private String billZip;
	private String billCountry;
	private String courier;
	private BigDecimal totalPrice;
	@Range(min = 10, max = 20)
	private String billToFirstName;
	private String billToLastName;
	private String shipToFirstName;
	private String shipToLastName;
	private String creditCard;
	private String expiryDate;
	private CardType cardType;
	private String locale;
	private String status;
}
