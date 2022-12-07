/**
 * MiracleCat Project
 * Copyright 2016 https://github.com/miracle134
 */
package com.mc.miraclecat.member.vo;

import lombok.Data;

@Data
public class MemberVO {

    private Long memberId;
    private String email;
    private String password;
    private String authority;
    private String name;
    private String address;
    private String cellPhone;

}
