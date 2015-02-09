package com.colourful.domain.generated.mapper;
import java.util.List;
import com.colourful.domain.generated.record.BrnCart;

public interface BrnCartMapper {
	List<BrnCart> getBrnCartList();
	int insert(BrnCart brncart);
	BrnCart readByPk(BrnCart brncart);
	int update(BrnCart brncart);
	int delete(BrnCart brncart);
}