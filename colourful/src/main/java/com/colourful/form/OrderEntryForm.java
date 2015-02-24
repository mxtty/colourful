package com.colourful.form;

import java.util.Date;

import lombok.Data;

@Data
public class OrderEntryForm {

	private long orderId;

	private String shipName;

	private String phone;

	private Date shipDate;

	private String shipAddress;

}
