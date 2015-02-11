package com.colourful.domain.generated.mapper;
import java.util.List;
import com.colourful.domain.generated.record.BrnOrder;

public interface BrnOrderMapper {
	List<BrnOrder> getBrnOrderList();
	int insert(BrnOrder brnorder);
	BrnOrder readByPk(BrnOrder brnorder);
	int update(BrnOrder brnorder);
	int delete(BrnOrder brnorder);
}