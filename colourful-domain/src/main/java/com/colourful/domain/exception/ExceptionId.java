package com.colourful.domain.exception;

import com.rainbow.fw.core.exception.AppException;
import com.rainbow.fw.core.exception.SysException;

public enum ExceptionId {
	E1001, E1002, appeid, syseid,PK_NULL;

	private String messageId;

	private ExceptionId() {
		this.messageId = name();
	}

	public void rejectApp(Object... arges) {
		throw new AppException(messageId, arges);
	}

	public void rejectSys(Object... arges) {
		throw new SysException(messageId, arges);
	}
}
