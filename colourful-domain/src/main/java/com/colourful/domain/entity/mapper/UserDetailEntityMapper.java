package com.colourful.domain.entity.mapper;

import java.util.List;

import com.colourful.domain.generated.record.BrnUserDetail;

public interface UserDetailEntityMapper {
	List<BrnUserDetail> getRecords(BrnUserDetail brnUserDetail);

}
