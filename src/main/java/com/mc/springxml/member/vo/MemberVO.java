package com.mc.springxml.member.vo;

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
