package com.colourful.form;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.CollectionUtils;

import com.colourful.domain.generated.record.BrnUserDetail;

@Data
public class OrderEntryForm {

	private String cartId;

	private long orderId;

	private List<BrnUserDetail> optionAddressList;

	// private int selectedAddressIdx;

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

	public void setSelectedAddress(int selectedAddressIdx) {
		if (CollectionUtils.isEmpty(this.optionAddressList) || selectedAddressIdx < 0
				|| this.optionAddressList.size() < selectedAddressIdx)
			return;

		BrnUserDetail brnUserDetail = this.optionAddressList.get(selectedAddressIdx);
		this.shipName = brnUserDetail.getUserName();
		this.phone = brnUserDetail.getCellPhone();
		this.shipAddress = brnUserDetail.getAddress();

	}

	public boolean hasMultiAddress() {
		return !CollectionUtils.isEmpty(this.optionAddressList) && this.optionAddressList.size() > 1;
	}

}
