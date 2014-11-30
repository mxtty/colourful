package org.mybatis.jpetstore.domain.record;

import java.io.Serializable;

import lombok.Data;

@Data
public class Sequence implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6234617530077753088L;
	protected String name;
	protected int nextId;
}
