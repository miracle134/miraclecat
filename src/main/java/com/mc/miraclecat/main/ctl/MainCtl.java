/**
 * MiracleCat Project
 * Copyright 2016 https://github.com/miracle134
 */
package com.mc.miraclecat.main.ctl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @author MiracleCat
 * @version 1.0
 * @Name MainCtl.java
 * @Description Main
 * @Modification Information
 * @
 * @
 * @ 수정일      수정자            수정내용
 * @ -------   -----------   ---------------
 * @
 * @since 2022. 10. 14.
 */
@Log4j2
@Controller
public class MainCtl {

//    /** SampleService */
//    @Resource(name = "sampleService")
//    SampleService sampleService;
//
//    @Autowired
//    MessageSource messageSource;
//
//    private String serverMode = PropertiesUtil.getProperty("serverMode");
//
//    @Value("${serverMode}")
//    String servrModeValue;
//
//    @Value("${type.Page}")
//    String testPageValue;
//

    /**
     * <pre>
     * 처리내용 : return 되는 jsp 페이지를 호출 한다. 수정
     * </pre>
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/")
    public String sampleList() throws Exception {

        return "main/main.tiles";
    }
//
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
//    /**
//     * <pre>
//     * 설명 : 국가코드 변경 EN
//     * </pre>
//     * @Method Name : changeEng
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/changeEng")
//    public ResponseUtil changeEng(HttpServletRequest request, HttpServletResponse response, Locale locale) throws Exception {
//        HashMap<String, Object> hm = new HashMap<String, Object>();
//
//
//        log.info("LOCALE CHECK BEFORE : {}", locale);
//
//        SessionLocaleResolver sr = new SessionLocaleResolver();
//        sr.setLocale(request, response, Locale.US);
//
//        response.setLocale(Locale.US);
//
//        log.info("LOCALE CHECK: {}", SessionUtil.getSessionAttribute(request, SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME));
//
//        LocaleContextHolder.setLocale(Locale.US);
//
//        log.info("LOCALE CHECK : {}", LocaleContextHolder.getLocale());
//        log.info("LOCALE CHECK : {}", locale);
//        log.info("TEST : {}", MessageUtil.getMessage("site.title"));
//        SessionUtil.setSessionAttribute(request, "localeLanguage", "en");
//
//        return new ResponseUtil(hm, EventCode.SUCCESS_000);
//    }
//
//    /**
//     * <pre>
//     * 설명 : 샘플 Mybatis DB1 데이터 조회
//     * </pre>
//     * @Method Name : selectMybatisDB1
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/selectMybatisDB1")
//    public ResponseUtil selectList(@ModelAttribute SampleVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        HashMap<String, Object> hm = new HashMap<String, Object>();
//
//        log.debug(vo.toString());
//        log.debug(vo.getSession());
//        log.debug("테스트 : " + PropertiesUtil.getProperty("type"));
//        log.debug("테스트 : " + SessionUtil.getSessionAttribute(request, SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME));
//
//        List<Sample> sampleList = sampleService.selectMybatisDB1(vo);
//
//        SessionLocaleResolver sr = new SessionLocaleResolver();
//
//        hm.put("local", sr.resolveLocale(request));
//        hm.put("sampleList", sampleList);
//        hm.put("test", PropertiesUtil.getProperty("type"));
//        hm.put("test2", MessageUtil.getMessage("site.title"));
//        hm.put("serverMode", serverMode);
//
//        return new ResponseUtil(hm, EventCode.SUCCESS_000);
//    }
//
//    /**
//     * <pre>
//     * 설명 : 샘플 JPA 데이터 조회
//     * </pre>
//     * @Method Name : selectListData
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/selectListData")
//    public ResponseEntity<HashMap<String, Object>> selectListData(@RequestParam HashMap<String, Object> map) throws Exception {
//        HashMap<String, Object> hm = new HashMap<String, Object>();
//
//        List<Sample> sampleList = sampleService.getSampleList();
//
//        hm.put("sampleList", sampleList);
//
//        return new ResponseEntity<HashMap<String, Object>>(hm, HttpStatus.OK);
//    }
//
//    /**
//     * <pre>
//     * 설명 : 샘플 JPA 데이터 상세 조회
//     * </pre>
//     * @Method Name : selectDetail
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/selectDetail")
//    public ResponseEntity<HashMap<String, Object>> selectDetail(@RequestParam HashMap<String, Object> map) throws Exception {
//        HashMap<String, Object> hm = new HashMap<String, Object>();
//        SampleVO vo = (SampleVO) ObjectUtil.convertMapToObject(map, SampleVO.class);
//
//        Sample selectDetail = sampleService.selectDetail(vo);
//
//        hm.put("selectDetail", selectDetail);
//
//        return new ResponseEntity<HashMap<String, Object>>(hm, HttpStatus.OK);
//    }
//
//    /**
//     * <pre>
//     * 설명 : 샘플 JPA 데이터 저장
//     * </pre>
//     * @Method Name : sampleSave
//     * @return
//     * @throws Exception
//     */
//    @PutMapping(value = "/sampleSave")
//    public ResponseEntity<HashMap<String, Object>> sampleSave(@RequestParam HashMap<String, Object> map) throws Exception {
//        HashMap<String, Object> hm = new HashMap<String, Object>();
//        try {
//            SampleVO vo = (SampleVO) ObjectUtil.convertMapToObject(map, SampleVO.class);
//
//            Long seq = sampleService.sampleSave(vo);
//
//            hm.put("seq", seq);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return new ResponseEntity<HashMap<String, Object>>(hm, HttpStatus.OK);
//    }
//
//    /**
//     * <pre>
//     * 설명 : 샘플 JPA 데이터 수정
//     * </pre>
//     * @Method Name : sampleUpdate
//     * @param map
//     * @return
//     * @throws Exception
//     */
//    @PatchMapping(value = "/sampleUpdate")
//    public ResponseEntity<HashMap<String, Object>> sampleUpdate(@RequestParam HashMap<String, Object> map) throws Exception {
//        HashMap<String, Object> hm = new HashMap<String, Object>();
//        try {
//            SampleVO vo = (SampleVO) ObjectUtil.convertMapToObject(map, SampleVO.class);
//
//            sampleService.sampleUpdate(vo);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return new ResponseEntity<HashMap<String, Object>>(hm, HttpStatus.OK);
//    }
//
//    /**
//     * <pre>
//     * 설명 : 샘플 JPA 데이터 삭제
//     * </pre>
//     * @Method Name : sampleDelete
//     * @param map
//     * @return
//     * @throws Exception
//     */
//    @DeleteMapping(value = "/sampleDelete")
//    public ResponseEntity<HashMap<String, Object>> sampleDelete(@RequestParam HashMap<String, Object> map) throws Exception {
//        HashMap<String, Object> hm = new HashMap<String, Object>();
//        try {
//            SampleVO vo = (SampleVO) ObjectUtil.convertMapToObject(map, SampleVO.class);
//
//            sampleService.sampleDelete(vo);
//
//            List<Sample> sampleList = sampleService.getSampleList();
//            hm.put("sampleList", sampleList);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            hm.put("LOG", "FAIL");
//            return new ResponseEntity<HashMap<String, Object>>(hm, HttpStatus.OK);
//        }
//
//        return new ResponseEntity<HashMap<String, Object>>(hm, HttpStatus.OK);
//    }

    public static void main(String[] args) {


        for (int i = 0; i < 2; i++) {
            lotto();
        }

    }

    public static void lotto() {

        int[] num =
                {
                        43
                        , 34
                        , 27
                        , 1
                        , 13
                        , 17
//                        , 12
                        , 18
                        , 33
                        , 39

                        , 4
                        , 20
                        , 14
                        , 10
//                        , 26
                        , 2
                        , 24
                        , 37
                        , 38
                        , 40

//                        , 3
                        , 11
                        , 16
//                        , 31
                        , 45
                        , 21
                        , 7
                        , 15
                        , 44
                        , 6

                        , 35
                        , 42
                        , 36
                        , 8
//                        , 5
                        , 19
                        , 25
                        , 30
                        , 32
                        , 28

                        , 41
                        , 29
                        , 23
                        , 9
//                        , 22
                };

        List<Integer> list = Arrays.stream(num).boxed().collect(Collectors.toList());
        StringJoiner sj = new StringJoiner(",");
        int j = list.size();

        for (int i = j; i > (j - 6); i--) {

            int tmp = (int) (Math.random() * i);

            sj.add(String.valueOf(list.get(tmp)));

            list.remove(tmp);
        }

        System.out.println("번호 : " + sj.toString());
    }

}
