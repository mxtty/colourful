package com.colourful.domain.record;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

import com.colourful.domain.code.CardType;

@Data
public class Order {
	protected int orderId;
	protected String username;
	protected Date orderDate;
	protected String shipAddress1;
	protected String shipAddress2;
	protected String shipCity;
	protected String shipState;
	protected String shipZip;
	protected String shipCountry;
	protected String billAddress1;
	protected String billAddress2;
	protected String billCity;
	protected String billState;
	protected String billZip;
	protected String billCountry;
	protected String courier;
	protected BigDecimal totalPrice;
	protected String billToFirstName;

	protected String billToLastName;
	protected String shipToFirstName;
	protected String shipToLastName;
	protected String creditCard;
	protected String expiryDate;
	protected CardType cardType;
	protected String locale;
	protected String status;
}
