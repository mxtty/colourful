package com.rainbow.fw.core.util;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Controller工具类
 * 
 * @author WangQi
 * 
 */
public class ControllerUtil {

	/**
	 * 私有构造函数，不可实例化
	 */
	private ControllerUtil() {
	}

	public static Method getCurrentHandlerMethod(ProceedingJoinPoint pjp) throws NoSuchMethodException,
			SecurityException {

		final String methodName = pjp.getSignature().getName();
		final MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		Method method = methodSignature.getMethod();

		if (method.getDeclaringClass().isInterface()) {
			method = pjp.getTarget().getClass().getDeclaredMethod(methodName, method.getParameterTypes());

		}
		return method;
	}

	/**
	 * 获取当前方法BindingResult
	 * 
	 * @param pjp
	 *            调用方法
	 * @return 当前方法的BindingResult
	 */
	public static BindingResult getCurrentBindingResult(ProceedingJoinPoint pjp) {
		Object[] argObjects = pjp.getArgs();
		for (Object arg : argObjects) {
			if (arg instanceof BindingResult) {
				return (BindingResult) arg;

			}
		}
		return null;
	}

	/**
	 * Request里设置Key和Value的对应属性，以便JSP中使用
	 * 例:setRequestAttribute("errors","发生异常")
	 * JSP中使用{$errors}即可取得"发生异常"字符串
	 * 
	 * @param key
	 *            设置属性使用的KEY
	 * @param attribute
	 *            对应属性
	 */
	public static void setRequestAttribute(String key, Object attribute) {

		ServletRequestAttributes requestAttributes = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes());
		requestAttributes.getRequest().setAttribute(key, attribute);
	}

}
