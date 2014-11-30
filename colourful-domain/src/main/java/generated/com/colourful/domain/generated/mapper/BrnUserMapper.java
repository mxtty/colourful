package com.colourful.domain.generated.mapper;
import java.util.List;
import com.colourful.domain.generated.record.BrnUser;

public interface BrnUserMapper {
	List<BrnUser> getBrnUserList();
	int insert(BrnUser brnuser);
	BrnUser readByPk(BrnUser brnuser);
	int update(BrnUser brnuser);
	int delete(BrnUser brnuser);
}