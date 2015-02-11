package com.colourful.domain.generated.mapper;
import java.util.List;
import com.colourful.domain.generated.record.BrnCartDetail;

public interface BrnCartDetailMapper {
	List<BrnCartDetail> getRecords();
	int insert(BrnCartDetail brncartdetail);
	BrnCartDetail readByPk(BrnCartDetail brncartdetail);
	int update(BrnCartDetail brncartdetail);
	int delete(BrnCartDetail brncartdetail);
}