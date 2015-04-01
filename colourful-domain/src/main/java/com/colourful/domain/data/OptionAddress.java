package com.colourful.domain.data;

import lombok.Data;

@Data
public class OptionAddress {

	private String addressInfo;
	private int addressIdx;

	public OptionAddress(int idx, String addressInfo) {

		this.addressIdx = idx;
		this.addressInfo = addressInfo;

	}

}
