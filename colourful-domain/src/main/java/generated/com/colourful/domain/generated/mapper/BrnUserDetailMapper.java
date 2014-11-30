package com.colourful.domain.generated.mapper;
import java.util.List;
import com.colourful.domain.generated.record.BrnUserDetail;

public interface BrnUserDetailMapper {
	List<BrnUserDetail> getBrnUserDetailList();
	int insert(BrnUserDetail brnuserdetail);
	BrnUserDetail readByPk(BrnUserDetail brnuserdetail);
	int update(BrnUserDetail brnuserdetail);
	int delete(BrnUserDetail brnuserdetail);
}