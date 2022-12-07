/**
 * MiracleCat Project
 * Copyright 2016 https://github.com/miracle134
 */
package com.mc.miraclecat.notice.ctl;

import com.mc.miraclecat.main.service.MainService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * packageName    : com.mc.miraclecat.notice.ctl
 * fileName       : NoticeCtl
 * author         : MiracleCat
 * date           : 2022-12-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-06        MiracleCat       최초 생성
 */
@Log4j2
@Controller
public class NoticeCtl {

    /**
     * <pre>
     * 처리내용 : return 되는 jsp 페이지를 호출 한다. 수정
     * </pre>
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/notice")
    public String noticePage(){

        return "notice/notice.tiles";
    }

//    /**
//     * <pre>
//     * 설명 : 국가코드 변경 KR
//     * </pre>
//     * @Method Name : changeKor
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/changeKor")
//    public ResponseUtil changeKor(HttpServletRequest request, HttpServletResponse response, Locale locale) throws Exception {
//        HashMap<String, Object> hm = new HashMap<String, Object>();
//
//        log.info("LOCALE CHECK BEFORE : {}", locale);
//
//        SessionLocaleResolver sr = new SessionLocaleResolver();
//        sr.setLocale(request, response, Locale.KOREA);
//
//        Locale.setDefault(Locale.KOREA);
//
//        log.info("LOCALE CHECK: {}", SessionUtil.getSessionAttribute(request, SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME));
//        log.info("LOCALE CHECK : {}", LocaleContextHolder.getLocale());
//        log.info("LOCALE CHECK : {}", locale);
//        log.info("TEST : {}", MessageUtil.getMessage("site.title"));
//        SessionUtil.setSessionAttribute(request, "localeLanguage", "ko");
//
//        return new ResponseUtil(hm, EventCode.SUCCESS_000);
//    }
//

}
