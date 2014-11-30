package com.colourful.domain.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.colourful.domain.base.SequenceBase;

@SuppressWarnings("serial")
@Component
@Scope("prototype")
public class SequenceEntity extends SequenceBase {

	public int nextId(Class<?> cls) {
		name = cls.getName();
		getEntityByPk();
		return ++nextId;

	}
}
