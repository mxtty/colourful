package com.colourful.domain.generated.mapper;

import java.util.List;
import com.colourful.domain.generated.record.BrnCartDetail;

public interface BrnCartDetailMapper {

	List<BrnCartDetail> getBrnCartDetailList();

	void insert(BrnCartDetail brncartdetail);

	BrnCartDetail readByPk(BrnCartDetail brncartdetail);

	void update(BrnCartDetail brncartdetail);

}
