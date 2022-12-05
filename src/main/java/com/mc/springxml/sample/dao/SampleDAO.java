/**
  * ITNES Project
  * Copyright 2019 itnes.co.kr
  */
package com.mc.springxml.sample.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mc.springxml.model.entity.Sample;
import com.mc.springxml.sample.vo.SampleVO;

/**
 * @Name SampleDAO.java
 * @Description  
 *
 * @Modification Information
 * @
 * @author MiracleCat (miraclecat@itnes.co.kr)
 * @since 2021. 2. 18.
 * @
 * @ 수정일          수정자                  수정내용
 * @ ----------   ---------------   ---------------
 * @
 */
@Repository("sampleDAO")
public interface SampleDAO{
	

	/**
	 * <pre>
	 * 설명 : Mybatis DB1 조회
	 * </pre>
	 * @Method Name : selectListData
	 * @return
	 * @throws Exception
	 */ 	
	public List<Sample> selectMybatisDB1(SampleVO vo) throws Exception;
	
}
