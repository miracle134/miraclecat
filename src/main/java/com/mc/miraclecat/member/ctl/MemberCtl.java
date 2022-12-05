package com.mc.miraclecat.member.ctl;

import com.mc.miraclecat.member.service.MemberService;
import com.mc.miraclecat.member.vo.MemberVO;
import com.mc.miraclecat.model.entity.MemberEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@RestController
public class MemberCtl {

    @Resource(name = "memberService")
    MemberService memberService;

    @PostMapping("/getMemberList")
    public ResponseEntity getMemberList() throws Exception {

        List<MemberEntity> member = memberService.getMemberList();

        return new ResponseEntity(member, HttpStatus.OK);
    }

    @PutMapping("/insertMember")
    public ResponseEntity insertMember(@RequestBody MemberVO vo) throws Exception {
        System.out.println(vo.toString());
        MemberEntity member = memberService.insertMember(vo);

        return new ResponseEntity(member, HttpStatus.OK);
    }

    @PostMapping("/getMemberChoice")
    public ResponseEntity getMemberChoice(@RequestBody MemberVO vo) throws Exception {

        System.out.println(vo.toString());
        MemberEntity member = memberService.getMemberChoice(vo);

        return new ResponseEntity(member, HttpStatus.OK);
    }

    @PatchMapping("/patchMember")
    public ResponseEntity patchMember(@RequestBody MemberVO vo) throws Exception {

        System.out.println(vo.toString());
        MemberEntity member = memberService.patchMember(vo);

        return new ResponseEntity(member, HttpStatus.OK);
    }

    @DeleteMapping("/deleteMember")
    public ResponseEntity deleteMember(@RequestBody MemberVO vo) throws Exception {

        memberService.deleteMember(vo);

        return new ResponseEntity(null, HttpStatus.OK);
    }

}

