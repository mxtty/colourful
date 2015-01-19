package com.colourful.domain.generated.mapper;
import java.util.List;
import com.colourful.domain.generated.record.BrnCategory;

public interface BrnCategoryMapper {
	List<BrnCategory> getBrnCategoryList();
	int insert(BrnCategory brncategory);
	BrnCategory readByPk(BrnCategory brncategory);
	int update(BrnCategory brncategory);
	int delete(BrnCategory brncategory);
}