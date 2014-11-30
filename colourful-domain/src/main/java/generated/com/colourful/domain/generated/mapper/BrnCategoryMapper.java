package com.colourful.domain.generated.mapper;

import java.util.List;
import com.colourful.domain.generated.record.BrnCategory;

public interface BrnCategoryMapper {

	List<BrnCategory> getBrnCategoryList();

	void insert(BrnCategory brncategory);

	BrnCategory readByPk(BrnCategory brncategory);

	void update(BrnCategory brncategory);

}
