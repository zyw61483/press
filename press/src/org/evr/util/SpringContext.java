package org.evr.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContext implements ApplicationContextAware {

	protected static ApplicationContext context;

	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context = arg0;
	}

	private static ApplicationContext getContext() {
		return context;
	}
	
	public static Object getBean(String beanName)
	{
		return SpringContext.getContext().getBean(beanName);		
	}
}
