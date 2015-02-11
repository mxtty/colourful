package com.colourful.domain.generated.mapper;
import java.util.List;
import com.colourful.domain.generated.record.BrnOrderDetail;

public interface BrnOrderDetailMapper {
	List<BrnOrderDetail> getBrnOrderDetailList();
	int insert(BrnOrderDetail brnorderdetail);
	BrnOrderDetail readByPk(BrnOrderDetail brnorderdetail);
	int update(BrnOrderDetail brnorderdetail);
	int delete(BrnOrderDetail brnorderdetail);
}