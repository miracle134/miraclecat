package com.mc.springxml.member.service;

import com.mc.springxml.member.vo.MemberVO;
import com.mc.springxml.model.entity.MemberEntity;

import java.util.List;

public interface MemberService {
    List<MemberEntity> getMemberList() throws Exception;

    MemberEntity getMemberChoice(MemberVO vo) throws Exception;

    MemberEntity insertMember(MemberVO vo) throws Exception;

    MemberEntity patchMember(MemberVO vo) throws Exception;

    void deleteMember(MemberVO vo) throws Exception;
}
