/**
  * ITNES Project
  * Copyright 2019 itnes.co.kr
  */
package com.mc.springxml.sample.vo;

import org.apache.ibatis.type.Alias;

import com.mc.springxml.utils.CommonParameter;

import lombok.Data;
import lombok.EqualsAndHashCode;
 
/**
 * @Name SamplePVO.java
 * @Description  
 *
 * @Modification Information
 * @
 * @
 * @ 수정일      수정자            수정내용
 * @ -------   -----------   ---------------
 * @
 * @author MiracleCat (miraclecat@itnes.co.kr)
 * @since 2021. 2. 23.
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Alias("sampleVO")
public class SampleVO extends CommonParameter{
	
	/**************** Parameter *****************/
	
	private Long sSeq; // pk
	private String sName; // 이름
	private String sPassword; // 비밀번호
	private String sMessage; // 메세지
	private String sRegId; // 등록자
	
	/******************************************/
	
	/***************** Result *******************/
	
	private Long seq; // pk
	private String name; // 이름
	private String password; // 비밀번호
	private String message; // 메세지
	private String regid; // 등록자
	
	/******************************************/

}
