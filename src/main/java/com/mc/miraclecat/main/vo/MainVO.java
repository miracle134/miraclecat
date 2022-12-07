/**
 * MiracleCat Project
 * Copyright 2016 https://github.com/miracle134
 */
package com.mc.miraclecat.main.vo;

import com.mc.miraclecat.utils.CommonParameter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * @author MiracleCat (miraclecat@itnes.co.kr)
 * @version 1.0
 * @Name Main.java
 * @Description
 * @Modification Information
 * @
 * @
 * @ 수정일      수정자            수정내용
 * @ -------   -----------   ---------------
 * @
 * @since 2021. 2. 23.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Alias("mainVO")
public class MainVO extends CommonParameter {

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
