package com.rainbow.fw.web.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ContextProvider implements ApplicationContextAware {
	private static ApplicationContext ctx = null;

	public static ApplicationContext getApplicationContext() {
		return ctx;
	}

	public static <T> T getBean(Class<T> requiredType) {
		return ctx.getBean(requiredType);
	}

	public static Object getBean(String beanName) {
		return ctx.getBean(beanName);
	}

	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		ContextProvider.ctx = ctx;
	}

}
