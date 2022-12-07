/**
 * MiracleCat Project
 * Copyright 2016 https://github.com/miracle134
 * @menu : 공통 플러그인
 * @since : 2021. 2. 18.
 * @author : MiracleCat
 */
(function ($) {

    /**
     GET Ajax
     data : 데이터
     url : Controller 경로
     callback : 성공 callback 함수
     error callback : 실패 callback 함수
     async : 동기/비동기 여부 (비동기: true(default) 동기: false)
     */
    $.getAjax = function (data, url, callback, errorcallback, async) {
        let ajaxSyncFlag = true;
        let asyncVal = true;

        if (async !== "") {
            asyncVal = async;
        }

        if (ajaxSyncFlag) {
            $.ajax({
                url: url,
                async: asyncVal,
                type: 'GET',
                data: data,
                dataType: 'json',
                success: function (data) {
                    callback(data);
                },
                error: function (data) {
                    errorcallback(data);
                },
                beforeSend: function (xmlHttpRequest) {
                    ajaxSyncFlag = false;
                    xmlHttpRequest.setRequestHeader("AJAX", "true");
                }
                , complete: function () {
                    ajaxSyncFlag = true;
                }
            });
        }
    };

    /**
     POST Ajax
     data : 데이터
     url : Controller 경로
     callback : 성공 callback 함수
     errorcallback : 실패 callback 함수
     async : 동기/비동기 여부 (비동기: true(default) 동기: false)
     */
    $.postAjax = function (data, url, callback, errorcallback, async) {
        let ajaxSyncFlag = true;
        let asyncVal = true;

        if (async !== "") {
            asyncVal = async;
        }

        if (ajaxSyncFlag) {
            $.ajax({
                url: url,
                async: asyncVal,
                type: 'POST',
                data: data,
                dataType: 'json',
                success: function (data) {
                    callback(data);
                },
                error: function (data) {
                    errorcallback(data);
                },
                beforeSend: function (xmlHttpRequest) {
                    ajaxSyncFlag = false;
                    xmlHttpRequest.setRequestHeader("AJAX", "true");
                }
                , complete: function () {
                    ajaxSyncFlag = true;
                }
            });
        }
    };

    /**
     PUT Ajax
     data : 데이터
     url : Controller 경로
     callback : 성공 callback 함수
     errorcallback : 실패 callback 함수
     async : 동기/비동기 여부 (비동기: true(default) 동기: false)
     */
    $.putAjax = function (data, url, callback, errorcallback, async) {
        var ajaxSyncFlag = true;
        var asyncVal = true;

        if (async !== "") {
            asyncVal = async;
        }

        if (ajaxSyncFlag) {
            $.ajax({
                url: url,
                async: asyncVal,
                type: 'PUT',
                data: data,
                dataType: 'json',
                success: function (data) {
                    callback(data);
                },
                error: function (data) {
                    errorcallback(data);
                },
                beforeSend: function (xmlHttpRequest) {
                    ajaxSyncFlag = false;
                    xmlHttpRequest.setRequestHeader("AJAX", "true");
                }
                , complete: function () {
                    ajaxSyncFlag = true;
                }
            });
        }
    };

    /**
     PATCH Ajax
     data : 데이터
     url : Controller 경로
     callback : 성공 callback 함수
     errorcallback : 실패 callback 함수
     async : 동기/비동기 여부 (비동기: true(default) 동기: false)
     */
    $.patchAjax = function (data, url, callback, errorcallback, async) {
        var ajaxSyncFlag = true;
        var asyncVal = true;

        if (async !== "") {
            asyncVal = async;
        }

        if (ajaxSyncFlag) {
            $.ajax({
                url: url,
                async: asyncVal,
                type: 'PATCH',
                data: data,
                dataType: 'json',
                success: function (data) {
                    callback(data);
                },
                error: function (data) {
                    errorcallback(data);
                },
                beforeSend: function (xmlHttpRequest) {
                    ajaxSyncFlag = false;
                    xmlHttpRequest.setRequestHeader("AJAX", "true");
                }
                , complete: function () {
                    ajaxSyncFlag = true;
                }
            });
        }
    };

    /**
     DELETE Ajax
     data : 데이터
     url : Controller 경로
     callback : 성공 callback 함수
     errorcallback : 실패 callback 함수
     async : 동기/비동기 여부 (비동기: true(default) 동기: false)
     */
    $.deleteAjax = function (data, url, callback, errorcallback, async) {
        var ajaxSyncFlag = true;
        var asyncVal = true;

        if (async !== "") {
            asyncVal = async;
        }

        if (ajaxSyncFlag) {
            $.ajax({
                url: url,
                async: asyncVal,
                type: 'DELETE',
                data: data,
                dataType: 'json',
                success: function (data) {
                    callback(data);
                },
                error: function (data) {
                    errorcallback(data);
                },
                beforeSend: function (xmlHttpRequest) {
                    ajaxSyncFlag = false;
                    xmlHttpRequest.setRequestHeader("AJAX", "true");
                }
                , complete: function () {
                    ajaxSyncFlag = true;
                }
            });
        }
    };

    /**
     MultiPart Ajax
     data : 데이터
     url : Controller 경로
     callback : 성공 callback 함수
     errorcallback : 실패 callback 함수
     async : 동기/비동기 여부 (비동기: true(default) 동기: false)
     */
    $.multiPartAjax = function (data, url, callback, errorcallback, async) {
        var ajaxSyncFlag = true;
        var asyncVal = true;

        if (async !== "") {
            asyncVal = async;
        }

        if (ajaxSyncFlag) {
            $.ajax({
                url: url,
                async: asyncVal,
                type: 'POST',
                data: data,
                dataType: 'json',
                processData: false,
                contentType: false,
                success: function (data) {
                    callback(data);
                },
                error: function (data) {
                    errorcallback(data);
                },
                beforeSend: function (xmlHttpRequest) {
                    ajaxSyncFlag = false;
                    xmlHttpRequest.setRequestHeader("AJAX", "true");
                }
                , complete: function () {
                    ajaxSyncFlag = true;
                }
            });
        }
    };

    /**
     함수명 : isblank
     설 명 : 주어진 객체가 NULL인지 or blank인지 학인하여 맞으면 true, 아니면 false를 리턴한다.
     obj  : null or blank 인지  아닌지 확인할 객체
     boolean : 객체가 null이면 true, 아니면 false를 리턴한다.
     ex) appJs.isblank('20150501') -> true
     */
    $.isblank = function(obj) {
        return (obj == null || obj == undefined || obj == "undefined" || obj === null || typeof obj === 'undefined'  || $.trim(obj) == ""
            ||( obj != null && typeof obj == "object" && !Object.keys(obj).length ));
    };

    /**
     함수명 : replaceNull
     설 명 : 주어진 문자열이 null이면 ""를 돌려주고 아니면 객체본래의 값을 돌려준다.
     obj  : null or blank 인지 아닌지 확인할 객체
     String : 전달값이 null이면 ""를 아니면 본래의 전달값을 리턴한다.
     ex) appJs.replaceNull(null) -> "", appJs.replaceNull("사랑해") -> "사랑해"
     */
    $.replaceNull = function(obj) {
        var result="";
        if (obj == null || obj==undefined || obj === null || typeof obj === 'undefined' || $.trim(obj) == ""){
            result="";
        }else{
            result=obj;
        }
        return result;
    };

    /**
     함수명 : replaceNullToStr
     설 명 : 주어진 문자열이 null이면 변환할 문자열을 돌려주고 아니면 객체본래의 값을 돌려준다.
     obj  : null or blank 인지 아닌지 확인할 객체
     str  : null or blank 일 경우 반환할 문자열
     String : 전달값이 null이면 변환할 문자열을, 아니면 본래의 전달값을 리턴한다.
     */
    $.replaceNullToStr = function(obj, str) {
        var result="";
        if (obj==null || obj==undefined || obj === null || typeof obj === 'undefined' || $.trim(obj) == ""){
            result=str;
        }else{
            result=obj;
        }
        return result;
    };

    /**
     함수명 : checkEmail
     설 명 : 이메일 형식 체크
     str  : 체크할 문자
     boolean : 전달값이 이메일 형식이면 true 아니면 false를 리턴한다.
     */
    $.checkEmail = function(str) {
        var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/gi;
        var email = "";

        if(!$.isblank(str)) email = str;

        return regExp.test($.trim(email));
    };

    /**
     함수명 : checkPw
     설 명 : 비밀번호 형식 체크
     str  : 체크할 문자
     boolean : 전달값이 조건에 맞으면 true 아니면 false를 리턴한다.
     * 8~16자의 영문 숫자, 특수문자를 조합하여 입력해주세요.
     * 동일한 문자/숫자 3자리 이상은 입력이 불가합니다.
     */
    $.checkPw = function(str) {
        let check = {};
        let regExp = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[!@#$%^&*=-]).{8,16}$/g;
        let regExp2 = /[^a-zA-z|^0-9|^!@#$%^&*()=_+-]/g;
        let regExp3 = /(\w)\1\1/g;
        let pw = str;

        if($.isblank(pw)) return false;

        if(regExp.test(pw)) check.t1 = true;
        else check.t1 = false;

        if(!regExp2.test(pw)) check.t2 = true;
        else check.t2 = false;

        if(!regExp3.test(pw)) check.t3 = true;
        else check.t3 = false;

        return check;
    };

})(jQuery);