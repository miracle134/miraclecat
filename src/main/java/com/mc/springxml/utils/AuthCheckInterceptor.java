package com.mc.springxml.utils;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import lombok.extern.log4j.Log4j2;

/**
 * @Name AuthCheckInterceptor.java
 * @Description  
 *
 * @Modification Information
 * @
 * @
 * @ 수정일      수정자            수정내용
 * @ -------   -----------   ---------------
 * @
 * @author ITNES
 * @since 2021. 2. 19.
 * @version 1.0
 */
@Log4j2
public class AuthCheckInterceptor implements HandlerInterceptor{
	
	
	/**
	 * 클라이언트의 요청을 controller에 전달하기 전에 호출됨. 
	 * false를 리턴하면 다음 내용은 실행하지 않는다.
	 * 
	 * @param request 
	 * @param response 
	 * @param handler
	 * @return 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		
		// 국가코드 세션 확인
		String localeCountry = (String)SessionUtil.getSessionAttribute(request, "localeCountry");
		String localeLanguage = (String)SessionUtil.getSessionAttribute(request, "localeLanguage");
		log.debug("현재 localeCountry: " + localeCountry);
		log.debug("현재 localeLanguage: " + localeLanguage);
		
		// 국가코드 설정
		if(StringUtil.isEmpty(localeLanguage)) {
			log.debug("현재 IP " + request.getRemoteAddr());
			
			// 국가언어 코드 Get
			String[] country = GeoIpUtil.getCountry(request.getRemoteAddr());
			
			log.debug("localeCountry " + country[0]);
			log.debug("localeLanguage " + country[1]);
			
			// 국가언어 코드 Set
			localeCountry = country[0];
			localeLanguage = country[1];
			SessionUtil.setSessionAttribute(request, "localeCountry", country[0]);
			SessionUtil.setSessionAttribute(request, "localeLanguage", country[1]);
			
			// Spring Message Set
	    	SessionLocaleResolver sr = new SessionLocaleResolver();
	    	sr.setLocale(request, response, new Locale(country[1]));
	    	
		}
		
		// 해외에서 국내 사이트 접근시 해외 메인 페이지로 리다이렉트
//		if(!"KR".equals(localeLanguage) && !request.getRequestURI().startsWith("/international")) {
//			response.sendRedirect("/international/main");
//			return false;
//		}
			
		return true;
			
	}
 
	/**
	 * 클라이언트의 요청을 controller에서 처리한 뒤에 View로 보내지기전 호출됨. 
	 * controller에서 예외가 발생되면 실행하지 않는다.
	 * 
	 * @param request 
	 * @param response 
	 * @param handler
	 * @param modelAndView 
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	
	}
 
	/**
	 * 클라이언트 요청 처리뒤 클리이언트에 View를 통해 응답을 전송한뒤 실행 됨. 
	 * View를 생설항때 예외가 발생해도 실행된다
	 * 
	 * @param request 
	 * @param response 
	 * @param handler
	 * @param ex 
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	
	}
	
	/**
	 * 클라이언트의 요청의 Header 값이 ajax인지 판별한다.
	 * false를 리턴하면 다음 내용은 실행하지 않는다.
	 * 
	 * @param request 
	 * @param response 
	 * @param handler
	 * @return 
	 */
    private boolean isAjaxRequest(HttpServletRequest req) {
        String header = req.getHeader("AJAX");
        if ("true".equals(header)){
        	return true;
        }else{
        	return false;
        }
    }
    
}
