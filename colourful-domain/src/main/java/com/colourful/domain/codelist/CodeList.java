package com.colourful.domain.codelist;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CodeList {
	private Map<String, String> cardType;

	public void init() {
		cardType = new HashMap<String, String>();
		cardType.put("visa", "Visa1");
		cardType.put("master", "MasterCard");
		cardType.put("ae", "American Express");

		cardType = Collections.unmodifiableMap(cardType);
	}

	public Map<String, String> cardType() {
		return this.cardType;
	}
}
