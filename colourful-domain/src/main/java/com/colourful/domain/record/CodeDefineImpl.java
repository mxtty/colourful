package com.colourful.domain.record;

import java.io.Serializable;

import lombok.Data;

import com.rainbow.fw.web.codelist.bean.CodeDefine;

@Data
public class CodeDefineImpl implements Serializable, CodeDefine {

	private static final long serialVersionUID = 8461809469060330629L;
	protected String codeName;
	protected String codeKey;
	protected String codeValue;
	protected String codeComment;
}
