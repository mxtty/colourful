package com.colourful.domain.entity.mapper;

import java.util.List;

import com.colourful.domain.entity.param.ChangeCartIdParam;
import com.colourful.domain.generated.record.BrnCartDetail;

public interface CartDetailEntityMapper {

	void changeCartId(ChangeCartIdParam changeCartIdParam);

	List<BrnCartDetail> getRecords(BrnCartDetail brnDetailCart);
}
