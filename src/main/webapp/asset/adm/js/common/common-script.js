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
			
			var userlang = common.script.checkUserLanguage();	// user language check			
		},	
		 
		// 어레이 버퍼를 처리한다 ( 오직 readAsArrayBuffer 데이터만 가능하다 )
		fixdata : function(data) {
		    var o = "", l = 0, w = 10240;
		    for(; l<data.byteLength/w; ++l) o+=String.fromCharCode.apply(null,new Uint8Array(data.slice(l*w,l*w+w)));
		    o+=String.fromCharCode.apply(null, new Uint8Array(data.slice(l*w)));
		    return o;
		},
		 
		// 데이터를 바이너리 스트링으로 얻는다.
//		getConvertDataToBin : function($data){
//		    var arraybuffer = $data;
//		    var data = new Uint8Array(arraybuffer);
//		    var arr = new Array();
//		    for(var i = 0; i != data.length; ++i) arr[i] = String.fromCharCode(data[i]);
//		    var bstr = arr.join("");
//		 
//		    return bstr;
//		},
		
		/* date select 
		 * type = today || null = 오늘날짜,1주일전 날짜 반환 : lastWeek, 1개월전 날짜 :lastMonth
		 * 
		 * */
		getSelectDate : function(type){
			
			var d = new Date();
			var year  = d.getFullYear();
	        var month = d.getMonth();
	        var day   = d.getDate();
			
			// 전월
			if(type == "preMonth"){
				d.setMonth(month - 1);
				d.setDate("01");
			// 당월
			}else if(type == "toMonth"){
				d.setDate("01");
			// 1주일
			}else if(type == "preWeek"){
			    d.setDate(day - 7);
			// 1개월
			}else if(type == "oneMonth"){
			    d.setMonth(month - 1);
			// 3개월
			}else if(type == "threeMonth"){
				d.setMonth(month - 3);
			// 전달 말일
			}else if(type == "preEndDay"){
				var lastDay = (new Date(year, month, 0)).getDate();
				d.setMonth(month - 1);
				d.setDate(lastDay);
			}
			
			return common.script.getDateStr(d);
		},
		
	    /* 날짜 객체 받아서 문자열로 리턴하는 함수 */
	    getDateStr : function(myDate){
	    	
	    	var year = myDate.getFullYear();
	    	var month = myDate.getMonth() + 1;
	    	var day = myDate.getDate();
	    	
	    	if (("" + month).length == 1) { month = "0" + month; }
		    if (("" + day).length   == 1) { day   = "0" + day;   }
	    	
	    	return (year + '-' + month + '-' + day);
	    },
	    
	    /* 스트링 객체를 받아 date로 리턴하는 함수 */
	    getStringtoDate : function(str){
	    	
	        var y = str.substr(0, 4);
	        var m = str.substr(4, 2);
	        var d = str.substr(6, 2);
	        
	        return new Date(y,m-1,d);
	    },
		
		// datePickerInit 함수(시작날짜 id,종료날짜id,조회기간 설정 범위,날짜포멧yyyy-mm-dd)
		datePickerInit : function(sDateId,eDateId,rDate,type){
			
			var dateType = "";
			var rangeDate = 0;
			var setSdate = "";
			var setEdate = "";
			
			if(rangeDate == "" || typeof rangeDate == "undefined"){
				rangeDate = 365;		// 기본 365일
			}else{
				rangeDate = rDate;
			}

			if(type == "" || typeof type == "undefined"){
				dateType = "yy-mm-dd";
			}else{
				dateType = type;
			}
			
			// 버튼이 있는 경우
			if ($("#"+sDateId+"_Btn").length) {
				$("#"+sDateId+"_Btn").click(function() {
				      $("#"+sDateId).datepicker('show');
				});
			}
			
			// 조회조건 : 날짜항목
			$("#"+sDateId).datepicker({
			    dateFormat: dateType,
			    prevText: '이전 달',
			    nextText: '다음 달',
			    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
			    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
			    dayNames: ['일','월','화','수','목','금','토'],
			    dayNamesShort: ['일','월','화','수','목','금','토'],
			    dayNamesMin: ['일','월','화','수','목','금','토'],
			    showMonthAfterYear: true,
			    changeMonth: true,
			    changeYear: true,
			    yearSuffix: '년',
		        onSelect: function(selectDate){
		        	setEdate = selectDate;
		        } 		//from 선택되었을 때
		    });
			
			// input 두개인 경우
			if(eDateId != ""){
				
				// 버튼이 있는 경우
				if ($("#"+eDateId+"_Btn").length) {
					$("#"+eDateId+"_Btn").click(function() {
					      $("#"+eDateId).datepicker('show');
					});
				}
				
				$("#"+eDateId).datepicker({
					dateFormat: dateType,
				    prevText: '이전 달',
				    nextText: '다음 달',
				    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
				    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
				    dayNames: ['일','월','화','수','목','금','토'],
				    dayNamesShort: ['일','월','화','수','목','금','토'],
				    dayNamesMin: ['일','월','화','수','목','금','토'],
				    showMonthAfterYear: true,
				    changeMonth: true,
				    changeYear: true,
				    yearSuffix: '년',
				    onSelect: function(selectDate){
			        	setEdate = selectDate;
//			        	$("#"+sDateId).datepicker("option", "minDate", $("#"+sDateId).val());
//						$("#"+eDateId).datepicker("option", "minDate", $("#"+sDateId).val());
			        } 
				});
				
			}
			
		},
		
		 viewImage : function(img){ 
			 W=img1.width = 500; 
			 H=img1.height = 500; 
			 O="width="+W+",height="+H+",scrollbars=yes"; 
			 var winHeight = document.body.clientHeight;	// 현재창의 높이
			 var winWidth = document.body.clientWidth;		// 현재창의 너비
			 var winX = window.screenX || window.screenLeft || 0;	// 현재창의 x좌표 
			 var winY = window.screenY || window.screenTop || 0;	// 현재창의 y좌표 
			 var popX = winX + (winWidth - W)/2;
			 var popY = winY + (winHeight - H)/2;
			 
			 // window.open("http://www.google.co.kr","popup","width="+popWidth+"px,height="+popHeight+"px,top="+popY+",left="+popX);
		 
			 imgWin=window.open("","image","width=500px, height=500px,top="+popY+",left="+popX); 
			 imgWin.document.write("<html><head><title>:*:*:*: 이미지상세보기 :*:*:*:*:*:*:</title></head>");
			 imgWin.document.write("<body topmargin=0 leftmargin=0>");
			 imgWin.document.write("<img src="+img+" onclick='self.close()' style='cursor:pointer; width: 100%;height: 100%;' title ='클릭하시면 창이 닫힙니다.'>");
			 imgWin.document.close();
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
		
		/* breadcrumb */
		showBreadcrumb : function(tit, location){
		   var $breadcrumb = $('#breadcrumb');
		   var len = tit.length;
		   
		   for (var i=0; i < len; i++) {
			   $breadcrumb.find('li').eq(i+1).find('span').text('>')
			   			.next().attr('href',location[i]).text(tit[i]);
			   
			   if (len == 1) {
				   	$breadcrumb.find('li').eq(2).hide();
			   		$breadcrumb.find('li').eq(1).addClass('current-item');
			   } else if(len == 2) {
				   $breadcrumb.find('li').eq(2).addClass('current-item');
			   } else {
				   $breadcrumb.find('li').eq(3).addClass('current-item');
			   }
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
		  
		imgControll : function(img){ 
			 if((img1.width!=0)&&(img1.height!=0))
			 { 
				  common.script.viewImage(img); 
			 }else
			 { 
			     controller="common.script.imgControll('"+img+"')"; 
			     intervalID=setTimeout(controller,20); 
			 } 
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
		
		/* "" 값 치환 */
		nvl : function (param, defValue) {
			if(param&&param!="") {
				return param;
			} else {
				return (defValue?defValue:"");
			}
		},
		
		/* date변환 */
		datePatten : function (param, patten) {
			
			var result= "";
			
			if(param!="" && param.length == 8) {
				result =  param.substring(0,4)+patten+param.substring(4,6)+patten+param.substring(6);
			} else {
				result = param;
			}
			
			return result;
		},
		
		// 사업자 번호 패턴 변경
		biznoPatten : function(param, patten){
			var result= "";
			
			if(param!="" && param.length == 10) {
				result =  param.substring(0,3)+patten+param.substring(3,5)+patten+param.substring(5);
			} else {
				result = param;
			}
			
			return result;
		},
		
		/* input box , 표시 */
		number_format : function(data){
			
			var tmp = '';
		    var number = '';
		    var cutlen = 3;
		    var comma = ',';
		    var i;

		    var sign = data.match(/^[\+\-]/);
		    if(sign) {
		        data = data.replace(/^[\+\-]/, "");
		    }

		    len = data.length;
		    mod = (len % cutlen);
		    k = cutlen - mod;
		    for (i=0; i<data.length; i++)
		    {
		        number = number + data.charAt(i);

		        if (i < data.length - 1)
		        {
		            k++;
		            if ((k % cutlen) == 0)
		            {
		                number = number + comma;
		                k = 0;
		            }
		        }
		    }

		    if(sign != null)
		        number = sign+number;

		    return number;	
		},
		
		/* 다음api 주소검색 */
		addressSearch : function(){
			
			var width = 500;
			var height = 600;
			var oriAddr = "";
			 
			if (typeof $("#addr1").val() != "undefined" ){
				oriAddr = $("#addr1").val()+" "+$("#addr2").val();
			}
			
			new daum.Postcode({
				oncomplete: function(data) {
					
					// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
					var extraRoadAddr = ''; // 도로명 조합형 주소 변수
					
					// 법정동명이 있을 경우 추가한다.
					if (data.bname !== '') {
						extraRoadAddr += data.bname;
					}
					// 건물명이 있을 경우 추가한다.
					if (data.buildingName !== '') {
						extraRoadAddr += (extraRoadAddr !== '' ? ', '
								+ data.buildingName : data.buildingName);
					}
					// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraRoadAddr !== '') {
						extraRoadAddr = ' (' + extraRoadAddr + ')';
					}
					// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
					if (fullRoadAddr !== '') {
						fullRoadAddr += extraRoadAddr;
					}
					
					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					//$("#place").val(data.address);
					//document.getElementById("address2").value = "";
					
					$("#zipCd").val(data.zonecode);
					$("#addr1").val(common.script.nvl(data.roadAddress,data.autoroadAddress));
					$("#addr2").val((data.buildingName?data.buildingName+" ":""));
					
				}
			}).open({
			    left: (window.screen.width / 2) - (width / 2),
			    top: (window.screen.height / 2) - (height / 2),
			    popupName: 'daumPostApi', 
			    q: (oriAddr)
			});
		},
		
		//type number일때 maxlength 체크
		lengthCheck : function(object){
		   if (object.value.length > object.maxLength){
			   object.value = object.value.slice(0, object.maxLength);
		   }    
		},
		
		/* 첨부파일 다운로드 */
		downloadFile : function (fileType,fileNm,orifileNm,fileFolder) {
			
			var $fileForm = $('<form></form>');
			var $fileIframe = $('<iframe id="fileIframe" frameBorder="0" width="0" height="0" name="fileIframe" scrolling="no"></iframe>');
			var url = "";
			
			if(fileType == "file"){
				
				var fileNm = $('<input type="hidden" id="fileNm" name="fileNm" value="'+fileNm+'">');
			    var orifileNm = $('<input type="hidden" id="orifileNm" name="orifileNm" value="'+orifileNm+'">');
				var fileFolder = $('<input type="hidden" id="fileFolder" name="fileFolder" value="'+fileFolder+'">');
				
				url = "/common/fileDownload.do";
				
				$fileForm.append(fileNm);
				$fileForm.append(orifileNm);
			    $fileForm.append(fileFolder);
			    
			    $fileForm.attr('target', 'fileIframe');
			
			}else{
				//pdf
				var htmlPdfTag = $("#printArea").html();
				var estCd = $('<input type="hidden" id="estCd" name="estCd" value="'+$("#estCd").val()+'">');
				var htmlTag = $('<input type="hidden" id="htmlTag" name="htmlTag" value="'+htmlPdfTag+'">');
			    
				$fileForm.append(estCd);
				$fileForm.append(htmlTag);
				url = "/common/pdfDownload.do";
				$fileForm.attr('target', '_blank');
			}
			
		    if($("#fileIframe").length == 0) $fileIframe.appendTo('body');
		    
			$fileForm.attr('action', url);
			$fileForm.attr('method', 'post');
			 
		    $fileForm.appendTo('body');
		    $fileForm.submit();
			
		},
		
		// pdf 다운로드
		pdfDownload : function(){
			html2canvas(document.body, {
				  onrendered: function(canvas) {
				 
				    // 캔버스를 이미지로 변환
				    var imgData = canvas.toDataURL('image/png');
				     
				    var imgWidth = 210; // 이미지 가로 길이(mm) A4 기준
				    var pageHeight = imgWidth * 1.414;  // 출력 페이지 세로 길이 계산 A4 기준
				    var imgHeight = canvas.height * imgWidth / canvas.width;
				    var heightLeft = imgHeight;
				     
				        var doc = new jsPDF('p', 'mm');
				        var position = 0;
				         
				        // 첫 페이지 출력
				        doc.addImage(imgData, 'PNG', 0, position, imgWidth, imgHeight);
				        heightLeft -= pageHeight;
				         
				        // 한 페이지 이상일 경우 루프 돌면서 출력
				        while (heightLeft >= 20) {
				          position = heightLeft - imgHeight;
				          doc.addPage();
				          doc.addImage(imgData, 'PNG', 0, position, imgWidth, imgHeight);
				          heightLeft -= pageHeight;
				        }
				 
				        // 파일 저장
				        doc.save('견적서.pdf');
				  }
				});
		},
		
		// 특정 영역 프린트
		printArea : function(elem){
	 		
			$("#"+elem).printThis({
	 			debug : false,
	 			importCSS : true,
	 			loadCSS : "/css/adm/style.css",
	 			pageTitle : "견적서 인쇄",
	 			removeInline : true
	 		});
			
		},
		
		//네비게이션 selected
		selectedMenu : function(idValue){
			$('#'+idValue).addClass("selected");
		},
		
		/** 페이징 네비게이션 
		 *  naviId : 적용ID, goPage : 페이지 번호 클릭시 실행되는 함수, totCnt : 데이터 총 갯수, 
		 *  curPage : 현재 페이지 번호, pageNum : 페이지당 데이터 갯수, naviNum : 네비게이션 번호 노출 갯수
		 * */
		pageNavi : function(naviId, goPage, totCnt, curPage, pageNum, naviNum, mobile){
			
			//총 페이지 갯수				
			var pageCnt = parseInt(totCnt / pageNum) + (totCnt % pageNum > 0 ? 1 : 0); 
			//시작 navi 번호	
			var naviStartNum = (curPage%naviNum) != 0 ? parseInt(curPage/naviNum) * naviNum + 1 : (parseInt(curPage/naviNum)-1) * naviNum + 1;
			//마지막 navi 번호
			var naviEndNum = naviStartNum - 1 + (naviNum > (pageCnt - naviStartNum  + 1) ? (pageCnt - naviStartNum  + 1) : naviNum);
						
			if(mobile){
				if(curPage*1 > 1){
					var previousHtml = '<a href="/support/mobile/notice/'+ (curPage*1 -1) + '" aria-label="Previous" data-page= ' + (curPage -1) + '>';
					previousHtml += '<button type="button" id="left" class="btn btn-primary btn-more">';
					previousHtml +=	'<img src="/images/Arrow_Simple_left.png"></button></a>';
				}else{
					var previousHtml = '<a href="/support/mobile/notice/'+ (curPage*1) + '" aria-label="Previous" data-page= ' + (curPage -1) + '>';
					previousHtml += '<button type="button" id="left" class="btn btn-primary btn-more">';
					previousHtml +=	'<img src="/images/Arrow_Simple_left.png"></button></a>';
				}						
				
				var pageHtml = "";
				
				if(curPage*1 < naviEndNum){
					var nextHtml = '<a href="/support/mobile/notice/'+ (curPage*1 +1) + '" aria-label="Previous" data-page= ' + (curPage +1) + '>';
					nextHtml += '<button type="button" id="left" class="btn btn-primary btn-more">';
					nextHtml += '<img src="/images/Arrow_simple_rightt.png"></button></a>';
				}else{
					var nextHtml = '<a href="/support/mobile/notice/'+ (curPage*1) + '" aria-label="Previous" data-page= ' + (curPage +1) + '>';
					nextHtml += '<button type="button" id="left" class="btn btn-primary btn-more">';
					nextHtml += '<img src="/images/Arrow_simple_rightt.png"></button></a>';
				}
				
			}else{
				
				// FirstHtml & Previous view/hidden
				var naviClass = "link_paging";
				var style = "cursor: pointer;";
				if(curPage == 1 || curPage <= naviNum) {
					naviClass = "w-inline-block";
					style = "";
				}
				
				// Previous 세팅 <
				var previousHtml = '<a class="' + naviClass + '"  aria-label="Previous" data-page= ' + (naviStartNum -1) +' style="' + style + '">';
				previousHtml += '<img src="/images/Arrow_Simple_left.png" width="7" class="img_arrow"></a>';
				
				// NaviBar 세팅			
				var pageHtml = "";
				for (var i = naviStartNum; i <= naviEndNum; i++) {				
					var activeChk = 'link_paging';				
					if(curPage == i) {
						activeChk = 'text_paging'
						pageHtml += '<a class="' + activeChk + '" data-page= "' + i + '" style="cursor:pointer;">';
						pageHtml += i + '</a>';
					} else {
						pageHtml += '<a class="' + activeChk + '" data-page= "' + i + '" style="cursor:pointer;">';
						pageHtml += i + '</a>';
					}
				}
				
				// Next & LastHtml view/hidden
				naviClass = "w-inline-block";
				style = "";
				
				if(naviStartNum + naviNum <= pageCnt) {
					naviClass = "link_paging";
					style = "cursor: pointer";
				}
				
				//  Next 세팅
				var nextHtml = '<a class="' + naviClass + '" aria-label="Next" data-page= ' + (naviEndNum + 1) +' style="' + style + '">';
				nextHtml += '<img src="/images/Arrow_simple_rightt.png" width="7" class="img_arrow"></i></a>';
								
			}	
			var viewHtml = previousHtml  + pageHtml + nextHtml;
			
			$("#"+naviId).empty();
			$("#"+naviId).append(viewHtml);
			
			$(".btn-more").on("click", function(){
		    	var dataPage = $(this).attr("data-page");
		    	goPage(dataPage);
		    });
			
			$(".link_paging").on("click", function(){
		    	var dataPage = $(this).attr("data-page");
		    	goPage(dataPage);
		    });
			
		},
		
		/** 카테고리 셀렉트
		 *	idValue : 셀렉트 박스 ID
		 * categoryCode : 카테고리 코드
		 * type : 1 = a 태그, 2 = option 태그 
		 * funcValue : 셀렉트시 실행시킬 함수
		 * selectValue : 셀렉트한 option selected
		 * */
		selectCategory : function(idValue, pCode, type, funcValue,selectValue){
			
			if(type == "" || typeof type == "undefined"){
				type = '2';
			}
			
			var url = '/common/selectCategory';
			var data = {
				"pCode" : pCode 
				,"idValue" : idValue
			};
			ajaxutil.postAjax(
					data
					,url
					/** 카테고리 셀렉트 성공*/
					,function selectCategoryCallback(data){
						var setCategory = '';
						var idValue = data.idValue;
						
						if(type=='1'){
								setCategory += '<a class="dropdown-link w-dropdown-link" value="" style="cursor:pointer;">전체</a>';
							$.each(data.selectCategory, function(catKey, catVal){
								setCategory += '<a class="dropdown-link w-dropdown-link" value='+catVal.code+' style="cursor:pointer;">'+catVal.category_nm+'</a>';
							});
							$("#" + idValue).empty();
							$("#" + idValue).append(setCategory);
							
							$(".dropdown-link").on("click", function(){
								var choice = $(this).attr('value');								
								//메뉴바 닫기
								$('.w-dropdown').removeAttr('style');
								$('.w-dropdown-toggle').removeClass('w--open');
								$('.w-dropdown-list').removeClass('w--open');
								$('.w-icon-dropdown-toggle').next('div').text($(this).text());
								
								funcValue(choice);
							 });
						} else if (type=='2'){
							
							//$("select#"+ idValue+" option").remove();
							
							$.each(data.selectCategory, function(catKey, catVal){
								if(catVal.code == selectValue){
									setCategory += '<option value='+catVal.code+' selected="selected" style="cursor:pointer;">'+catVal.category_nm+'</option>'
								}else{
									setCategory += '<option value='+catVal.code+' style="cursor:pointer;">'+catVal.category_nm+'</option>'
								}
							});
							$("#" + idValue).append(setCategory);
						}			

					}
					, common.script.errorCallback);			
		},
		
		/** 에러 callback */
		errorCallback : function(data,msg){
			if(msg != ""){
				common.script.pop_msg("pop_common_alert","처리중 오류가 발생하였습니다.\n잠시후 다시 시도해주십시오.","","/");
			}else{
				common.script.pop_msg("pop_common_alert",msg,"","/");
			}
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
		
		betaAlert : function(){
			common.script.pop_msg("pop_common_alert","베타 테스트 기간입니다.<br>베타 테스트 종료 후 찾아뵙겠습니다.<br>감사합니다.");
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
		
		//input text에 글자제거 숫자와 소수점만 넣기 
		inputRemoveChar2 : function(event){
			//console.log("inputRemoveChar2");
			event = event || window.event;
			var keyID = (event.which) ? event.which : event.keyCode;
		    if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) {
		    	//console.log("inputRemoveChar2 - if");
		        return;
		    } else {//
		    	//console.log("inputRemoveChar2 - else");
		        event.target.value = event.target.value.replace(/[^0-9.]/g, "");
		    }
		    //console.log("------------------");
		},
		
		//input text에 정수, 소수만 입력
		onlyNumDecimalInput: function(inputValue, type){
			//var inputValue = window.event.target.value;
			//console.log("------------------");
			//console.log("onlyNumDecimalInput");
			//console.log("inputValue : " + inputValue);
			//console.log("type : " + type);
			var code = window.event.keyCode;
			if(inputValue.indexOf('.') == -1){
				//console.log("onlyNumDecimalInput - inputValue.indexOf('.') == -1");
				if ((code >= 37 && code <= 40) || (code >= 48 && code <= 57) || (code >= 96 && code <= 105)   
						|| code == 110 || code == 190 || code == 8 || code == 9 || code == 13 || code == 46){
					//console.log("onlyNumDecimalInput - inputValue.indexOf('.') == -1 - window.event.returnValue = true");//
					window.event.returnValue = true;
				return;
				}
				//console.log("onlyNumDecimalInput - inputValue.indexOf('.') == -1 - window.event.returnValue = false");
				window.event.returnValue = false;
			}else if(inputValue.indexOf('.') == 0){	
				//console.log("onlyNumDecimalInput - inputValue.indexOf('.') == 0");
				//console.log("inputValue : " + inputValue);
				inputValue = "0" + inputValue;
				//console.log("'0' + inputValue : " + inputValue);				
				//inputValue = Number(inputValue);
				$(type).val(inputValue);
			}else{				
				if ((code >= 37 && code <= 40) || (code >= 48 && code <= 57) || (code >= 96 && code <= 105) || code == 8 || code == 9 || code == 13 ){
					//console.log("onlyNumDecimalInput - else - window.event.returnValue = true");
					window.event.returnValue = true;
				return;
				}
				//console.log("onlyNumDecimalInput - else - window.event.returnValue = false");
				window.event.returnValue = false;
			}
			//console.log("-----------------------------------------");
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
		
		//특정 소수점까지 입력
		inputDecimal : function(inputValue, Exponent, type){
				//console.log("------------------");
				//console.log("inputDecimal");
				//console.log("inputValue : " + inputValue);
				inputValue2 = inputValue.split(".");
				//console.log("inputValue2.split('.') : " + inputValue2.length);
				//console.log("Exponent : " + Exponent);				
				var code = window.event.keyCode;
				if(inputValue2.length == 2){
					//console.log("inputDecimal - inputValue.length == 2");
					if(inputValue2[1].length > (Exponent-1)){
						//console.log("inputValue : " + inputValue);
						inputValue = Number(inputValue);
						//console.log("inputValue : " + inputValue);	
						inputValue = common.script.removeZeroandDecimal2(inputValue, Exponent);
						//inputValue = Math.floor(inputValue*Math.pow(10, Exponent))/Math.pow(10, Exponent);
						//console.log("inputValue : " + inputValue);
						$(type).val(inputValue);
						/*//console.log("inputDecimal - inputValue.length == 2 - inputValue[1].length > (Exponent-1)");
						if ((code >= 37 && code <= 40) || code == 8 || code == 9 || code == 13 ){
							//console.log("inputDecimal - inputValue.length == 2 - inputValue[1].length > (Exponent-1) - window.event.returnValue = true");
							window.event.returnValue = true;
						return;
						}
						//console.log("inputDecimal - inputValue.length == 2 - inputValue[1].length > (Exponent-1) - window.event.returnValue = false");
						window.event.returnValue = false;*/
					}	
				}
				//console.log("------------------------------------")//
		},
		
		// language list		
		viewLanguageList : function(obj){
			// mobile or pc check
			
			/*var mver = false;			
			var id = $(obj).attr('id');
			console.log("id : " + id);			
			if ( id.indexOf('m_') != -1 ){
				// mobile version
				mver = true;
			} else {
				// pc version
				mver = false;
			}*/
			/*(obj).next*/
			if($("#SNS2").is(":visible") ){
				
            	$("#SNS2").slideUp();
				$("#SNS").css({ 'background-image': 'url(/images/icon_drop_up.png)'
								, 'background-position':'right'
								, 'background-repeat':'no-repeat'
				});
            }	
			
			if ($('ul.lang').hasClass('open')){
				$('ul.lang').slideUp().removeClass('open');
			} else {
				$('.lang').slideDown().addClass('open');
			}
		},

		
		// set selected language 
		selectLanguage : function(val){			
			var language = '';
			language = val;		
			$('[data-langNum]').each(function(){
				var str = $.lang[val][$(this).data('langnum')];	
				if ( $(this)[0].tagName == 'INPUT' ){
					$(this).attr('placeholder', str);
				} else {
					$(this).html(str);
				}
			});
			
			/*if ( mver ){
				$('#m_selectedLang').text( $('#m_languageList').find($('.'+val)).text() );
			} else {}*/
			$('#selectedLang').text( $('#languageList').find($('.'+val)).text() );
			
			
			//$('.sel_lang').find('span.lng-txt').text( $('.'+val).text() );
			localStorage.setItem('userlang', val); // save language code
			if ( $('.sel_lang').next('ul.lang').hasClass('open') ){
				$('ul.lang').slideUp().removeClass('open');
			}
			
			// ul setting - height, font-size..
			//setContentSize(val);
		},
		// check language
		checkUserLanguage : function(){
			var _code = localStorage.getItem('userlang');
			if ( _code == 'undefined' || _code == '' || _code == null ){
				_code = 'KR';
				localStorage.setItem('userlang', _code);	// KR:default
			} 
			
			common.script.selectLanguage(_code);
			
			return _code;
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