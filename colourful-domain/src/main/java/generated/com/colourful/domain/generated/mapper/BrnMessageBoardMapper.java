package com.colourful.domain.generated.mapper;
import java.util.List;
import com.colourful.domain.generated.record.BrnMessageBoard;

public interface BrnMessageBoardMapper {
	List<BrnMessageBoard> getBrnMessageBoardList();
	int insert(BrnMessageBoard brnmessageboard);
	BrnMessageBoard readByPk(BrnMessageBoard brnmessageboard);
	int update(BrnMessageBoard brnmessageboard);
	int delete(BrnMessageBoard brnmessageboard);
}