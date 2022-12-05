package com.mc.miraclecat.model.repository;

import com.mc.miraclecat.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * #Name MemberRepository.java
 * #Description
 *
 * #Modification Information
 * #
 * #author MiracleCat (miraclecat@itnes.co.kr)
 * #since 2021. 2. 18.
 * #
 * # 수정일        수정자             수정내용
 * # ----------   ---------------   ---------------
 * #
 */
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {


}
