package com.rainbow.fw.core.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertiesUtil extends PropertyPlaceholderConfigurer {
	private static Map<String, String> propertiesMap;

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
			throws BeansException {
		super.processProperties(beanFactory, props);

		propertiesMap = new HashMap<String, String>();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			propertiesMap.put(keyStr, resolvePlaceholder(props.getProperty(keyStr), props));
		}
	}

	public static String getProperty(String name) {
		return propertiesMap.get(name);
	}
}