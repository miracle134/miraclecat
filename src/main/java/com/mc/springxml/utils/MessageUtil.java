package com.mc.springxml.utils;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

public class MessageUtil extends PropertySourcesPlaceholderConfigurer{
	
    private static MessageSourceAccessor messageSourceAccessor;
    
    public void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
        this.messageSourceAccessor = messageSourceAccessor;
    }	
	
    public static String getMessage(String code) {
        return messageSourceAccessor.getMessage(code);
    }
     
    public static String getMessage(String code, Object[] objs) {
        return messageSourceAccessor.getMessage(code, objs);
    }
	
}
