package com.colourful.form;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.colourful.domain.data.OptionAddress;
import com.colourful.domain.generated.record.BrnUserDetail;

@Data
public class OrderEntryForm {

	private String cartId;

	private long orderId;

	private List<OptionAddress> optionAddressList;

	private int selectedAddressIdx;

	@Size(min = 1, max = 20)
	@NotEmpty
	private String shipName;

	@Size(min = 1, max = 20)
	@NotEmpty
	private String phone;

	@NotNull
	@DateTimeFormat(pattern = "YYYY/MM/dd")
	private Date shipDate;

	@Size(min = 1, max = 20)
	@NotEmpty
	private String shipAddress;

	public void setAddress(BrnUserDetail brnUserDetail) {

		this.shipName = brnUserDetail.getUserId();
		this.phone = brnUserDetail.getCellPhone();
		this.shipAddress = brnUserDetail.getAddress();

	}

}
