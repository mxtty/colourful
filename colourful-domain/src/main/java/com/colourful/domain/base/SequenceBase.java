package com.colourful.domain.base;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.colourful.domain.generated.mapper.SequenceMapper;
import com.colourful.domain.record.Sequence;

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
