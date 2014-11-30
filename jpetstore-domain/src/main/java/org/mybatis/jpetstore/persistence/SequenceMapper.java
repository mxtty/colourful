package org.mybatis.jpetstore.persistence;

import org.mybatis.jpetstore.domain.record.Sequence;

public interface SequenceMapper {

	Sequence getSequence(Sequence sequence);

	int update(Sequence sequence);
}
