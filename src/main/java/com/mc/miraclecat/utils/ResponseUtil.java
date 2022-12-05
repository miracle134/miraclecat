/**
  * ITNES Project
  * Copyright 2019 itnes.co.kr
  */
package com.mc.miraclecat.utils;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @Name ResponseUtil.java
 * @Description  
 *
 * @Modification Information
 * @
 * @
 * @ 수정일      수정자            수정내용
 * @ -------   -----------   ---------------
 * @
 * @author MiracleCat (miraclecat@itnes.co.kr)
 * @since 2021. 2. 22.
 * @version 1.0
 */
public class ResponseUtil extends ResponseEntity<HashMap<String, Object>> {

	public ResponseUtil(HashMap<String, Object> hm, String[] eventCode) {
		super(hm, HttpStatus.OK);

		HashMap<String, String> resultHm = new HashMap<String, String>();

		resultHm.put("code", eventCode[0]);
		resultHm.put("result_msg", eventCode[1]);

		hm.put("result_code", resultHm);
	}
	
}
