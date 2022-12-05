package com.mc.miraclecat.member.service.impl;

import com.mc.miraclecat.member.service.MemberService;
import com.mc.miraclecat.member.vo.MemberVO;
import com.mc.miraclecat.model.entity.MemberEntity;
import com.mc.miraclecat.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public List<MemberEntity> getMemberList() throws Exception {
        return memberRepository.findAll();
    }

    @Override
    @Transactional
    public MemberEntity insertMember(MemberVO vo) throws Exception {

        // SHA-256 비밀번호 암호화
        MessageDigest md = MessageDigest.getInstance("SHA-256"); // MessageDigest SHA-256
        StringBuilder sb = new StringBuilder(); // 암호화된 문자열 담기

        md.update(vo.getPassword().getBytes());

        for(byte b : md.digest()) {
            // 10진수 to 16진수 변환
            sb.append(String.format("%02x", b));
        }

        // 기존 비밀번호 > 암호화 비밀번호 : 값 변경
        vo.setPassword(sb.toString());

        // 엔터티 생성
        MemberEntity member = MemberEntity.createMemberEntity().memberVO(vo).build();

        // 등록
        memberRepository.save(member);

        return member;
    }

    @Override
    public MemberEntity getMemberChoice(MemberVO vo) throws Exception {
        Optional<MemberEntity> member = memberRepository.findById(vo.getMemberId());

        return member.orElseThrow(Exception::new);
    }

    @Override
    @Transactional
    public MemberEntity patchMember(MemberVO vo) throws Exception {

        Optional<MemberEntity> memberEntity = memberRepository.findById(vo.getMemberId());

        MemberEntity member = memberEntity.orElseThrow(Exception::new);
        member.patchMember(vo);

        // 업데이트
        memberRepository.save(member);

        return member;
    }

    @Override
    @Transactional
    public void deleteMember(MemberVO vo) throws Exception {
        memberRepository.deleteById(vo.getMemberId());
    }

}
