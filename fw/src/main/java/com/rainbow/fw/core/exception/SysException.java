package com.rainbow.fw.core.exception;

public class SysException extends BaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2619291648852952941L;

	public SysException(String messageId, Object... arges) {
		super(messageId, arges);

	}

	public SysException(String message, Throwable cause) {
		super(message, cause);
	}

}
