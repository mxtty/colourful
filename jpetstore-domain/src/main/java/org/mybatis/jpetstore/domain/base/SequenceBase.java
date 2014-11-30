package org.mybatis.jpetstore.domain.base;

import org.mybatis.jpetstore.domain.record.Sequence;
import org.mybatis.jpetstore.persistence.SequenceMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("serial")
public abstract class SequenceBase extends Sequence {
	@Autowired
	private SequenceMapper sequenceMapper;

	public void update() {

		sequenceMapper.update(this);
	}

	public void getEntityByPk() {

		BeanUtils.copyProperties(sequenceMapper.getSequence(this), this);
	}
}
