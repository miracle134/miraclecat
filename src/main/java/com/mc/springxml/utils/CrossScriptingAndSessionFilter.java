/**
  * ITNES Project
  * Copyright 2019 itnes.co.kr
  */
package com.mc.springxml.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.log4j.Log4j2;
 
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
@Log4j2
public class CrossScriptingAndSessionFilter implements Filter {

public FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }
 
    public void destroy() {
        this.filterConfig = null;
    }
 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
    	try {
    		// XSS 처리
    		RequestWrapper  rw = new RequestWrapper((HttpServletRequest) request);
    		
//    		// 세션값 넣어줌
//    		LoginVO loginVO = (LoginVO)SessionUtil.getSessionAttribute(request, "userInfo");
//    		
//    		log.debug("세션값 " + loginVO);
//    		
//    		// 세션값이 있으면 Parameter 추가
//    		if(!ObjectUtils.isEmpty(loginVO)) {
//    			rw.setParameter("session", a);
//    			
//    			request = rw;
//    		}

	        chain.doFilter(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}