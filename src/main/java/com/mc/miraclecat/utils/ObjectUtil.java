/**
  * ITNES Project
  * Copyright 2019 itnes.co.kr
  */
package com.mc.miraclecat.utils;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Name ObjectUtil.java
 * @Description  
 *		Object & Json & Map 상호 변환 유틸
 *
 * @Modification Information
 * @
 * @수정일       수정자     수정내용
 * @----------   --------   ---------------
 * @2018.06.11   이지호
 * @2021.02.13   이지호          
 * 
 * @author ITNES 이지호 (miraclecat@itnes.co.kr)
 * @since 2018. 11. 22.
 * @version 1.1
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class ObjectUtil {

	private static ObjectMapper mapper = new ObjectMapper().configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
	
	/** JsonString to Map */
	public static Map<String, Object> convertJsonToMap(String json){
		Map<String, Object> map = null;
		try {
			map = mapper.readValue(json, HashMap.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	/** JsonString to Object */
	public static Object convertJsonToObject(String json, Class object){
		Object obj = null;
		try {
			obj = mapper.readValue(json, object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
	/** Map to JsonString */
	public static String convertMapToJson(HashMap<String, Object> map){
		String result = null;
		try {
			result = mapper.writeValueAsString(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	/** Object to JsonString */
	public static String convertObjectToJson(Object vo){
		String result = null;
		try {
			result = mapper.writeValueAsString(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/** Map to Object */
	public static Object convertMapToObject(HashMap<String, Object> map, Class object){
		Object obj = null;
		try {
			obj = mapper.convertValue(map, object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
	/** Object to Map */
	public static Map<String, Object> convertObjectToMap(Object obj){
		Map<String, Object> hm = null;
		try {
			hm = mapper.convertValue(obj, HashMap.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return hm;
	}
	
}
