/**
  * ITNES Project
  * Copyright 2019 itnes.co.kr
  */
package com.mc.springxml.utils;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Name CommonMessageSource
 * @Description 
 *      web.xml filter 관련 xss 치환
 *      session 값 request param 추가        
 *
 * @Modification Information
 * @
 * @ 수정일               수정자              수정내용
 * @------------   --------       ---------------
 * @2018.06.11    김재갑             최초생성
 * @2021.02.22    이지호             session 값 request param 추가
 * 
 * @author ITNES 김재갑
 * @since 2018.06.11
 * @version 1.0
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
 
/**
 * @Name RequestWrapper.java
 * @Description  
 *
 * @Modification Information
 * @
 * @
 * @ 수정일      수정자            수정내용
 * @ -------   -----------   ---------------
 * @
 * @author MiracleCat
 * @since 2021. 3. 8.
 * @version 1.0
 */
public final class RequestWrapper extends HttpServletRequestWrapper {

    private HashMap<String, String[]> params;

    public RequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
        this.params = new HashMap<String, String[]>(servletRequest.getParameterMap());
    }
 
    @Override
    public Map<String, String[]> getParameterMap() {
    	return Collections.unmodifiableMap(params);
    }
    
    @Override
    public String getParameter(String parameter) {
    	String[] value = getParameterValues(parameter);
        if (value == null || value.length == 0) return null;
          
        return cleanXSS(value[0]);
    }
 
    @Override
    public String[] getParameterValues(String parameter) {
    	String[] values = params.get(parameter);
    	if (values==null) return null;
  
    	int count = values.length;
    	String[] encodedValues = new String[count];
  
    	for (int i = 0; i < count; i++) {
    		encodedValues[i] = cleanXSS(values[i]);
    	}
      
  		return encodedValues;
    }
    
    @Override
    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(params.keySet());
    }
    
    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (value == null) return null;
        
        return cleanXSS(value);
    }
    
    public void setParameter(String name, String value) {
        String[] oneParam = { value };
        setParameter(name, oneParam);
    }

    public void setParameter(String name, String[] value) {
        params.put(name, value);
    }

    private String cleanXSS(String value) {
        value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
        value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
        value = value.replaceAll("'", "& #39;");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replaceAll("script", "");
        return value;
    }
}
