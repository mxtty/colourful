package com.colourful.domain.generated.mapper;
import java.util.List;
import com.colourful.domain.generated.record.BrnCartDetail;

public interface BrnCartDetailMapper {
	List<BrnCartDetail> getBrnCartDetailList();
	int insert(BrnCartDetail brncartdetail);
	BrnCartDetail readByPk(BrnCartDetail brncartdetail);
	int update(BrnCartDetail brncartdetail);
	int delete(BrnCartDetail brncartdetail);
}