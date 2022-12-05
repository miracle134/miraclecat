package com.mc.springxml.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j2;


/**
 * @Name CustomSimpleMappingExceptionResolver.java
 * @Description  Exception 처리
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
@Log4j2
@ControllerAdvice
public class ExceptionCtl {

	/**
	 * <pre>
	 * 설명 : 400 처리
	 * </pre>
	 * @Method Name : handleError400
	 * @param request
	 * @param e
	 * @return
	 */
	@ExceptionHandler({
	    MissingServletRequestParameterException.class,
	    ServletRequestBindingException.class,
	    TypeMismatchException.class,
	    HttpMessageNotReadableException.class,
	    HttpMessageNotWritableException.class,
	    MethodArgumentNotValidException.class,
	    MissingServletRequestPartException.class,
	})
	public static ModelAndView handleError400(HttpServletRequest request, Exception e) {
		log.error(e.toString());
		ModelAndView mav = new ModelAndView();

		mav.setViewName("error/error-400");
		mav.addObject("message", "400오류");
		mav.addObject("url", request.getRequestURL());
		mav.addObject("error", e);

		return mav;
	}

	/**
	 * <pre>
	 * 설명 : 404 처리
	 * </pre>
	 * @Method Name : handleError404
	 * @param request
	 * @param e
	 * @return
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public static ModelAndView handleError404(HttpServletRequest request, Exception e) {
		log.error(e.toString());
		ModelAndView mav = new ModelAndView();

		mav.setViewName("error/error-404");
		mav.addObject("message", "404오류");
		mav.addObject("url", request.getRequestURL());
		mav.addObject("error", e);

		return mav;
	}

	/**
	 * <pre>
	 * 설명 : 405 처리
	 * </pre>
	 * @Method Name : handleError405
	 * @param request
	 * @param e
	 * @return
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public static ModelAndView handleError405(HttpServletRequest request, Exception e) {
		log.error(e.toString());
		ModelAndView mav = new ModelAndView();

		mav.setViewName("error/error-405");
		mav.addObject("message", "405오류");
		mav.addObject("url", request.getRequestURL());
		mav.addObject("error", e);

		return mav;
	}

	/**
	 * <pre>
	 * 설명 : Exception 처리
	 * </pre>
	 * @Method Name : commonException
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public static ModelAndView commonException(Exception e, HttpServletRequest request) {
		log.error(e.toString());
		ModelAndView mav = new ModelAndView();

		mav.setViewName("error/default");
		mav.addObject("exception", e);
		mav.addObject("url", request.getRequestURL());
		mav.addObject("error", e);

		return mav;
	}

}