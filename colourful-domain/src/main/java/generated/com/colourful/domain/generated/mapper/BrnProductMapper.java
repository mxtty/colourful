package com.colourful.domain.generated.mapper;
import java.util.List;
import com.colourful.domain.generated.record.BrnProduct;

public interface BrnProductMapper {
	List<BrnProduct> getBrnProductList();
	int insert(BrnProduct brnproduct);
	BrnProduct readByPk(BrnProduct brnproduct);
	int update(BrnProduct brnproduct);
	int delete(BrnProduct brnproduct);
}