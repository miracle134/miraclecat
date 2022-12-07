/**
 * MiracleCat Project
 * Copyright 2016 https://github.com/miracle134
 */
package com.mc.miraclecat.notice.vo;

import com.mc.miraclecat.utils.CommonParameter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * packageName    : com.mc.miraclecat.notice.vo
 * fileName       : NoticeVO
 * author         : MiracleCat
 * date           : 2022-12-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-06        MiracleCat       최초 생성
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Alias("noticeVO")
public class NoticeVO extends CommonParameter{
	
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
