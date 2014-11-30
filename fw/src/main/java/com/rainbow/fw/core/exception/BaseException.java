package com.rainbow.fw.core.exception;

import lombok.Getter;

public abstract class BaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7977724497383957577L;

	@Getter
	private String messageId;

	@Getter
	private Object[] arges;

	public BaseException(String messageId, Object... arges) {
		super(messageId);
		this.messageId = messageId;
		this.arges = arges;

	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public String getMessage() {
		return super.getMessage();
	}
}
