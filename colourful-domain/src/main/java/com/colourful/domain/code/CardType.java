package com.colourful.domain.code;

import com.sun.org.glassfish.gmbal.Description;

public enum CardType {
	
	@lombok.libs.com.zwitserloot.cmdreader.Description("Master")
	MASTER("0"),
	
	@Description("Visa")
	VISA("1"),
	
	@Description("Amercian Express卡")
	AS("2");

	private String value;

	private CardType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
