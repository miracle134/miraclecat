/**
 * MiracleCat Project
 * Copyright 2016 https://github.com/miracle134
 */
package com.mc.miraclecat.member.ctl;

import com.mc.miraclecat.member.service.MemberService;
import com.mc.miraclecat.member.vo.MemberVO;
import com.mc.miraclecat.model.entity.MemberEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author MiracleCat
 * @version 1.0
 * @Name MemberCtl.java
 * @Description Member
 * @Modification Information
 * @
 * @
 * @ 수정일      수정자            수정내용
 * @ -------   -----------   ---------------
 * @
 * @since 2022. 12. 07.
 */
@Controller
@RequestMapping(value = "/member")
public class MemberCtl {

    @Resource(name = "memberService")
    MemberService memberService;

    /**
     * @return Login Page
     * @throws Exception
     */
    @GetMapping("/{memberPage}")
    public ModelAndView memberGetPage(@PathVariable(value = "memberPage") String memberPage) throws Exception {
        ModelAndView mv = new ModelAndView();
        switch (memberPage){
            case "login": mv.setViewName("/member/login"); break;
            case "register": mv.setViewName("/member/register"); break;
            default : throw new Exception();
        }

        return mv;
    }

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

