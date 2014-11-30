package com.rainbow.fw.core.exception;

/**
 * APP 业务异常类
 * 
 * @author WangQi
 *
 */
public class AppException extends BaseException {
	/**
	 * serial id
	 */
	private static final long serialVersionUID = 2619291648852952941L;

	/**
	 * 构造函数
	 * 
	 * @param messageId 消息ID
	 * @param arges 参数列表
	 */
	public AppException(String messageId, Object... arges) {
		super(messageId, arges);

	}

	/**
	 * 构造函数
	 * 
	 * @param message 消息ID
	 * @param cause 发生理由
	 */
	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

}
