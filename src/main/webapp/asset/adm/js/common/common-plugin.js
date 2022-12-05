/**
  * ITNES Project
  * Copyright 2019 itnes.co.kr
  *
  * @menu : 공통 플러그인 
  * @since : 2021. 2. 18.
  * @author : LEE JI HO (miraclecat@itnes.co.kr)
  */
(function($){

	/**
		GET Ajax
		data : 데이터
		url : Controller 경로
		callback : 성공 callback 함수
		errorcallback : 실패 callback 함수
		async : 동기/비동기 여부 (비동기: true(default) 동기: false)
	 */
    $.getAjax = function(data,url,callback, errorcallback,async){
		var ajaxSyncFlag = true;
		var asyncVal = true;
		
    	if(async !== ""){
    		asyncVal = async;
    	}
    	
    	if(ajaxSyncFlag){
        	$.ajax({
        		url: url,
        		async: asyncVal,
        		type: 'GET',
        		data: data,
        		dataType: 'json',
        		success: function(data) {
        			callback(data);
        		},
        		error: function(data) {
        			errorcallback(data);
        		},
        		beforeSend:function(xmlHttpRequest){
        			ajaxSyncFlag = false;
        			xmlHttpRequest.setRequestHeader("AJAX","true");
        		}
        		,complete:function(){
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
    $.postAjax = function(data,url,callback, errorcallback,async){
		var ajaxSyncFlag = true;
		var asyncVal = true;
		
    	if(async !== ""){
    		asyncVal = async;
    	}
    	
    	if(ajaxSyncFlag){
        	$.ajax({
        		url: url,
        		async: asyncVal,
        		type: 'POST',
        		data: data,
        		dataType: 'json',
        		success: function(data) {
        			callback(data);
        		},
        		error: function(data) {
        			errorcallback(data);
        		},
        		beforeSend:function(xmlHttpRequest){
        			ajaxSyncFlag = false;
        			xmlHttpRequest.setRequestHeader("AJAX","true");
        		}
        		,complete:function(){
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
    $.putAjax = function(data,url,callback, errorcallback,async){
		var ajaxSyncFlag = true;
		var asyncVal = true;
		
    	if(async !== ""){
    		asyncVal = async;
    	}
    	
    	if(ajaxSyncFlag){
        	$.ajax({
        		url: url,
        		async: asyncVal,
        		type: 'PUT',
        		data: data,
        		dataType: 'json',
        		success: function(data) {
        			callback(data);
        		},
        		error: function(data) {
        			errorcallback(data);
        		},
        		beforeSend:function(xmlHttpRequest){
        			ajaxSyncFlag = false;
        			xmlHttpRequest.setRequestHeader("AJAX","true");
        		}
        		,complete:function(){
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
    $.patchAjax = function(data,url,callback, errorcallback,async){
		var ajaxSyncFlag = true;
		var asyncVal = true;
		
    	if(async !== ""){
    		asyncVal = async;
    	}
    	
    	if(ajaxSyncFlag){
        	$.ajax({
        		url: url,
        		async: asyncVal,
        		type: 'PATCH',
        		data: data,
        		dataType: 'json',
        		success: function(data) {
        			callback(data);
        		},
        		error: function(data) {
        			errorcallback(data);
        		},
        		beforeSend:function(xmlHttpRequest){
        			ajaxSyncFlag = false;
        			xmlHttpRequest.setRequestHeader("AJAX","true");
        		}
        		,complete:function(){
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
    $.deleteAjax = function(data,url,callback, errorcallback,async){
		var ajaxSyncFlag = true;
		var asyncVal = true;
		
    	if(async !== ""){
    		asyncVal = async;
    	}
    	
    	if(ajaxSyncFlag){
        	$.ajax({
        		url: url,
        		async: asyncVal,
        		type: 'DELETE',
        		data: data,
        		dataType: 'json',
        		success: function(data) {
        			callback(data);
        		},
        		error: function(data) {
        			errorcallback(data);
        		},
        		beforeSend:function(xmlHttpRequest){
        			ajaxSyncFlag = false;
        			xmlHttpRequest.setRequestHeader("AJAX","true");
        		}
        		,complete:function(){
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
    $.multiPartAjax = function(data,url,callback, errorcallback,async){
		var ajaxSyncFlag = true;
		var asyncVal = true;
		
    	if(async !== ""){
    		asyncVal = async;
    	}
    	
    	if(ajaxSyncFlag){
        	$.ajax({
        		url: url,
        		async: asyncVal,
        		type: 'POST',
        		data: data,
        		dataType: 'json',
				processData: false,
				contentType: false,
        		success: function(data) {
        			callback(data);
        		},
        		error: function(data) {
        			errorcallback(data);
        		},
        		beforeSend:function(xmlHttpRequest){
        			ajaxSyncFlag = false;
        			xmlHttpRequest.setRequestHeader("AJAX","true");
        		}
        		,complete:function(){
        			ajaxSyncFlag = true;
        		}
        	});
    	}
    };


})(jQuery);