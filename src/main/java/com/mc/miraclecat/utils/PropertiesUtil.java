package com.mc.miraclecat.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurablePropertyResolver;

public class PropertiesUtil extends PropertySourcesPlaceholderConfigurer{
	
	private static ConfigurablePropertyResolver property;
	
	public static String getProperty(String key){
		return property.getProperty(key, "");
	}
	
	public static String getProperty(String key, String defaultValue){
		return property.getProperty(key, defaultValue);
	}

	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess,
			final ConfigurablePropertyResolver propertyResolver) throws BeansException {
		super.processProperties(beanFactoryToProcess, propertyResolver);
		
		property = propertyResolver;
		
	}
	
}
