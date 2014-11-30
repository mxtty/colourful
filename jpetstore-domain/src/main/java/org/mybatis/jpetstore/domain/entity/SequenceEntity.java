package org.mybatis.jpetstore.domain.entity;

import org.mybatis.jpetstore.domain.base.SequenceBase;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
