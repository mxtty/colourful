package com.rainbow.fw.core.exception.handler;

import java.lang.reflect.Method;

import lombok.Setter;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.BindingResult;

import com.rainbow.fw.core.exception.AppException;
import com.rainbow.fw.core.exception.BaseException;
import com.rainbow.fw.core.exception.SysException;
import com.rainbow.fw.core.util.ControllerUtil;

/**
 * 例外处理注解
 * 
 * @author WangQi
 * 
 */
@Aspect
public class AnotationExceptionHandler {

	/**
	 * 缺省错误URL
	 */
	@Setter
	private String commExceptionUrl;

	/**
	 * 消息源
	 */
	@Setter
	private ReloadableResourceBundleMessageSource messageSource;

	/**
	 * 业务异常LOG
	 */
	private static Logger applog = Logger.getLogger("AppLogger");

	/**
	 * 系统异常LOG
	 */
	private static Logger syslog = Logger.getLogger("SysLogger");

	/**
	 * 
	 * 
	 * @param pjp
	 * @return
	 */
	@Around("execution(* *..controller.*.*(..))")
	public Object around(ProceedingJoinPoint pjp) {
		System.out.println("iN");
		Method method = null;
		// 获取处理方法
		try {
			method = ControllerUtil.getCurrentHandlerMethod(pjp);
		} catch (NoSuchMethodException e) {
			syslog.error("系统错误", e);
			return null;
		} catch (SecurityException e) {
			syslog.error("系统错误", e);
		}

		// System.out.println("beginning----" + method.getName());
		// 方法异常处理结果
		BindingResult bindingResult = ControllerUtil
				.getCurrentBindingResult(pjp);

		// 方法注解
		ExceptionHandlerAdvice ea = method
				.getAnnotation(ExceptionHandlerAdvice.class);
		if (null != bindingResult && bindingResult.hasErrors()) {
			// 方法执行有错，并且定义了返回错误页面
			return ea.errorPath();
		}

		Object object = null;
		try {
			object = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			String errMsg = null;
			// BaseException时，根据ID获取消息体
			if (e instanceof BaseException) {
				BaseException exception = (BaseException) e;

				errMsg = messageSource
						.getMessage(exception.getMessageId(),
								exception.getArges(), null).concat("(")
						.concat(exception.getMessageId()).concat(")");
			}

			if (e instanceof AppException) {
				// 业务异常
				AppException appException = (AppException) e;
				bindingResult.reject(appException.getMessageId(),
						appException.getArges(), "");
				applog.info(errMsg, e);
				return (null != ea) ? ea.errorPath() : commExceptionUrl;
			} else if (e instanceof SysException) {
				// 系统异常
				syslog.error(errMsg, e);
				ControllerUtil.setRequestAttribute("errors",
						(null == errMsg) ? "System Error!" : errMsg);
				return commExceptionUrl;
			} else {
				// 未知致命异常
				StringBuffer fatalMsg = new StringBuffer();
				fatalMsg.append(e);
				for (StackTraceElement ste : e.getStackTrace()) {
					fatalMsg.append("\n");
					fatalMsg.append("\t".concat(ste.toString()));
				}
				//syslog.fatal(fatalMsg.toString());
				ControllerUtil.setRequestAttribute("errors",
						"系统发生错误，请重新操作或与管理员联系！");
				System.out.println("Return "+commExceptionUrl);
				return commExceptionUrl;
			}
		}

		return object;
	}
}
