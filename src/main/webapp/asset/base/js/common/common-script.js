common = {};
common.script = function() { 
	return {
		
		// 기본 실행 init 함수
		init : function() {
			
			// form submit 방지 스크입트
			$('input[type="text"]').keydown(function() {
			    if (event.keyCode === 13) {
			        event.preventDefault();
			    }
			});
			
		},	
		
		 /* layer 팝업 공통 
		  *  id : 팝업 아이디 commonPopup.jsp
		  *  cont : 내용 <div>내용</div>
		  *  title : 타이틀 이름
		  *  loc : 페이지 url
		  *  func : 함수 실행
		  * */
		 pop_msg : function(id,cont,title,loc,func){
			 
			var popItem = id;
			popItem = '#' + id;
			
			$(popItem).fadeIn();	
			
			//타이틀 기본 & 커스텀
			if(title == "" || title == undefined){} else {
				$(popItem).find(".popTitle").find("div").html(title);
			}
			//내용 기본 & 커스텀
			if(cont == "" || cont == undefined){} else {
				$(popItem).find(".popCont").empty();
				$(popItem).find(".popCont").append(cont);
			}			
			//alert 창 닫기 & 이동 커스텀 & 실행 function
			$('.button_customalert').off().on('click', function() {
				$(popItem).fadeOut();
				if(loc == "" || loc == undefined){} else {
					$(location).attr('href',loc);
				}
				if(func == "" || func == undefined){} else {
					func();
				}
			});			
			//confirm 창 닫기
			$('.cancel').off().on('click', function() {
				$(popItem).fadeOut();
			});
			
		},
		
		 /* layer 팝업 끄기 */
		pop_confirm_close : function(id){
			// 팝업 끄기
			$("#"+id).fadeOut();
		},
		
		/* 체크박스 전체 선택 해제  */
		all_check : function(){
			if($("#chk_all").prop("checked")) {
				// 해당화면에 전체 checkbox들을 체크해준다
				$("input[type=checkbox]").prop("checked",true);
				// 전체선택 체크박스가 해제된 경우
			}else{
				// 해당화면에 모든 checkbox들의 체크를해제시킨다.
				$("input[type=checkbox]").prop("checked",false);
			}
		},
		
		/* NULL 체크 */
		check_null : function (objParam, comment) {
			if ($.trim(objParam.val()).length > 0) {
				return true;
			} else {
				common.script.pop_msg(comment + "을(를) 확인 해주세요.","pop_alert");
				objParam.focus();
				return false;
			}
		},
		
		/* 글자수 제한 */
		check_text : function(id, len){
			$('#'+id).on('keyup', function() {
		        if($(this).val().length > len) {
		        	common.script.pop_msg(len + " 자 이상 입력 하실 수 없습니다.","pop_alert");
		        	$('#'+id).blur();
					return $('#'+id).val("");
		        }
		    });
		},
		
		/* 숫자만 입력 */
		onlyNumber : function(obj){
	         $(obj).val($(obj).val().replace(/[^0-9]/g,"").replace(/(^0+)/, ""));
		},
		
		/* 숫자만 입력 앞에 0 가능 */
		onlyNumberZero : function(obj){
			$(obj).val($(obj).val().replace(/[^0-9]/g,""));
		},

		/* 실수만 입력 */
		onlyFloat : function(obj){
			$(obj).val($(obj).val().replace(/[^\d.]/g,"").replace(/(^0+)/, ""));
		},
		
		/* 실수만 입력 앞에 0 가능*/
		onlyFloatZero : function(obj){
			$(obj).val($(obj).val().replace(/[^\d.]/g,""));
		},
		
		/* 실수만 입력 */
		onlyFloatDecimal : function(obj,num){
			var re = new RegExp("^\\d*\\.?\\d{0,"+num+"}$");
			var objVal = $(obj).val().replace(/[,]/g,"");
			if(!re.test(objVal)){
				$(obj).val("");
			}
		},
		
		/* 소수점 자리수 표시 (버림) ID로 반환 */
		decimalPointId : function(obj,num){
			var regNum =  $(obj).val().replace(/[,]/g,"");
			var regExp = new RegExp("\\d+(?:[.]\\d{0,"+ num +"})?","g");
			regNum = regExp.exec(regNum);
			$(obj).val(regNum);
		},
		
		/* 소수점 자리수 표시 (버림) return String*/
		decimalPointVal : function(value,num){
			var regExp = new RegExp("\\d+(?:[.]\\d{0,"+ num +"})?","g");
			return regExp.exec(value);			
		},
		
		/* 수량체크 */
		check_cnt : function (objParam) {
				if(Number(objParam) > 0 && objParam != ""){
					return true;
				}else{
					common.script.pop_msg("수량을 확인해 주세요.","pop_alert");
					return false;
				}
		},
		
		// 달력 리셋 버튼
		time_st_reset : function(){
			$("#timeStart").val("");
		},
		
		// 특수문자 제한
		checkNumber : function(){ 
			var objEv = event.srcElement;
			var num ="{}[]()<>?_|~`!@#$%^&*()-+\"'\\/";    // 입력을 막을 특수문자 기재.
			event.returnValue = true;
			 
			for (var i=0;i<objEv.value.length;i++)
			{
			if(-1 != num.indexOf(objEv.value.charAt(i)))
			event.returnValue = false;
			}
			 
			if (!event.returnValue)
			{
			 common.script.pop_msg("특수문자는 입력하실 수 없습니다.","pop_alert");
			 objEv.blur();
			 objEv.value="";
			}
		},
		
		/* 영문만 입력 */
		onlyEng : function(obj){
			$(obj).keyup(function(){
		         $(this).val($(this).val().replace(/[0-9]|[^\!-z]/gi,""));
		    }); 
		},
		// 이미지 클릭시 원본 크기로 팝업 보기
		doImgPop : function(img){ 
			 img1= new Image(); 
			 img1.src=(img); 
			 common.script.imgControll(img); 
		 }, 
		  
		/* 날짜 범위 선택 조회 기간 설정 */
		searchDateMax : function(comment, rangeDate){
				var t1 = $('input#timeStart').val().split("-");
			    var t2 = $('input#timeEnd').val().split("-");
			    var t1date = new Date(t1[0], t1[1], t1[2]);
			    var t2date = new Date(t2[0], t2[1], t2[2]);
			    var diff = t2date - t1date;
			    var currDay = 24 * 60 * 60 * 1000;
			    if(parseInt(diff/currDay) > rangeDate){
			        common.script.pop_msg(comment + " 조회 기간은 " + rangeDate + " 일을 초과할 수 없습니다.","pop_alert");
			        return false;
			    }else{
			    	return true;
			    }
		},
		 
		/* 현재날짜 가져오기 */
		today : function(type){
	         var date = new Date();
	         var year  = date.getFullYear();
	         var month = date.getMonth() + 1; 	// 0부터 시작하므로 1더함 더함
	         var day   = date.getDate();
	         var dateStr = "";
	     
	         if (("" + month).length == 1) { month = "0" + month; }
	         if (("" + day).length   == 1) { day   = "0" + day;   }
	         
	         if(type!=""){
	        	 dateStr = year+type+month+type+day
	         }else{
	        	 dateStr = year + month + day;
	         }
	         
	         return dateStr;
	    },
	    
	    /* 전화번호 - 넣어주기 */
	    phoneFormat : function(obj,num){
	    	if(num.length > 0){
	    		var replaceNum = num.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,"$1-$2-$3");
		    	$(obj).val(replaceNum);
	    	}
	    },
	    
	    /* 숫자만 추출 */
	    getNumberOnly : function(str){
	    	return str = str.toString().replace(/[^0-9]/g,'');
	    },

	     /* 천단위 콤마 */
		addComma : function(x) {
			var rx = "";
			
			if(x != null){
				x = x.toString();
				// 소수점이 존재 하는 경우
				if(x.indexOf(".") != -1){
					rx = x.split(".");
					return rx2 = rx[0].toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+"."+rx[1];
				}else{
					return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
				}
			}
		},
		
	     /* .00인 경우 tag 추가 */
		zeroReplace : function(x) {
			
			var sTag = "<font color=\"blue\">.";
			var eTag = "</font>";
			var rx = "";
			
			if(x.length > 0){
				
				if(x.indexOf(".") != -1){
					
					rx = x.split(".");
					
					if(rx[1] == "00"){
						rx = rx[0];
					}else{
						rx = rx[0]+sTag+rx[1]+eTag;
					}
						
				}else{
					rx = x;
				}
			}
			
		    return rx.toString();
		},
		
		 /* 콤마제거 */
		removeComma : function(str)
		{	
			n = Number(str.replace(/,/g,""));
			return n;
		},
		
		/* 앞에숫자 0 채우고 소수점 두자리 절삭 */
		removeZeroandDecimal : function(str,decimalYn)
		{
			var rx = "";
			var rx1 = "";
			var rx2 = "";
			str = $.trim(str);
			if(str.length > 0){
				if(str.indexOf(".") != -1){
					rx = str.split(".");
					rx1 = rx[0];
					rx2 = rx[1];
					rx1 = rx1.replace(/(^0+)/, "") != "" ? rx1.replace(/(^0+)/, "") : "0";
					rx2 = rx2.substr(0,Exponent);
					rx = rx1+"."+rx2;
				}else{
					rx = str.replace(/(^0+)/, "") != "" ? str.replace(/(^0+)/, "") : "0";	
					rx = Number(rx);
					rx = Math.floor(rx);
				}				
			}
			
			return rx;
		},
		
		/* 소수점 절사 */
		removeZeroandDecimal2 : function(str,Exponent)
		{
			var rx = "";
			var rx1 = "";
			var rx2 = "";
			str = $.trim(str);
			if(str.length > 0){
				if(Exponent == 0 || Exponent == undefined || Exponent == "NaN" || Exponent == ""){
					rx = str.replace(/(^0+)/, "") != "" ? str.replace(/(^0+)/, "") : "0";	
					rx = Number(rx);
					rx = Math.floor(rx);	
				}else{
					if(str.indexOf(".") != -1){
						rx = str.split(".");
						rx1 = rx[0];
						rx2 = rx[1];
						rx1 = rx1.replace(/(^0+)/, "") != "" ? rx1.replace(/(^0+)/, "") : "0";
						rx2 = rx2.substr(0,Exponent);
						rx = rx1+"."+rx2;
					}else{
						rx = str.replace(/(^0+)/, "") != "" ? str.replace(/(^0+)/, "") : "0";					
						rx = Number(rx).toFixed(Exponent).toString();	
					}					
				}
			}
			
			return rx;
		},
		
		/**함수명 : isnull
		 * 설 명 :  주어진 객체가 NULL인지 아닌지를 판단하여 맞으면 TRUE, 아니면 false를 돌려준다.
		 * obj  : null인지 아닌지 확인할 객체
		 * boolean : 객체가 null이면 true, 아니면 false를 리턴한다.
		 * ex) appJs.isnull('20150501') -> true
		 *	*/
		isnull : function(obj) {
			return (obj === null || typeof obj === 'undefined');
		},

		/**함수명 : isblank
		 * 설 명 : 주어진 객체가 NULL인지 or blank인지 학인하여 맞으면 true, 아니면 false를 리턴한다.
		 * obj  : null or blank 인지  아닌지 확인할 객체
		 * boolean : 객체가 null이면 true, 아니면 false를 리턴한다.
		 * ex) appJs.isblank('20150501') -> true
		 * */
		isblank : function(obj) {
			return (obj === null || obj == undefined || typeof obj === 'undefined'  || $.trim(obj) == "" || obj ==  "NaN");
		},

		/**함수명 : replaceNull
		 * 설 명 : 주어진 문자열이 null이면 ""를 돌려주고 아니면 객체본래의 값을 돌려준다.
		 * obj  : null or blank 인지 아닌지 확인할 객체
		 * String : 전달값이 null이면 ""를 아니면 본래의 전달값을 리턴한다.
		 * ex) appJs.replaceNull(null) -> "", appJs.replaceNull("사랑해") -> "사랑해"
		 * */
		replaceNull : function(obj) {
			var result="";
			if (obj==null || obj==undefined || obj === null || typeof obj === 'undefined'){
				result="";
			}else{
				result=obj;
			}
			return result;
		},

		/** 함수명 : replaceNullToStr
		 * 설 명 : 주어진 문자열이 null이면 변환할 문자열을 돌려주고 아니면 객체본래의 값을 돌려준다.
		 * obj  : null or blank 인지 아닌지 확인할 객체
		 * str  : null or blank 일 경우 반환할 문자열
		 * String : 전달값이 null이면 변환할 문자열을, 아니면 본래의 전달값을 리턴한다.
		 * */
		replaceNullToStr : function(obj, str) {
			var result="";
			if (obj==null || obj==undefined || obj === null || typeof obj === 'undefined'){
				result=str;
			}else{
				result=obj;
			}
			return result;
		},
		
		//input text에 글자제거 숫자만 넣기
		inputOnlyNumber : function(event){
			event = event || window.event;
			 var keyID = (event.which) ? event.which : event.keyCode;
		    if ( (keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105) || keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
		        return;
		    else
		        return false;				
		},
		
		//input text에 글자제거 숫자만 넣기 끝
		inputRemoveChar : function(event){
			 event = event || window.event;
			var keyID = (event.which) ? event.which : event.keyCode;
		    if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
		        return;
		    else
		        event.target.value = event.target.value.replace(/[^0-9]/g, "");				
		},
		
		//input text에 0을 숫자 앞에 입력하지 못하게
		zeroNumInput: function(inputValue, type){
			var code = window.event.keyCode;
			
			if(inputValue.indexOf('0') == 0){
				
				if(inputValue.indexOf('.', inputValue.indexOf('0')) == -1){
					
					if(inputValue.length > 1){
						inputValue = inputValue.substring(1);						
						$(type).val(inputValue);						
					}
					
				}
			}
		},
		
		//숫자 4단위 한글로 변환  pWon ='55,000,000,000' 이런 형태로 와야한다.
		setWon : function(pWon) {
		    
			var won  = (pWon+"").replace(/,/g, "");
		    var arrWon  = ["원", "만", "억", "조", "경", "해", "자", "양", "구", "간", "정"];
		    var changeWon = "";
		    var pattern = /(-?[0-9]+)([0-9]{4})/;
		    
		    if(parseFloat(pWon) > 999){
			    while(pattern.test(won)) {          
			        won = won.replace(pattern,"$1,$2");
			    }
			    
			    var arrCnt = won.split(",").length-1;
			    
			    for(var ii=0; ii<won.split(",").length; ii++) {
			        if(arrWon[arrCnt] == undefined) {
			            alert("값의 수가 너무 큽니다.");
			            break;
			    }
			    var tmpwon=0;
				  for(i=0;i<won.split(",")[ii].length;i++){
				   var num1 = won.split(",")[ii].substring(i,i+1);
				   tmpwon = tmpwon+Number(num1);
				  }
				  
				  if(tmpwon > 0){
					  changeWon += won.split(",")[ii]+arrWon[arrCnt]; //55억0000만0000원 이런 형태 방지 0000 다 짤라 버린다
				  }
			        arrCnt--;
			    }
			    
		    }else{
		    	if(parseFloat(pWon) > 0){
		    		changeWon = pWon+"원";
		    	}else{
		    		changeWon = "-";
		    	}
		    }
		 
		    return changeWon;
		
		},
		
		// 원화단위가 일정 금액 밑이면 소수점 두자리까지만 표기
		setSplitNum : function(pWon) {
			var num  = 0;
			
			// 만원보다 작은경우 소수점 둘째자리까지 표기
			if (typeof pWon != "undefined" && parseFloat(pWon) < 10000){
				num = 2
			}
			
			return num;
		}
		
	};
}();